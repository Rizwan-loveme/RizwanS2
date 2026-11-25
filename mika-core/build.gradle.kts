// Mika core (pure JVM Kotlin library: agent loop, model clients, prompts, skills, knowledge, sandbox contracts) as the Win11 module :mika-core.
// Upstream: https://github.com/wangzan101/Mika (module ":core"), pinned in ../mika/UPSTREAM_VERSION + ../mika/UPSTREAM_COMMIT (0.1.52), Apache-2.0, see NOTICE-Mika.md.
//
// The sources are NOT in the project zip: they are cloned at build time into ../mika/upstream/ (tools/fetch-upstream.sh, part 3) and patched there
// (tools/patch-upstream.sh, part 4). This build file only points the source sets at that checkout. The package names stay upstream's
// (com.wangzan101.mika.core...): :mika's Kotlin code imports them.
//
// Differences from upstream's core/build.gradle.kts:
//   * own file (like :ppsspp / :seal), upstream's is not reused: it reads files from the repo root (eval/, docs/, README.md, companions/), runs the README
//     generator, a Go gateway and Python CLI tests, and has a "chatgptCheck" source set: none of that is part of the app
//   * no tests, no `java-test-fixtures` (upstream's testFixtures are only used by upstream's tests)
//   * Kotlin 2.2.10 (root build file; upstream 2.1.20), kotlinx-serialization 1.9.0 (upstream 1.7.3: built for Kotlin 2.2, same as :seal), okhttp 4.12.0 (same),
//     coroutines: the root build file pins kotlinx-coroutines-* to ONE version for every module (upstream 1.10.2), see build.gradle.kts
//   * JVM target 21 like the rest of the project (upstream 17)
//   * kept from upstream: protobuf-lite classes from the OpenTelemetry protos (trace export), and the `knowledgeIndex` task, which scans knowledge/apps,
//     knowledge/sites and skills at build time, validates them (a bad file fails the build) and generates knowledge/index.json (the runtime cannot list resource folders)
//
// Wired in settings.gradle.kts (part 5), together with :mika; -PincludeMika=false leaves both out (see settings.gradle.kts).
import com.google.protobuf.gradle.*

plugins {
    id("org.jetbrains.kotlin.jvm")
    id("org.jetbrains.kotlin.plugin.serialization")
    id("com.google.protobuf")
}

// Upstream checkout (cloned + patched by mika/tools, part 3 / 4)
val mikaUpstream = rootProject.file("mika/upstream")
val coreMain = mikaUpstream.resolve("core/src/main")

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

kotlin {
    compilerOptions {
        jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_21)
    }
}

sourceSets {
    main {
        kotlin.srcDir(coreMain.resolve("kotlin"))
        resources.srcDir(coreMain.resolve("resources"))
    }
}

// OpenTelemetry trace protos (common, resource, trace, trace_service) come from a Maven jar and are unpacked for protoc (as upstream does).
val traceSchemas by configurations.creating { isTransitive = false }
val extractTraceSchemas by tasks.registering(Sync::class) {
    from({ zipTree(traceSchemas.singleFile) }) {
        include(
            "opentelemetry/proto/common/v1/common.proto",
            "opentelemetry/proto/resource/v1/resource.proto",
            "opentelemetry/proto/trace/v1/trace.proto",
            "opentelemetry/proto/collector/trace/v1/trace_service.proto"
        )
    }
    into(layout.buildDirectory.dir("trace-schemas"))
}
sourceSets.main { proto.srcDir(extractTraceSchemas) }

// protoc and the lite runtime must be the same version (generated code needs a runtime that is at least as new as protoc)
val mikaProtobufVersion = "4.36.2"
protobuf {
    protoc { artifact = "com.google.protobuf:protoc:$mikaProtobufVersion" }
    generateProtoTasks {
        // "java" builtin: created by the plugin for some project types, not for others (:ppsspp has to create it), so create it only when missing
        all().configureEach { builtins { maybeCreate("java").option("lite") } }
    }
}

dependencies {
    implementation("com.google.protobuf:protobuf-javalite:$mikaProtobufVersion")
    traceSchemas("io.opentelemetry.proto:opentelemetry-proto:1.11.1-alpha")
    implementation("com.squareup.okhttp3:okhttp:4.12.0")
    // differs: upstream 1.7.3 (built for Kotlin 2.1); this project compiles with Kotlin 2.2.10 (same choice as :seal)
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.9.0")
    // version is set by the project-wide coroutines pin in the root build file
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.9.0")
    implementation("org.apache.commons:commons-compress:1.28.0")
}

// The runtime cannot list resource folders: at build time scan knowledge/apps, knowledge/sites and skills, validate their headers and generate an
// index resource (knowledge/index.json). A file that does not validate fails the build. Same task as upstream, paths point into the checkout.
val knowledgeIndex by tasks.registering(JavaExec::class) {
    val resources = coreMain.resolve("resources")
    val out = layout.buildDirectory.dir("generated/knowledge-index")
    inputs.dir(resources.resolve("knowledge")).withPropertyName("knowledge")
    inputs.dir(resources.resolve("skills")).withPropertyName("skills")
    outputs.dir(out)
    classpath = sourceSets.main.get().output.classesDirs + configurations.runtimeClasspath.get()
    mainClass.set("com.wangzan101.mika.core.learn.knowledge.KnowledgeIndex")
    argumentProviders.add(CommandLineArgumentProvider {
        listOf(resources.absolutePath, out.get().file("knowledge/index.json").asFile.absolutePath)
    })
}
sourceSets.main { resources.srcDir(knowledgeIndex) }

// The checkout is cloned by :mika's task fetchMikaUpstream (part 3, mika/tools/fetch-upstream.sh). Everything that reads it waits for that task:
// the Kotlin compile, the resources, and the knowledge index (which reads the resources folder directly).
tasks.configureEach {
    if (name == "compileKotlin" || name == "processResources" || name == "knowledgeIndex") {
        dependsOn(":mika:fetchMikaUpstream")
    }
}
