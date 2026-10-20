package task1;

public record Patient(
        String patientId,
        String fullName,
        double weightKg,
        double heightCm,
        int systolicBloodPressure,
        int diastolicBloodPressure,
        String doctorPhoneNumber) {}
