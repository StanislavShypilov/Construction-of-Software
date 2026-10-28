package hotelbooking;

public interface SmsNotifier {
    void sendConfirmation(String phone, String message);
}
