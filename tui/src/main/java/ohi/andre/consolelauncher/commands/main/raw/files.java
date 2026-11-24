package ohi.andre.consolelauncher.commands.main.raw;

import android.app.Activity;

import ohi.andre.consolelauncher.R;
import ohi.andre.consolelauncher.TuiHost;
import ohi.andre.consolelauncher.commands.CommandAbstraction;
import ohi.andre.consolelauncher.commands.ExecutePack;

/**
 * Win11 addition (step 11), not part of upstream T-UI: opens the built-in Win11 app "files" (the Win11 file manager) from the terminal.
 * The app is started by the host (TuiHost.Share.openBuiltIn, implemented in :app: TerminalShare.kt). Commands are found by scanning the package and the
 * command name is the class name. Note: commands are matched before app names, so an installed app that is called "files" is launched with
 * `apps -frc files` instead of typing its name. `builtin` lists all built-in apps.
 */
public class files implements CommandAbstraction {

    @Override
    public String exec(ExecutePack pack) throws Exception {
        if (!(pack.context instanceof Activity) || !TuiHost.openBuiltIn((Activity) pack.context, "files")) {
            return pack.context.getString(R.string.tui_builtin_unavailable);
        }
        return null;
    }

    @Override
    public int[] argType() {
        return new int[0];
    }

    @Override
    public int priority() {
        return 3;
    }

    @Override
    public int helpRes() {
        return R.string.tui_help_files;
    }

    @Override
    public String onArgNotFound(ExecutePack pack, int indexNotFound) {
        return null;
    }

    @Override
    public String onNotArgEnough(ExecutePack pack, int nArgs) {
        return null;
    }
}
