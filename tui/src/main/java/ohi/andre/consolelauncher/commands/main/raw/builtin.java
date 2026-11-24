package ohi.andre.consolelauncher.commands.main.raw;

import android.app.Activity;

import java.util.List;

import ohi.andre.consolelauncher.R;
import ohi.andre.consolelauncher.TuiHost;
import ohi.andre.consolelauncher.commands.CommandAbstraction;
import ohi.andre.consolelauncher.commands.ExecutePack;
import ohi.andre.consolelauncher.tuils.Tuils;

/**
 * Win11 addition (step 11), not part of upstream T-UI: `builtin` lists the built-in apps of Win11 (files, browser, sms, gallery, video, camera, ...),
 * `builtin [name]` opens one. `files`, `gallery`, `browser` and `sms` are also commands of their own. The apps are started by the host
 * (TuiHost.Share, implemented in :app: TerminalShare.kt); without a host the list is empty.
 */
public class builtin implements CommandAbstraction {

    @Override
    public String exec(ExecutePack pack) throws Exception {
        String name = pack.getString();
        if (name != null) name = name.trim();
        if (pack.context instanceof Activity && TuiHost.openBuiltIn((Activity) pack.context, name)) return null;
        return pack.context.getString(R.string.tui_builtin_unknown) + Tuils.SPACE + name + Tuils.NEWLINE + list(pack);
    }

    private String list(ExecutePack pack) {
        TuiHost.Share share = TuiHost.getShare();
        if (share == null) return pack.context.getString(R.string.tui_builtin_unavailable);
        List<String[]> all = share.builtIns();
        StringBuilder sb = new StringBuilder();
        for (String[] b : all) {
            if (sb.length() > 0) sb.append(Tuils.NEWLINE);
            sb.append(b[0]);
            if (!b[0].equalsIgnoreCase(b[1])) sb.append(" (").append(b[1]).append(")");
        }
        return sb.toString();
    }

    @Override
    public int[] argType() {
        return new int[] {CommandAbstraction.PLAIN_TEXT};
    }

    @Override
    public int priority() {
        return 3;
    }

    @Override
    public int helpRes() {
        return R.string.tui_help_builtin;
    }

    @Override
    public String onArgNotFound(ExecutePack pack, int indexNotFound) {
        return list(pack);
    }

    @Override
    public String onNotArgEnough(ExecutePack pack, int nArgs) {
        return list(pack);
    }
}
