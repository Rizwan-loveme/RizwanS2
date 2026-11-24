package ohi.andre.consolelauncher.commands.main.raw;

import android.app.Activity;

import ohi.andre.consolelauncher.R;
import ohi.andre.consolelauncher.TuiHost;
import ohi.andre.consolelauncher.commands.CommandAbstraction;
import ohi.andre.consolelauncher.commands.ExecutePack;

/**
 * Created by francescoandreuzzi on 21/05/2017.
 */

public class exit implements CommandAbstraction {
    @Override
    public String exec(ExecutePack pack) throws Exception {
        // Win11 step 8: upstream enabled a dummy HOME app and opened the system launcher chooser (the terminal was the default launcher).
        // Now the terminal is a normal screen of :app: `exit` closes it and the screen below (Win11) comes back.
        // Win11 step 9: when the terminal is the home screen (TERMINAL theme saved) there is no screen below: closing it would only make
        // Android start HOME again, which opens the terminal again; so it says so instead.
        if (TuiHost.isHomeMode()) return pack.context.getString(R.string.tui_exit_home);

        if (pack.context instanceof Activity) {
            final Activity activity = (Activity) pack.context;
            activity.runOnUiThread(activity::finish); // commands may run off the main thread
        }
        return null;
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
        return R.string.tui_help_exit;
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
