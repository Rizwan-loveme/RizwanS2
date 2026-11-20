package androidx.appcompat.app;

import android.util.AttributeSet;
import java.lang.ref.WeakReference;
import java.util.ArrayDeque;
import java.util.Deque;
import org.xmlpull.p291v1.XmlPullParser;
import org.xmlpull.p291v1.XmlPullParserException;

/* compiled from: LayoutIncludeDetector.java */
/* renamed from: androidx.appcompat.app.j */
/* loaded from: classes.dex */
class C0078j {

    /* renamed from: a */
    private final Deque<WeakReference<XmlPullParser>> f664a = new ArrayDeque();

    C0078j() {
    }

    /* renamed from: a */
    boolean m613a(AttributeSet attributeSet) {
        if (attributeSet instanceof XmlPullParser) {
            XmlPullParser xmlPullParser = (XmlPullParser) attributeSet;
            if (xmlPullParser.getDepth() == 1) {
                XmlPullParser m610a = m610a(this.f664a);
                this.f664a.push(new WeakReference<>(xmlPullParser));
                if (m612a(xmlPullParser, m610a)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    private static boolean m612a(XmlPullParser xmlPullParser, XmlPullParser xmlPullParser2) {
        if (xmlPullParser2 != null && xmlPullParser != xmlPullParser2) {
            try {
                if (xmlPullParser2.getEventType() == 2) {
                    return "include".equals(xmlPullParser2.getName());
                }
            } catch (XmlPullParserException e2) {
            }
        }
        return false;
    }

    /* renamed from: a */
    private static XmlPullParser m610a(Deque<WeakReference<XmlPullParser>> deque) {
        while (!deque.isEmpty()) {
            XmlPullParser xmlPullParser = deque.peek().get();
            if (!m611a(xmlPullParser)) {
                return xmlPullParser;
            }
            deque.pop();
        }
        return null;
    }

    /* renamed from: a */
    private static boolean m611a(XmlPullParser xmlPullParser) {
        if (xmlPullParser == null) {
            return true;
        }
        try {
            if (xmlPullParser.getEventType() != 3) {
                return xmlPullParser.getEventType() == 1;
            }
            return true;
        } catch (XmlPullParserException e2) {
            return true;
        }
    }
}
