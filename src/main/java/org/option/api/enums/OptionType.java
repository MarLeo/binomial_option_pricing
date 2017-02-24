package org.option.api.enums;

/**
 * Created by marti on 23/02/2017.
 */

public enum OptionType {

    CALL ("Call"), PUT ("Put");

    private String type = "";

    OptionType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "OptionType{" +
                "type='" + type + '\'' +
                '}';
    }
}
