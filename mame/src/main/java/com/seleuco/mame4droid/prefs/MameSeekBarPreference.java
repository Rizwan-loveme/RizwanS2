package com.seleuco.mame4droid.prefs;

import android.content.Context;
import android.content.res.TypedArray;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import com.seleuco.mame4droid.R;

/**
 * Win11: replacement for the platform class android.preference.SeekBarPreference, which upstream's settings XML used (30 times, tag
 * &lt;SeekBarPreference&gt;). That class is not part of the public SDK (it is missing from android.jar) and upstream only ran on Android 10+;
 * with this module's minSdk 26 and future Android versions it cannot be relied on. Same behaviour as the platform class:
 * attributes android:max (default 100) and android:defaultValue, the value is stored as an Int under android:key, the default is written
 * when nothing is stored yet, android:dependency works. Plus a value label next to the bar.
 */
public class MameSeekBarPreference extends Preference implements SeekBar.OnSeekBarChangeListener {
    private static final String ANDROID_NS = "http://schemas.android.com/apk/res/android";

    private int max = 100;
    private int progress;
    private boolean tracking;
    private TextView valueView;

    public MameSeekBarPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (attrs != null) max = Math.max(1, attrs.getAttributeIntValue(ANDROID_NS, "max", 100));
        setLayoutResource(R.layout.mm_pref_seekbar);
    }

    @Override
    protected Object onGetDefaultValue(TypedArray a, int index) {
        return a.getInt(index, 0);
    }

    @Override
    protected void onSetInitialValue(boolean restoreValue, Object defaultValue) {
        int def = defaultValue instanceof Integer ? (Integer) defaultValue : 0;
        setProgressInternal(restoreValue ? getPersistedInt(def) : def, !restoreValue);
    }

    @Override
    protected void onBindView(View view) {
        super.onBindView(view);
        SeekBar bar = (SeekBar) view.findViewById(R.id.mm_pref_seekbar);
        valueView = (TextView) view.findViewById(R.id.mm_pref_seekbar_value);
        if (bar == null) return;
        bar.setOnSeekBarChangeListener(null);
        bar.setMax(max);
        bar.setProgress(progress);
        bar.setEnabled(isEnabled());
        bar.setOnSeekBarChangeListener(this);
        if (valueView != null) valueView.setText(String.valueOf(progress));
    }

    private void setProgressInternal(int value, boolean persist) {
        value = Math.max(0, Math.min(max, value));
        boolean changed = value != progress;
        progress = value;
        if (persist) persistInt(value);
        if (changed) notifyChanged();
    }

    @Override
    public void onProgressChanged(SeekBar bar, int value, boolean fromUser) {
        if (valueView != null) valueView.setText(String.valueOf(value));
        if (fromUser && !tracking) commit(bar, value);   // keyboard / D-pad steps
    }

    @Override
    public void onStartTrackingTouch(SeekBar bar) {
        tracking = true;
    }

    @Override
    public void onStopTrackingTouch(SeekBar bar) {
        tracking = false;
        commit(bar, bar.getProgress());
    }

    /** Stored once the finger is lifted (not on every step), so the settings listener does not run while dragging. */
    private void commit(SeekBar bar, int value) {
        if (value == progress) return;
        if (callChangeListener(value)) {
            progress = value;
            persistInt(value);
        } else {
            bar.setProgress(progress);
        }
    }
}
