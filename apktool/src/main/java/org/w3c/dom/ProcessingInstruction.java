package org.w3c.dom;

/* loaded from: assets/android.dex */
public interface ProcessingInstruction extends Node {
    String getData();

    String getTarget();

    void setData(String str) throws DOMException;
}
