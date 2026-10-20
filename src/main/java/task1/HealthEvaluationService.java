package task1;

public class HealthEvaluationService {
    public DiagnosticResult evaluate(Patient patient) {
        double heightMeters = patient.heightCm() / 100.0;
        double bmi = patient.weightKg() / (heightMeters * heightMeters);
        RiskCategory riskCategory;
        if (bmi > 30 || patient.systolicBloodPressure() >= 140) {
            riskCategory = RiskCategory.HIGH;
        } else if (bmi >= 25 || patient.systolicBloodPressure() >= 130) {
            riskCategory = RiskCategory.MODERATE;
        } else {
            riskCategory = RiskCategory.LOW;
        }
        return new DiagnosticResult(bmi, riskCategory);
    }
}
