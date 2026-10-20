package task1;

public class NotificationService {
    public void sendCriticalAlert(Patient patient, double bmi) {
        try {
            String smsMessage = String.format("УВАГА: Пацієнт %s має критичні показники! ІМТ: %.1f, Тиск: %d/%d",
                    patient.fullName(), bmi, patient.systolicBloodPressure(), patient.diastolicBloodPressure());
            System.out.println("Надсилання SMS на номер " + patient.doctorPhoneNumber() + "...");
            System.out.println("Повідомлення: " + smsMessage);
        } catch (Exception ex) {
            System.out.println("Не вдалося відправити SMS лікарю: " + ex.getMessage());
        }
    }
}
