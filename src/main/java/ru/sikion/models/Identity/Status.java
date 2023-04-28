package ru.sikion.models.Identity;

public enum Status {
    FIRED("fired"),
    RECOMMENDED_FOR_PROMOTION("recommended for promotion"),
    PROBATION("probation");
    private final String value;

    private Status(String value) {
        this.value = value;
    }

    public static Status fromString(String value) {
        if (value != null) {
            for (Status pt : Status.values()) {
                if (value.equalsIgnoreCase(pt.value)) {
                    return pt;
                }
            }
        }
        throw new IllegalArgumentException("No such value");
    }
    public String getName() {
        return value;
    }
}
