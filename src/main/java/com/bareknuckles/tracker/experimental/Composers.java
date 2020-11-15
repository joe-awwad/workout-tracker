package com.bareknuckles.tracker.experimental;

public class Composers {

    public static SprintingComposer sprinting() {
        return new SprintingComposer();
    }

    public static BoxingComposer boxing() {
        return new BoxingComposer();
    }

    public static StrengthAndConditioningComposer strengthAndConditioning() {
        return new StrengthAndConditioningComposer();
    }
}
