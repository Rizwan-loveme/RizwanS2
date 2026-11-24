package ohi.andre.consolelauncher.commands.main.raw;

import java.io.File;

import ohi.andre.consolelauncher.R;
import ohi.andre.consolelauncher.commands.CommandAbstraction;
import ohi.andre.consolelauncher.commands.ExecutePack;
import ohi.andre.consolelauncher.commands.main.MainPack;
import ohi.andre.consolelauncher.managers.FileManager;
import ohi.andre.consolelauncher.tuils.Tuils;

public class open implements CommandAbstraction {

    @Override
    public String exec(ExecutePack pack) {
        MainPack info = (MainPack) pack;
        File file = info.get(File.class);

        int result = FileManager.openFile(info.context, file);

        if (result == FileManager.ISDIRECTORY) return info.res.getString(R.string.tui_output_isdirectory);
        if (result == FileManager.IOERROR) return info.res.getString(R.string.tui_output_error);

        return Tuils.EMPTYSTRING;
    }

    @Override
    public int helpRes() {
        return R.string.tui_help_open;
    }

    @Override
    public int[] argType() {
        return new int[]{CommandAbstraction.FILE};
    }

    @Override
    public int priority() {
        return 4;
    }

    @Override
    public String onNotArgEnough(ExecutePack pack, int nArgs) {
        MainPack info = (MainPack) pack;
        return info.res.getString(helpRes());
    }

    @Override
    public String onArgNotFound(ExecutePack pack, int index) {
        MainPack info = (MainPack) pack;
        return info.res.getString(R.string.tui_output_filenotfound);
    }

}
