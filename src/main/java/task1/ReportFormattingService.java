package task1;

import java.time.Instant;

public class ReportFormattingService {
    public String generateJsonReport(Patient patient, DiagnosticResult diagnosticResult) {
        return String.format("{\n  \"PatientId\": \"%s\",\n  \"Name\": \"%s\",\n  \"BMI\": %.2f,\n  \"BloodPressure\": \"%d/%d\",\n  \"Risk Category\": \"%s\",\n  \"GeneratedAt\": \"%s\"\n}",
                patient.patientId(), patient.fullName(), diagnosticResult.bmi(),
                patient.systolicBloodPressure(), patient.diastolicBloodPressure(),
                diagnosticResult.riskCategory(), Instant.now().toString());
    }
}
