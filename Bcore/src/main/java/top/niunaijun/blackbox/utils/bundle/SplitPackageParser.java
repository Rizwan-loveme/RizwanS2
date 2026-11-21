package top.niunaijun.blackbox.utils.bundle;

import android.content.pm.PackageParser;

import java.io.File;
import java.io.IOException;
import java.util.List;

import top.niunaijun.blackbox.core.env.BEnvironment;
import top.niunaijun.blackbox.utils.compat.PackageParserCompat;

/**
 * Parses an app that has split APKs with the system PackageParser, as a whole folder.
 *
 * <p>The result has {@code splitNames} and {@code splitCodePaths} filled, the certificates are
 * checked for every split, and all paths (base, splits, ApplicationInfo) point at the real files,
 * not at the temporary folder that was used for parsing.
 */
public final class SplitPackageParser {

    private SplitPackageParser() {
    }

    /**
     * @param baseApk    the base APK
     * @param splitPaths absolute paths of the split APKs (at least one)
     * @throws Throwable what the parser says (different version code in a split, split of another
     *                   package, damaged APK...) or an IOException when the parser did not find
     *                   every split
     */
    public static PackageParser.Package parse(File baseApk, List<String> splitPaths) throws Throwable {
        SplitCluster cluster = SplitCluster.create(BEnvironment.getCacheDir(), baseApk, splitPaths);
        try {
            PackageParser parser = PackageParserCompat.createParser(cluster.dir);
            PackageParser.Package pkg = PackageParserCompat.parsePackage(parser, cluster.dir, 0);
            PackageParserCompat.collectCertificates(parser, pkg, 0);
            pointToRealFiles(pkg, cluster, baseApk, splitPaths.size());
            return pkg;
        } finally {
            cluster.delete();
        }
    }

    /** Replaces the paths in the temp folder with the paths of the real files. */
    private static void pointToRealFiles(PackageParser.Package pkg, SplitCluster cluster, File baseApk,
                                         int expectedSplits) throws IOException {
        String[] clusterSplits = pkg.splitCodePaths;
        int found = clusterSplits == null ? 0 : clusterSplits.length;
        if (found != expectedSplits || pkg.splitNames == null || pkg.splitNames.length != expectedSplits) {
            throw new IOException("The parser found " + found + " of " + expectedSplits
                    + " split files. Check that all splits belong to the same app and version.");
        }
        String[] realSplits = new String[found];
        for (int i = 0; i < found; i++) {
            File real = cluster.original(clusterSplits[i]);
            if (real == null) {
                throw new IOException("unknown split file: " + clusterSplits[i]);
            }
            realSplits[i] = real.getAbsolutePath();
        }
        String base = baseApk.getAbsolutePath();
        pkg.baseCodePath = base;
        pkg.codePath = baseApk.getParent() != null ? baseApk.getParent() : base;
        pkg.splitCodePaths = realSplits;

        // The parser filled ApplicationInfo with the temp folder paths too.
        pkg.applicationInfo.sourceDir = base;
        pkg.applicationInfo.publicSourceDir = base;
        pkg.applicationInfo.splitSourceDirs = realSplits.clone();
        pkg.applicationInfo.splitPublicSourceDirs = realSplits.clone();
        pkg.applicationInfo.splitNames = pkg.splitNames.clone();
    }
}
