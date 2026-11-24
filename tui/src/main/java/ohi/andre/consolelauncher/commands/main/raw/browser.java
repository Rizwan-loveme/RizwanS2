package ohi.andre.consolelauncher.commands.main.raw;

import android.app.Activity;

import ohi.andre.consolelauncher.R;
import ohi.andre.consolelauncher.TuiHost;
import ohi.andre.consolelauncher.commands.CommandAbstraction;
import ohi.andre.consolelauncher.commands.ExecutePack;

/**
 * Win11 addition (step 11), not part of upstream T-UI: opens the built-in Win11 app "browser" (the Win11 browser) from the terminal.
 * The app is started by the host (TuiHost.Share.openBuiltIn, implemented in :app: TerminalShare.kt). Commands are found by scanning the package and the
 * command name is the class name. Note: commands are matched before app names, so an installed app that is called "browser" is launched with
 * `apps -frc browser` instead of typing its name. `builtin` lists all built-in apps.
 */
public class browser implements CommandAbstraction {

    @Override
    public String exec(ExecutePack pack) throws Exception {
        if (!(pack.context instanceof Activity) || !TuiHost.openBuiltIn((Activity) pack.context, "browser")) {
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
        return R.string.tui_help_browser;
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
