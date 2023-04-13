package ru.sikion.models.Identity;


public enum HairColor {
    BLACK("\u001B[35m"),
    BLOND("\u001B[34m"),
    BROWN("\u001B[33m"),
    FAIR("\u001B[32m"),
    GINGER("\u001B[30m"),
    GREY("\u001B[36m"),
    RED("\u001B[36m"),
    DYED("\u001B[37m"),
    BALD("\u001B[0m");

    private final String title;

    HairColor(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return this.title;
    }

}