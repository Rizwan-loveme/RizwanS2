package com.p065b.p086b.p095c.p099c;

import com.p065b.p086b.p110h.InterfaceC1035z;

/* compiled from: ItemType.java */
/* renamed from: com.b.b.c.c.z */
/* loaded from: classes.dex */
public enum EnumC0873z implements InterfaceC1035z {
    TYPE_HEADER_ITEM(0, "header_item"),
    TYPE_STRING_ID_ITEM(1, "string_id_item"),
    TYPE_TYPE_ID_ITEM(2, "type_id_item"),
    TYPE_PROTO_ID_ITEM(3, "proto_id_item"),
    TYPE_FIELD_ID_ITEM(4, "field_id_item"),
    TYPE_METHOD_ID_ITEM(5, "method_id_item"),
    TYPE_CLASS_DEF_ITEM(6, "class_def_item"),
    TYPE_MAP_LIST(4096, "map_list"),
    TYPE_TYPE_LIST(4097, "type_list"),
    TYPE_ANNOTATION_SET_REF_LIST(4098, "annotation_set_ref_list"),
    TYPE_ANNOTATION_SET_ITEM(4099, "annotation_set_item"),
    TYPE_CLASS_DATA_ITEM(8192, "class_data_item"),
    TYPE_CODE_ITEM(8193, "code_item"),
    TYPE_STRING_DATA_ITEM(8194, "string_data_item"),
    TYPE_DEBUG_INFO_ITEM(8195, "debug_info_item"),
    TYPE_ANNOTATION_ITEM(8196, "annotation_item"),
    TYPE_ENCODED_ARRAY_ITEM(8197, "encoded_array_item"),
    TYPE_ANNOTATIONS_DIRECTORY_ITEM(8198, "annotations_directory_item"),
    TYPE_MAP_ITEM(-1, "map_item"),
    TYPE_TYPE_ITEM(-1, "type_item"),
    TYPE_EXCEPTION_HANDLER_ITEM(-1, "exception_handler_item"),
    TYPE_ANNOTATION_SET_REF_ITEM(-1, "annotation_set_ref_item");


    /* renamed from: w */
    private final int f5323w;

    /* renamed from: x */
    private final String f5324x;

    /* renamed from: y */
    private final String f5325y;

    EnumC0873z(int i, String str) {
        this.f5323w = i;
        this.f5324x = str;
        this.f5325y = (str.endsWith("_item") ? str.substring(0, str.length() - 5) : str).replace('_', ' ');
    }

    /* renamed from: a */
    public int m7439a() {
        return this.f5323w;
    }

    /* renamed from: b */
    public String m7440b() {
        return this.f5324x;
    }

    @Override // com.p065b.p086b.p110h.InterfaceC1035z
    /* renamed from: d */
    public String mo6681d() {
        return this.f5325y;
    }
}
