# Mika (Rizwan) — part 13 of 15: static checks

No Kotlin, Gradle, manifest, workflow or resource file was changed (nothing needed fixing). New: the script `mika/tools/static-check.py` and this file; the three docs were updated.

## Steps done
- [x] 1. Noted the step in memory
- [x] 2. Workflows and scripts: YAML, `bash -n` of every `run:` step, `ast` of every Python tool
- [x] 3. XML well-formed (project and patched Mika) and resource-name clashes between every module and `:mika`
- [x] 4. Gradle / settings / manifest match, stubs vs the real members, documentation file names
- [x] 5. Fixed what was found: nothing was found (see the note on Kotlin braces below)
- [x] 6. Wrote `mika/tools/static-check.py` (the same checks, repeatable) and tested it, positive and negative
- [x] 7. Updated `docs/CHANGES-mika.md`, `mika/README.md`, `README.md`; flat zip `RizwanS2-main-mika-step13.zip`

## Results (project of step 12 + the real upstream 0.1.52, patched)
| Group | Checked | Result |
|---|---|---|
| 1 workflows | 6 files, 69 `run:` steps (YAML + `bash -n`) | OK |
| 2 scripts | 9 shell (`bash -n`), 10 Python (`ast`) | OK |
| 3 XML | 627 project files, 1000 patched Mika files | all well-formed |
| 4 resources | 14 modules with `res/` compared with `:mika` (strings, plurals, drawables, xml, mipmap, id, style, color) | 0 clashes |
| 5 stubs | `MikaLauncher`: `SECTION`, `NAME`, `isSupported`, `open`; `AppBase`: `startMikaIfUsed`, `startMikaNow`, `isMikaSupported` | stubs have all of them |
| 6 Kotlin | `AppBase`, `MikaLauncher`, `App`, `StartApps`, `Win11Shell`, `MainActivity`, `TerminalShare` | `{}` and `()` balanced |
| 7 Gradle | both modules included, `:app` dependency present; simulating the "without" workflow's `drop_module mika mika-core` | files stay valid (empty `if` blocks), no Mika line left |
| 8 strings | `chat_greeting` | 13 / 13 files say "Hey Rizwan"; the only "Mika" words left in resources are the upstream GitHub URLs (`mcp_cli_install_prompt`, `mcp_usb_client_instructions`) and the internal style name `Theme.Mika`, kept on purpose |
| 9 files | `mika/tools` | LF only, `*.sh` executable |
Also read: every file name written in the Mika docs. The ones that do not exist in the project are files of upstream Mika (`MikaApp.kt`, `UpdateChecker.kt`, `LicensesScreen.kt` ...), range shorthands (`part1..11.md`) or build outputs, as intended.

## A scare that was not a defect
My first quick check counted `{` and `}` with a regex and reported three Kotlin files (`Win11Shell.kt`, `MainActivity.kt`, `TerminalShare.kt`) as unbalanced. A tokenizer that skips string literals, raw strings, comments and char literals shows all three balanced (285 / 285, 311 / 311, 18 / 18). The script uses the tokenizer. This also means a regex-only brace check is not a reliable compile substitute; only the real compile (CI) is.

## `mika/tools/static-check.py`
Read-only, needs python3 (+ PyYAML for group 1; skipped with a note if missing) and bash. `python3 mika/tools/static-check.py` from the project root. With `mika/upstream/` (after fetch + patch) groups 3, 4 and 8 also cover the patched Mika; without it they say so and are skipped. Exit code 0 / 1, errors as `::error::static-check: ...`.
Tests: positive on the project alone and on the project + patched upstream (all groups pass). Negative: a stray `}` in `AppBase.kt`, `isSupported` removed from the `MikaLauncher` stub, "Hey Rizwan" removed from one greeting file: each is reported and the exit code is 1.
Not added to the workflows on purpose (the workflows already have their own Mika checks; adding a step is a separate decision for you).

## Not run
Gradle, a compile (the first compile of Mika's 837 Kotlin files is the biggest open risk), a real GitHub Actions run, a real `git fetch` from github.com, a phone.

## Next
Part 14: wake word "Hey Rizwan" (Mika has none; engine decision first) and the persona prompts that still say "You are Mika". Part 15: final flat zip `RizwanS2-main-mika-rizwan.zip`. The docs are read once more after 14.
