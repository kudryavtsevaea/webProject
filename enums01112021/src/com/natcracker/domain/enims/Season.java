package com.natcracker.domain.enims;

public enum Season {
    WINTER("холодно"),
    SPRING("тепло"),
    SUMMER("жарко"),
    AUTUMN("слякотно");

    private String description;

    Season(String description) {this.description = description;}

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
