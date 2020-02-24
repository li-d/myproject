package com.mycompany.common.until;

public class StringHelper {

    public static final String EMPTY = "";

    public static final boolean isBlack(final String value) {
        return value == null || EMPTY.equals(value) ? true : false;
    }
}
