package lab8;

public interface SmsNotifier {
    void sendConfirmation(String phone, String message);
}
