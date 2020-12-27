package com.lpnu.model.enumeration;

public enum Status {
    WANT_TO_READ("want to read"),
    NOW_READING("now reading"),
    ALREADY_READ("already read");

    private final String text;

    Status(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
