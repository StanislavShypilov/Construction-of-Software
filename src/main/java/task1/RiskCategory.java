package task1;

public enum RiskCategory {
    LOW("Низький"), MODERATE("Помірний"), HIGH("Високий");

    final String description;

    RiskCategory(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
