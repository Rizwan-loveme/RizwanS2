package androidx.appcompat.widget;

import android.C0012R;
import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.p006pm.ActivityInfo;
import android.content.p006pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.p008os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.C0059a;
import androidx.core.content.C0255a;
import androidx.p019b.p020a.AbstractC0222c;
import java.p209io.FileNotFoundException;
import java.p209io.IOException;
import java.p209io.InputStream;
import java.util.List;
import java.util.WeakHashMap;

/* compiled from: SuggestionsAdapter.java */
/* renamed from: androidx.appcompat.widget.at */
/* loaded from: classes.dex */
class ViewOnClickListenerC0178at extends AbstractC0222c implements View.OnClickListener {

    /* renamed from: j */
    private final SearchView f1551j;

    /* renamed from: k */
    private final SearchableInfo f1552k;

    /* renamed from: l */
    private final Context f1553l;

    /* renamed from: m */
    private final WeakHashMap<String, Drawable.ConstantState> f1554m;

    /* renamed from: n */
    private final int f1555n;

    /* renamed from: o */
    private boolean f1556o;

    /* renamed from: p */
    private int f1557p;

    /* renamed from: q */
    private ColorStateList f1558q;

    /* renamed from: r */
    private int f1559r;

    /* renamed from: s */
    private int f1560s;

    /* renamed from: t */
    private int f1561t;

    /* renamed from: u */
    private int f1562u;

    /* renamed from: v */
    private int f1563v;

    /* renamed from: w */
    private int f1564w;

    public ViewOnClickListenerC0178at(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap<String, Drawable.ConstantState> weakHashMap) {
        super(context, searchView.getSuggestionRowLayout(), null, true);
        this.f1556o = false;
        this.f1557p = 1;
        this.f1559r = -1;
        this.f1560s = -1;
        this.f1561t = -1;
        this.f1562u = -1;
        this.f1563v = -1;
        this.f1564w = -1;
        this.f1551j = searchView;
        this.f1552k = searchableInfo;
        this.f1555n = searchView.getSuggestionCommitIconResId();
        this.f1553l = context;
        this.f1554m = weakHashMap;
    }

    /* renamed from: a */
    public void m1415a(int i) {
        this.f1557p = i;
    }

    @Override // androidx.p019b.p020a.AbstractC0220a, android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return false;
    }

    @Override // androidx.p019b.p020a.AbstractC0220a, androidx.p019b.p020a.C0221b.a
    /* renamed from: a */
    public Cursor mo1412a(CharSequence charSequence) {
        String charSequence2 = charSequence == null ? "" : charSequence.toString();
        if (this.f1551j.getVisibility() != 0 || this.f1551j.getWindowVisibility() != 0) {
            return null;
        }
        try {
            Cursor m1411a = m1411a(this.f1552k, charSequence2, 50);
            if (m1411a != null) {
                m1411a.getCount();
                return m1411a;
            }
        } catch (RuntimeException e2) {
            Log.m191w("SuggestionsAdapter", "Search suggestions query threw an exception.", e2);
        }
        return null;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        m1408d(mo1612a());
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        m1408d(mo1612a());
    }

    /* renamed from: d */
    private void m1408d(Cursor cursor) {
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras == null || extras.getBoolean(SearchManager.CURSOR_EXTRA_KEY_IN_PROGRESS)) {
        }
    }

    @Override // androidx.p019b.p020a.AbstractC0220a, androidx.p019b.p020a.C0221b.a
    /* renamed from: a */
    public void mo1416a(Cursor cursor) {
        if (this.f1556o) {
            Log.m190w("SuggestionsAdapter", "Tried to change cursor after adapter was closed.");
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        try {
            super.mo1416a(cursor);
            if (cursor != null) {
                this.f1559r = cursor.getColumnIndex(SearchManager.SUGGEST_COLUMN_TEXT_1);
                this.f1560s = cursor.getColumnIndex(SearchManager.SUGGEST_COLUMN_TEXT_2);
                this.f1561t = cursor.getColumnIndex(SearchManager.SUGGEST_COLUMN_TEXT_2_URL);
                this.f1562u = cursor.getColumnIndex(SearchManager.SUGGEST_COLUMN_ICON_1);
                this.f1563v = cursor.getColumnIndex(SearchManager.SUGGEST_COLUMN_ICON_2);
                this.f1564w = cursor.getColumnIndex(SearchManager.SUGGEST_COLUMN_FLAGS);
            }
        } catch (Exception e2) {
            Log.m185e("SuggestionsAdapter", "error changing cursor and caching columns", e2);
        }
    }

    @Override // androidx.p019b.p020a.AbstractC0222c, androidx.p019b.p020a.AbstractC0220a
    /* renamed from: a */
    public View mo1414a(Context context, Cursor cursor, ViewGroup viewGroup) {
        View mo1414a = super.mo1414a(context, cursor, viewGroup);
        mo1414a.setTag(new a(mo1414a));
        ((ImageView) mo1414a.findViewById(C0059a.f.edit_query)).setImageResource(this.f1555n);
        return mo1414a;
    }

    /* compiled from: SuggestionsAdapter.java */
    /* renamed from: androidx.appcompat.widget.at$a */
    private static final class a {

        /* renamed from: a */
        public final TextView f1565a;

        /* renamed from: b */
        public final TextView f1566b;

        /* renamed from: c */
        public final ImageView f1567c;

        /* renamed from: d */
        public final ImageView f1568d;

        /* renamed from: e */
        public final ImageView f1569e;

        public a(View view) {
            this.f1565a = (TextView) view.findViewById(C0012R.id.text1);
            this.f1566b = (TextView) view.findViewById(C0012R.id.text2);
            this.f1567c = (ImageView) view.findViewById(C0012R.id.icon1);
            this.f1568d = (ImageView) view.findViewById(C0012R.id.icon2);
            this.f1569e = (ImageView) view.findViewById(C0059a.f.edit_query);
        }
    }

    @Override // androidx.p019b.p020a.AbstractC0220a
    /* renamed from: a */
    public void mo1417a(View view, Context context, Cursor cursor) {
        CharSequence m1398a;
        a aVar = (a) view.getTag();
        int i = this.f1564w != -1 ? cursor.getInt(this.f1564w) : 0;
        if (aVar.f1565a != null) {
            m1401a(aVar.f1565a, m1398a(cursor, this.f1559r));
        }
        if (aVar.f1566b != null) {
            String m1398a2 = m1398a(cursor, this.f1561t);
            if (m1398a2 != null) {
                m1398a = m1406b((CharSequence) m1398a2);
            } else {
                m1398a = m1398a(cursor, this.f1560s);
            }
            if (TextUtils.isEmpty(m1398a)) {
                if (aVar.f1565a != null) {
                    aVar.f1565a.setSingleLine(false);
                    aVar.f1565a.setMaxLines(2);
                }
            } else if (aVar.f1565a != null) {
                aVar.f1565a.setSingleLine(true);
                aVar.f1565a.setMaxLines(1);
            }
            m1401a(aVar.f1566b, m1398a);
        }
        if (aVar.f1567c != null) {
            m1400a(aVar.f1567c, m1409e(cursor), 4);
        }
        if (aVar.f1568d != null) {
            m1400a(aVar.f1568d, m1410f(cursor), 8);
        }
        if (this.f1557p == 2 || (this.f1557p == 1 && (i & 1) != 0)) {
            aVar.f1569e.setVisibility(0);
            aVar.f1569e.setTag(aVar.f1565a.getText());
            aVar.f1569e.setOnClickListener(this);
            return;
        }
        aVar.f1569e.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.f1551j.m1076a((CharSequence) tag);
        }
    }

    /* renamed from: b */
    private CharSequence m1406b(CharSequence charSequence) {
        if (this.f1558q == null) {
            TypedValue typedValue = new TypedValue();
            this.f1553l.getTheme().resolveAttribute(C0059a.a.textColorSearchUrl, typedValue, true);
            this.f1558q = this.f1553l.getResources().getColorStateList(typedValue.resourceId);
        }
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new TextAppearanceSpan(null, 0, 0, this.f1558q, null), 0, charSequence.length(), 33);
        return spannableString;
    }

    /* renamed from: a */
    private void m1401a(TextView textView, CharSequence charSequence) {
        textView.setText(charSequence);
        if (TextUtils.isEmpty(charSequence)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    /* renamed from: e */
    private Drawable m1409e(Cursor cursor) {
        if (this.f1562u == -1) {
            return null;
        }
        Drawable m1397a = m1397a(cursor.getString(this.f1562u));
        return m1397a == null ? m1407c() : m1397a;
    }

    /* renamed from: f */
    private Drawable m1410f(Cursor cursor) {
        if (this.f1563v == -1) {
            return null;
        }
        return m1397a(cursor.getString(this.f1563v));
    }

    /* renamed from: a */
    private void m1400a(ImageView imageView, Drawable drawable, int i) {
        imageView.setImageDrawable(drawable);
        if (drawable == null) {
            imageView.setVisibility(i);
            return;
        }
        imageView.setVisibility(0);
        drawable.setVisible(false, false);
        drawable.setVisible(true, false);
    }

    @Override // androidx.p019b.p020a.AbstractC0220a, androidx.p019b.p020a.C0221b.a
    /* renamed from: b */
    public CharSequence mo1418b(Cursor cursor) {
        String m1399a;
        String m1399a2;
        if (cursor == null) {
            return null;
        }
        String m1399a3 = m1399a(cursor, SearchManager.SUGGEST_COLUMN_QUERY);
        if (m1399a3 != null) {
            return m1399a3;
        }
        if (this.f1552k.shouldRewriteQueryFromData() && (m1399a2 = m1399a(cursor, SearchManager.SUGGEST_COLUMN_INTENT_DATA)) != null) {
            return m1399a2;
        }
        if (!this.f1552k.shouldRewriteQueryFromText() || (m1399a = m1399a(cursor, SearchManager.SUGGEST_COLUMN_TEXT_1)) == null) {
            return null;
        }
        return m1399a;
    }

    @Override // androidx.p019b.p020a.AbstractC0220a, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i, view, viewGroup);
        } catch (RuntimeException e2) {
            Log.m191w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e2);
            View mo1414a = mo1414a(this.f1553l, mo1612a(), viewGroup);
            if (mo1414a != null) {
                ((a) mo1414a.getTag()).f1565a.setText(e2.toString());
            }
            return mo1414a;
        }
    }

    @Override // androidx.p019b.p020a.AbstractC0220a, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        try {
            return super.getDropDownView(i, view, viewGroup);
        } catch (RuntimeException e2) {
            Log.m191w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e2);
            View b2 = mo1614b(this.f1553l, mo1612a(), viewGroup);
            if (b2 != null) {
                ((a) b2.getTag()).f1565a.setText(e2.toString());
            }
            return b2;
        }
    }

    /* renamed from: a */
    private Drawable m1397a(String str) {
        if (str == null || str.isEmpty() || "0".equals(str)) {
            return null;
        }
        try {
            int parseInt = Integer.parseInt(str);
            String str2 = "android.resource://" + this.f1553l.getPackageName() + "/" + parseInt;
            Drawable m1405b = m1405b(str2);
            if (m1405b == null) {
                Drawable m1847a = C0255a.m1847a(this.f1553l, parseInt);
                m1402a(str2, m1847a);
                return m1847a;
            }
            return m1405b;
        } catch (Resources.NotFoundException e2) {
            Log.m190w("SuggestionsAdapter", "Icon resource not found: " + str);
            return null;
        } catch (NumberFormatException e3) {
            Drawable m1405b2 = m1405b(str);
            if (m1405b2 == null) {
                Drawable m1404b = m1404b(Uri.parse(str));
                m1402a(str, m1404b);
                return m1404b;
            }
            return m1405b2;
        }
    }

    /* renamed from: b */
    private Drawable m1404b(Uri uri) {
        try {
            if (ContentResolver.SCHEME_ANDROID_RESOURCE.equals(uri.getScheme())) {
                try {
                    return m1413a(uri);
                } catch (Resources.NotFoundException e2) {
                    throw new FileNotFoundException("Resource does not exist: " + uri);
                }
            }
            InputStream openInputStream = this.f1553l.getContentResolver().openInputStream(uri);
            if (openInputStream == null) {
                throw new FileNotFoundException("Failed to open " + uri);
            }
            try {
                Drawable createFromStream = Drawable.createFromStream(openInputStream, null);
                try {
                    openInputStream.close();
                    return createFromStream;
                } catch (IOException e3) {
                    Log.m185e("SuggestionsAdapter", "Error closing icon stream for " + uri, e3);
                    return createFromStream;
                }
            } finally {
            }
        } catch (FileNotFoundException e4) {
            Log.m190w("SuggestionsAdapter", "Icon not found: " + uri + ", " + e4.getMessage());
            return null;
        }
        Log.m190w("SuggestionsAdapter", "Icon not found: " + uri + ", " + e4.getMessage());
        return null;
    }

    /* renamed from: b */
    private Drawable m1405b(String str) {
        Drawable.ConstantState constantState = this.f1554m.get(str);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable();
    }

    /* renamed from: a */
    private void m1402a(String str, Drawable drawable) {
        if (drawable != null) {
            this.f1554m.put(str, drawable.getConstantState());
        }
    }

    /* renamed from: c */
    private Drawable m1407c() {
        Drawable m1396a = m1396a(this.f1552k.getSearchActivity());
        return m1396a != null ? m1396a : this.f1553l.getPackageManager().getDefaultActivityIcon();
    }

    /* renamed from: a */
    private Drawable m1396a(ComponentName componentName) {
        String flattenToShortString = componentName.flattenToShortString();
        if (this.f1554m.containsKey(flattenToShortString)) {
            Drawable.ConstantState constantState = this.f1554m.get(flattenToShortString);
            if (constantState == null) {
                return null;
            }
            return constantState.newDrawable(this.f1553l.getResources());
        }
        Drawable m1403b = m1403b(componentName);
        this.f1554m.put(flattenToShortString, m1403b != null ? m1403b.getConstantState() : null);
        return m1403b;
    }

    /* renamed from: b */
    private Drawable m1403b(ComponentName componentName) {
        PackageManager packageManager = this.f1553l.getPackageManager();
        try {
            ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, 128);
            int iconResource = activityInfo.getIconResource();
            if (iconResource == 0) {
                return null;
            }
            Drawable drawable = packageManager.getDrawable(componentName.getPackageName(), iconResource, activityInfo.applicationInfo);
            if (drawable != null) {
                return drawable;
            }
            Log.m190w("SuggestionsAdapter", "Invalid icon resource " + iconResource + " for " + componentName.flattenToShortString());
            return null;
        } catch (PackageManager.NameNotFoundException e2) {
            Log.m190w("SuggestionsAdapter", e2.toString());
            return null;
        }
    }

    /* renamed from: a */
    public static String m1399a(Cursor cursor, String str) {
        return m1398a(cursor, cursor.getColumnIndex(str));
    }

    /* renamed from: a */
    private static String m1398a(Cursor cursor, int i) {
        if (i == -1) {
            return null;
        }
        try {
            return cursor.getString(i);
        } catch (Exception e2) {
            Log.m185e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e2);
            return null;
        }
    }

    /* renamed from: a */
    Drawable m1413a(Uri uri) {
        int identifier;
        String authority = uri.getAuthority();
        if (TextUtils.isEmpty(authority)) {
            throw new FileNotFoundException("No authority: " + uri);
        }
        try {
            Resources resourcesForApplication = this.f1553l.getPackageManager().getResourcesForApplication(authority);
            List<String> pathSegments = uri.getPathSegments();
            if (pathSegments == null) {
                throw new FileNotFoundException("No path: " + uri);
            }
            int size = pathSegments.size();
            if (size == 1) {
                try {
                    identifier = Integer.parseInt(pathSegments.get(0));
                } catch (NumberFormatException e2) {
                    throw new FileNotFoundException("Single path segment is not a resource ID: " + uri);
                }
            } else if (size == 2) {
                identifier = resourcesForApplication.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
            } else {
                throw new FileNotFoundException("More than two path segments: " + uri);
            }
            if (identifier == 0) {
                throw new FileNotFoundException("No resource found for: " + uri);
            }
            return resourcesForApplication.getDrawable(identifier);
        } catch (PackageManager.NameNotFoundException e3) {
            throw new FileNotFoundException("No package found for authority: " + uri);
        }
    }

    /* renamed from: a */
    Cursor m1411a(SearchableInfo searchableInfo, String str, int i) {
        String suggestAuthority;
        String[] strArr;
        if (searchableInfo == null || (suggestAuthority = searchableInfo.getSuggestAuthority()) == null) {
            return null;
        }
        Uri.Builder fragment = new Uri.Builder().scheme(ContentResolver.SCHEME_CONTENT).authority(suggestAuthority).query("").fragment("");
        String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            fragment.appendEncodedPath(suggestPath);
        }
        fragment.appendPath(SearchManager.SUGGEST_URI_PATH_QUERY);
        String suggestSelection = searchableInfo.getSuggestSelection();
        if (suggestSelection != null) {
            strArr = new String[]{str};
        } else {
            fragment.appendPath(str);
            strArr = null;
        }
        if (i > 0) {
            fragment.appendQueryParameter("limit", String.valueOf(i));
        }
        return this.f1553l.getContentResolver().query(fragment.build(), null, suggestSelection, strArr, null);
    }
}
