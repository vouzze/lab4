package com.lpnu.model.enumeration;

public enum Achievement {
    INTRUDER("Intruder"),
    PROPHET("Prophet"),
    BOOKMARKER("Bookmarker"),
    EXPERT("Expert"),
    OVERLORD("Overlord");

    private final String text;

    Achievement(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
