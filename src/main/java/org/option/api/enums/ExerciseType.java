package org.option.api.enums;

/**
 * Created by marti on 23/02/2017.
 */
public enum ExerciseType {

    EUROPEAN("European"), AMERICAN("American");

    private String exercise = "";

    ExerciseType(final String exercise) {
        this.exercise = exercise;
    }

    public String getExercise() {
        return exercise;
    }

    @Override
    public String toString() {
        return "ExerciseType{" +
                "exercise='" + exercise + '\'' +
                '}';
    }
}
