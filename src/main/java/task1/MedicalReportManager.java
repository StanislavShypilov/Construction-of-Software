package task1;

public class MedicalReportManager {
    private final PatientValidationService patientValidationService;
    private final HealthEvaluationService healthEvaluationService;
    private final ReportFormattingService reportFormattingService;
    private final ReportStorageService reportStorageService;
    private final NotificationService notificationService;

    public MedicalReportManager(PatientValidationService patientValidationService,
                                HealthEvaluationService healthEvaluationService,
                                ReportFormattingService reportFormattingService,
                                ReportStorageService reportStorageService,
                                NotificationService notificationService) {
        this.patientValidationService = patientValidationService;
        this.healthEvaluationService = healthEvaluationService;
        this.reportFormattingService = reportFormattingService;
        this.reportStorageService = reportStorageService;
        this.notificationService = notificationService;
    }

    public void processPatientDiagnostics(Patient patient) {
        if (patient == null) {
            throw new IllegalArgumentException("Параметр patient не може бути null.");
        }
        patientValidationService.validate(patient);
        DiagnosticResult diagnosticResult = healthEvaluationService.evaluate(patient);
        String jsonReport = reportFormattingService.generateJsonReport(patient, diagnosticResult);
        reportStorageService.saveReport(patient.patientId(), jsonReport);
        if(diagnosticResult.riskCategory() == RiskCategory.HIGH) {
            notificationService.sendCriticalAlert(patient, diagnosticResult.bmi());
        }
    }
}
