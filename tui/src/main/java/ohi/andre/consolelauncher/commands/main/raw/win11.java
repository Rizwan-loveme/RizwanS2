package ohi.andre.consolelauncher.commands.main.raw;

import android.app.Activity;

import ohi.andre.consolelauncher.R;
import ohi.andre.consolelauncher.TuiHost;
import ohi.andre.consolelauncher.commands.CommandAbstraction;
import ohi.andre.consolelauncher.commands.ExecutePack;

/**
 * Win11 addition (step 10), not part of upstream T-UI: the terminal side of the launcher-theme switch.
 * `win11` saves the WIN11 theme, opens the Win11 screen and closes this terminal (the host app does it: TuiHost.Switcher, set by :app).
 * The commands of this package are found by scanning the package and the command name is the class name, so nothing else registers it.
 * The Win11 side of the switch is the two theme cards in the Start menu (ThemeSwitchUi.kt in :app); upstream's colour-theme command is `tuitheme`.
 */
public class win11 implements CommandAbstraction {

    @Override
    public String exec(ExecutePack pack) throws Exception {
        if (!(pack.context instanceof Activity)) return pack.context.getString(R.string.tui_win11_unavailable);
        if (!TuiHost.switchToWin11((Activity) pack.context)) return pack.context.getString(R.string.tui_win11_unavailable);
        return pack.context.getString(R.string.tui_win11_switching);
    }

    @Override
    public int[] argType() {
        return new int[0];
    }

    @Override
    public int priority() {
        return 4;
    }

    @Override
    public int helpRes() {
        return R.string.tui_help_win11;
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
