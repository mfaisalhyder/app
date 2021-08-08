package com.spring.app.constant;

public enum BookStatus {
    PRINTING(1, "In Printing"),
    ON_HOLD(2, "On Hold"),
    PUBLISHED(3, "Published");

    private final Integer key;
    private final String value;

    BookStatus(Integer key, String value) {
        this.key = key;
        this.value = value;
    }

    public Integer getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

}