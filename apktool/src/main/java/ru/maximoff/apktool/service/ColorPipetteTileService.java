package ru.maximoff.apktool.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.service.quicksettings.Tile;
import android.service.quicksettings.TileService;
import ru.maximoff.apktool.view.C3310l;

/* loaded from: classes.dex */
public class ColorPipetteTileService extends TileService {
    @Override // android.service.quicksettings.TileService
    public void onClick() {
        try {
            Intent intent = new Intent(this, Class.forName("ru.maximoff.apktool.ColorPipette"));
            intent.addFlags(268435456);
            startActivityAndCollapse(intent);
            getQsTile().updateTile();
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError(e2.getMessage());
        }
    }

    /* renamed from: a */
    public static void m18157a(Context context) {
        try {
            TileService.requestListeningState(context, new ComponentName(context, Class.forName("ru.maximoff.apktool.service.ColorPipetteTileService")));
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError(e2.getMessage());
        }
    }

    @Override // android.service.quicksettings.TileService
    public void onTileAdded() {
        m18156a();
    }

    @Override // android.service.quicksettings.TileService
    public void onStartListening() {
        m18156a();
    }

    /* renamed from: a */
    private void m18156a() {
        Tile qsTile = getQsTile();
        if (qsTile != null) {
            qsTile.setState(C3310l.m19944a() ? 2 : 1);
            qsTile.updateTile();
        }
    }
}
