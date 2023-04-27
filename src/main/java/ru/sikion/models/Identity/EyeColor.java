package ru.sikion.models.Identity;

public enum EyeColor {
    BLACK("black"),
    BROWn("brown"),
    BLUE("blue"),
    HAZEL("hazel"),
    AMBER("amber"),
    GREEN("green"),
    GRAY("gray");
    private String value;

    private EyeColor(String value) {
        this.value = value;
    }

    public static EyeColor fromString(String value) {
        if (value != null) {
            for (EyeColor pt : EyeColor.values()) {
                if (value.equalsIgnoreCase(pt.value)) {
                    return pt;
                }
            }
        }
        throw new IllegalArgumentException("No such value");
    }
    }
//    BLACK,
//    BROWN,
//    BLUE,
//    HAZEL,
//    AMBER,
//    GREEN,
//    GRAY;

