public class Verb {
    private String presentSimple;
    private String pastSimple;
    private String perfectSimple;
    private String rusName;

    public Verb(String presentSimple, String pastSimple,
                String perfectSimple, String rusName) {
        this.presentSimple = presentSimple;
        this.pastSimple = pastSimple;
        this.perfectSimple = perfectSimple;
        this.rusName = rusName;
    }

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
                "presentSimple='" + presentSimple + '\'' +
                ", pastSimple='" + pastSimple + '\'' +
                ", perfectSimple='" + perfectSimple + '\'' +
                ", rusName='" + rusName + '\'' +
                '}';
    }

}
