package com.p159h.p160a.p162b;

/* compiled from: LuaTokenTypes.java */
/* renamed from: com.h.a.b.q */
/* loaded from: classes.dex */
public enum EnumC1395q {
    WRONG,
    NL_BEFORE_LONGSTRING,
    WS,
    NEWLINE,
    SHEBANG,
    LONGCOMMENT,
    SHORTCOMMENT,
    LUADOC_COMMENT,
    LONGCOMMENT_BEGIN,
    LONGCOMMENT_END,
    NAME,
    NUMBER,
    STRING,
    LONGSTRING,
    LONGSTRING_BEGIN,
    LONGSTRING_END,
    UNTERMINATED_STRING,
    DIV,
    MULT,
    LPAREN,
    RPAREN,
    LBRACK,
    RBRACK,
    LCURLY,
    RCURLY,
    COLON,
    COMMA,
    DOT,
    ASSIGN,
    SEMI,
    EQ,
    NE,
    PLUS,
    MINUS,
    GE,
    GT,
    EXP,
    LE,
    LT,
    ELLIPSIS,
    CONCAT,
    GETN,
    MOD,
    IF,
    ELSE,
    ELSEIF,
    WHILE,
    WITH,
    THEN,
    FOR,
    IN,
    RETURN,
    BREAK,
    CONTINUE,
    TRUE,
    FALSE,
    NIL,
    FUNCTION,
    DO,
    NOT,
    AND,
    OR,
    LOCAL,
    REPEAT,
    UNTIL,
    END;

    public static EnumC1395q valueOf(String str) {
        for (EnumC1395q enumC1395q : values()) {
            if (enumC1395q.name().equals(str)) {
                return enumC1395q;
            }
        }
        throw new IllegalArgumentException();
    }
}
