package com.p159h.p160a.p161a;

import android.C0012R;
import android.drm.DrmManagerClient;
import android.view.KeyEvent;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import com.p159h.p160a.p162b.AbstractC1389k;
import com.p159h.p160a.p162b.C1386h;
import ru.maximoff.apktool.util.C3102bd;

/* compiled from: TextFieldInputConnection.java */
/* renamed from: com.h.a.a.g */
/* loaded from: classes.dex */
public class C1375g extends BaseInputConnection {

    /* renamed from: a */
    private final int f8951a;

    /* renamed from: b */
    private final int f8952b;

    /* renamed from: c */
    private C1371c f8953c;

    /* renamed from: d */
    private boolean f8954d;

    /* renamed from: e */
    private boolean f8955e;

    /* renamed from: f */
    private int f8956f;

    /* renamed from: g */
    private int f8957g;

    /* renamed from: h */
    private int f8958h;

    /* renamed from: i */
    private int f8959i;

    /* renamed from: j */
    private int f8960j;

    /* renamed from: k */
    private int f8961k;

    public C1375g(C1371c c1371c) {
        super(c1371c, true);
        this.f8951a = 2000;
        this.f8952b = 300;
        this.f8954d = false;
        this.f8955e = false;
        this.f8956f = -1;
        this.f8957g = -1;
        this.f8958h = -1;
        this.f8959i = -1;
        this.f8960j = 0;
        this.f8961k = 0;
        this.f8953c = c1371c;
    }

    /* renamed from: a */
    public void m10971a() {
        this.f8954d = false;
        this.f8958h = -1;
        this.f8959i = -1;
        if (this.f8953c.getDocumentProvider().m11046c()) {
            this.f8953c.getDocumentProvider().m11050e();
        }
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean beginBatchEdit() {
        if (this.f8961k < Integer.MAX_VALUE) {
            this.f8961k++;
            return true;
        }
        return true;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean endBatchEdit() {
        if (this.f8961k > 0) {
            this.f8961k--;
            return true;
        }
        return true;
    }

    /* renamed from: b */
    public int m10972b() {
        if (this.f8954d) {
            return -1;
        }
        return Math.max(0, this.f8961k);
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean performContextMenuAction(int i) {
        switch (i) {
            case C0012R.id.selectAll /* 16908319 */:
            case C0012R.id.startSelectingText /* 16908328 */:
            case C0012R.id.stopSelectingText /* 16908329 */:
                this.f8953c.m10854A();
                break;
            case C0012R.id.cut /* 16908320 */:
                this.f8953c.m10857D();
                break;
            case C0012R.id.copy /* 16908321 */:
                this.f8953c.m10858E();
                break;
            case C0012R.id.paste /* 16908322 */:
                this.f8953c.m10859F();
                break;
        }
        return super.performContextMenuAction(i);
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean sendKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0) {
            return true;
        }
        if (C1372d.m10966b(keyEvent)) {
            if (keyEvent.isShiftPressed() && !this.f8953c.m10920y()) {
                this.f8953c.m10904j();
                this.f8953c.getFieldController().m10953d(true);
            } else if (!keyEvent.isShiftPressed() && this.f8953c.m10920y()) {
                this.f8953c.m10906k();
                this.f8953c.getFieldController().m10953d(false);
            }
        }
        switch (keyEvent.getKeyCode()) {
            case 19:
                this.f8953c.m10914s();
                return true;
            case 20:
                this.f8953c.m10913r();
                return true;
            case 21:
                this.f8953c.m10911p();
                return true;
            case 22:
                this.f8953c.m10912q();
                return true;
            case 67:
                return deleteSurroundingText(1, 0);
            case 112:
                return deleteSurroundingText(0, 1);
            case 122:
                this.f8953c.m10915t();
                return true;
            case 123:
                this.f8953c.m10916u();
                return true;
            default:
                int unicodeChar = keyEvent.getUnicodeChar();
                if (unicodeChar > 0) {
                    return commitText(new String(Character.toChars(unicodeChar)), 1);
                }
                return super.sendKeyEvent(keyEvent);
        }
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public CharSequence getSelectedText(int i) {
        return this.f8953c.getSelection();
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public ExtractedText getExtractedText(ExtractedTextRequest extractedTextRequest, int i) {
        if (extractedTextRequest == null || this.f8953c.getDocumentProvider().m11046c()) {
            return (ExtractedText) null;
        }
        C1386h documentProvider = this.f8953c.getDocumentProvider();
        if (documentProvider.length() == 0) {
            ExtractedText extractedText = new ExtractedText();
            extractedText.text = "";
            extractedText.selectionStart = 0;
            extractedText.selectionEnd = 0;
            extractedText.startOffset = 0;
            extractedText.partialStartOffset = -1;
            extractedText.partialEndOffset = -1;
            extractedText.flags = 0;
            return extractedText;
        }
        int caretPosition = this.f8953c.getCaretPosition();
        if (this.f8956f < 0 || this.f8957g <= this.f8956f) {
            this.f8956f = Math.max(0, caretPosition - 1000);
            this.f8957g = Math.min(documentProvider.length() - 1, this.f8956f + 2000);
            this.f8956f = Math.max(0, this.f8957g + DrmManagerClient.ERROR_UNKNOWN);
        } else if (caretPosition < this.f8956f + 300 || caretPosition > this.f8957g - 300) {
            this.f8956f = Math.max(0, caretPosition - 1000);
            this.f8957g = Math.min(documentProvider.length() - 1, this.f8956f + 2000);
            this.f8956f = Math.max(0, this.f8957g + DrmManagerClient.ERROR_UNKNOWN);
        }
        ExtractedText extractedText2 = new ExtractedText();
        extractedText2.text = documentProvider.subSequence(this.f8956f, this.f8957g - this.f8956f).toString();
        extractedText2.startOffset = this.f8956f;
        extractedText2.selectionStart = this.f8953c.getSelectionStart();
        extractedText2.selectionEnd = this.f8953c.getSelectionEnd();
        extractedText2.partialStartOffset = -1;
        extractedText2.partialEndOffset = -1;
        extractedText2.flags = 0;
        if (documentProvider.m11045c(this.f8956f) == documentProvider.m11045c(this.f8957g)) {
            extractedText2.flags |= 1;
        }
        if (this.f8953c.m10920y()) {
            extractedText2.flags |= 2;
            return extractedText2;
        }
        return extractedText2;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean setComposingRegion(int i, int i2) {
        int caretPosition = this.f8953c.getCaretPosition();
        if (this.f8954d && i != caretPosition && i2 != caretPosition) {
            this.f8958h = caretPosition - (i2 - i);
            this.f8959i = caretPosition;
        } else {
            this.f8958h = i;
            this.f8959i = i2;
        }
        this.f8954d = true;
        return true;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean setComposingText(CharSequence charSequence, int i) {
        int i2;
        int i3;
        if (charSequence == null) {
            charSequence = "";
        }
        if (!this.f8953c.getDocumentProvider().m11046c()) {
            this.f8953c.getDocumentProvider().m11048d();
        }
        int caretPosition = this.f8953c.getCaretPosition();
        if (this.f8953c.m10920y()) {
            int min = Math.min(this.f8953c.getSelectionStart(), this.f8953c.getSelectionEnd());
            this.f8953c.getFieldController().m10944b(min, 0, charSequence.toString());
            i2 = min;
            i3 = min;
        } else if (this.f8958h >= 0 && this.f8959i >= 0) {
            int i4 = this.f8959i - this.f8958h;
            i2 = caretPosition - i4;
            this.f8953c.getFieldController().m10944b(this.f8958h, i4, charSequence.toString());
            i3 = this.f8958h;
        } else {
            this.f8953c.getFieldController().m10944b(caretPosition, 0, charSequence.toString());
            i2 = caretPosition;
            i3 = caretPosition;
        }
        this.f8953c.getFieldController().m10938a(i3 + charSequence.length(), false);
        setComposingRegion(i2, charSequence.length() + i2);
        return true;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean commitText(CharSequence charSequence, int i) {
        if (charSequence == null) {
            charSequence = "";
        }
        if (charSequence.length() > 0 && this.f8953c.m10863J() && charSequence.charAt(charSequence.length() - 1) == '\n') {
            charSequence = new StringBuffer().append((Object) charSequence.subSequence(0, charSequence.length() - 1)).append(String.valueOf(this.f8953c.getFieldController().m10950c())).toString();
        }
        if (this.f8953c.m10920y()) {
            int min = Math.min(this.f8953c.getSelectionStart(), this.f8953c.getSelectionEnd());
            setComposingRegion(min, min);
        } else if (this.f8958h < 0 || this.f8959i < 0) {
            setComposingRegion(this.f8953c.getCaretPosition(), this.f8953c.getCaretPosition());
        }
        this.f8953c.getFieldController().m10944b(Math.min(this.f8958h, this.f8959i), Math.abs(this.f8959i - this.f8958h), charSequence.toString());
        m10971a();
        if (i > 1) {
            this.f8953c.getFieldController().m10933a((this.f8953c.getCaretPosition() + i) - 1);
        } else if (i <= 0) {
            this.f8953c.getFieldController().m10933a((this.f8953c.getCaretPosition() - charSequence.length()) - i);
        }
        return true;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean deleteSurroundingText(int i, int i2) {
        if (this.f8960j > 0) {
            if (i > this.f8960j) {
                i = this.f8960j;
            } else if (i2 > this.f8960j) {
                i2 = this.f8960j;
            }
        }
        this.f8960j = 0;
        this.f8953c.getFieldController().m10934a(i, i2);
        return true;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean finishComposingText() {
        if (this.f8954d) {
            m10971a();
            return true;
        }
        return true;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public int getCursorCapsMode(int i) {
        if (!C3102bd.f18306an) {
            return 0;
        }
        if ((i & 8192) == 8192) {
            int caretPosition = this.f8953c.getCaretPosition() - 1;
            if (caretPosition < 0 || this.f8953c.getLexTask().m11093e().m11081a(this.f8953c.getDocumentProvider().charAt(caretPosition))) {
                return (i & 16384) == 16384 ? 24576 : 8192;
            }
            return 0;
        }
        AbstractC1389k m11093e = this.f8953c.getLexTask().m11093e();
        int caretPosition2 = this.f8953c.getCaretPosition() - 1;
        boolean z = true;
        int i2 = 0;
        while (true) {
            if (caretPosition2 < 0) {
                break;
            }
            char charAt = this.f8953c.getDocumentProvider().charAt(caretPosition2);
            if (charAt == '\n') {
                break;
            }
            if (!m11093e.m11081a(charAt)) {
                if (i2 == 0 || !m11093e.m11082b(charAt)) {
                    z = false;
                }
            } else {
                i2++;
                caretPosition2--;
            }
        }
        return z ? 16384 : 0;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public CharSequence getTextAfterCursor(int i, int i2) {
        return this.f8953c.getFieldController().m10948c(i);
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public CharSequence getTextBeforeCursor(int i, int i2) {
        return this.f8953c.getFieldController().m10951d(i);
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean setSelection(int i, int i2) {
        int length = this.f8953c.getDocumentProvider().length();
        int max = i >= length ? Math.max(0, length - 1) : i;
        int max2 = i2 >= length ? Math.max(0, length - 1) : i2;
        if (max == max2) {
            if (this.f8953c.m10920y()) {
                this.f8960j = this.f8953c.getSelectionRange();
                this.f8953c.getFieldController().m10953d(false);
            }
            if (this.f8956f > 0 && max == this.f8957g - this.f8956f) {
                max = this.f8957g;
            }
            this.f8953c.m10871a(max, false);
        } else {
            int abs = Math.abs(max2 - max);
            if (max2 > max) {
                max2 = max;
            }
            this.f8953c.getFieldController().m10937a(max2, abs, false, true, false);
        }
        return true;
    }
}
