package com.netcracker.lesson;

public class Verbs {
    private long id;
    private String presentSimple;
    private String pastSimple;
    private String perfectSimple;
    private String rusName;

    public Verbs(long id, String presentSimple, String pastSimple,
                 String perfectSimple, String rusName) {
        this.id = id;
        this.presentSimple = presentSimple;
        this.pastSimple = pastSimple;
        this.perfectSimple = perfectSimple;
        this.rusName = rusName;
    }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public String getPresentSimple() {
        return presentSimple;
    }

    public void setPresentSimple(String presentSimple) {
        this.presentSimple = presentSimple;
    }

    public String getPastSimple() {
        return pastSimple;
    }

    public void setPastSimple(String pastSimple) {
        this.pastSimple = pastSimple;
    }

    public String getPerfectSimple() {
        return perfectSimple;
    }

    public void setPerfectSimple(String perfectSimple) {
        this.perfectSimple = perfectSimple;
    }

    public String getRusName() {
        return rusName;
    }

    public void setRusName(String rusName) {
        this.rusName = rusName;
    }


    @Override
    public String toString() {
        return "Verbs{" +
                "id=" + id +
                ", presentSimple='" + presentSimple + '\'' +
                ", pastSimple='" + pastSimple + '\'' +
                ", perfectSimple='" + perfectSimple + '\'' +
                ", rusName='" + rusName + '\'' +
                '}';
    }
}