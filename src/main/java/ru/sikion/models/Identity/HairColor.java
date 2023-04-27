package ru.sikion.models.Identity;


public enum HairColor {
    BLACK("black"),
    BLOND("blond"),
    BROWN("brown"),
    FAIR("fair"),
    GINGER("ginger"),
    GREY("grey"),
    RED("red"),
    DYED("dyed"),
    BALD("bald");

    private String value;

    private HairColor(String value) {
        this.value = value;
    }

    public static HairColor fromString(String value) {
        if (value != null) {
            for (HairColor pt : HairColor.values()) {
                if (value.equalsIgnoreCase(pt.value)) {
                    return pt;
                }
            }
        }
        throw new IllegalArgumentException("No such value");
    }
//    BLACK,
//    BLOND,
//    BROWN,
//    FAIR,
//    GINGER,
//    GREY,
//    RED,
//    DYED,
//    BALD;
}