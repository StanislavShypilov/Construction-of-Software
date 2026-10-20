package task1;

import java.io.FileWriter;
import java.io.IOException;

public class ReportStorageService {
    public void saveReport(String patientId, String jsonReport) {
        String filename = "medical_report_" + patientId + ".json";
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(jsonReport);
        } catch (IOException e) {
            System.err.println("Помилка збереження JSON звіту: " + e.getMessage());
        }
    }
}
