package ru.maximoff.apktool.service;

import java.util.ListResourceBundle;

/* loaded from: classes.dex */
public class Messages extends ListResourceBundle {

    /* renamed from: a */
    private static final String[][] f17123a = {new String[]{"1", "Unknown type {0}"}, new String[]{"2", "Unknown field {0} of type {1}"}, new String[]{"3", "Unknown method {0} of type {1}"}, new String[]{"4", "Invalid literal value: {0}. Must be between -8 and 7, inclusive."}, new String[]{"13", "Invalid literal value: {0}. Must be between -128 and 127, inclusive."}, new String[]{"5", "Invalid literal value: {0}. Low 16 bits must be zeroed out."}, new String[]{"7", "Invalid literal value: {0}. Must be between -32768 and 32767, inclusive."}, new String[]{"8", "{0} cannot fit into a short."}, new String[]{"9", "There is no '.register' or '.locals' directive defined!"}, new String[]{"10", "Invalid register: {0}. Must be between v0 and v15, inclusive."}, new String[]{"11", "Invalid register: {0}. Must be between v0 and v255, inclusive."}, new String[]{"12", "Invalid register: {0}. Must be between v0 and v65535, inclusive."}, new String[]{"14", "Invalid register count: {0}. Must be between 0 and 255, inclusive."}, new String[]{"15", "Invalid register: {0}. the value is greater than the max {1} defind in '.register' or '.locals' directive."}};

    @Override // java.util.ListResourceBundle
    protected Object[][] getContents() {
        return f17123a;
    }
}
