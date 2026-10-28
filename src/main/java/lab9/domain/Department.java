package lab9.domain;

public enum Department {
    ADMISSIONS("Приймальне відділення"), SURGERY("Хірургія"), THERAPY("Терапія"), CARDIOLOGY("Кардіологія"), DIAGNOSTICS("Діагностика");
    private final String label;

    Department(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
