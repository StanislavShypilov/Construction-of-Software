package task1;

public class PatientValidationService {
    public void validate(Patient patient) {
        if (patient.weightKg() <= 2 || patient.weightKg() > 300)
            throw new IllegalArgumentException("Некоректне значення ваги пацієнта.");
        if (patient.heightCm() <= 40 || patient.heightCm() > 250)
            throw new IllegalArgumentException("Некоректне значення зросту пацієнта.");
        if (patient.systolicBloodPressure() < 50 || patient.diastolicBloodPressure() < 30)
            throw new IllegalArgumentException("Показники тиску поза межами діапазону.");
    }
}
