package task5;

public class SendGridNotificationClient implements INotificationClient {
    @Override
    public void sendSecurityAlert(String email, String message) {
        System.out.println(
                "[SendGrid API] Сповіщення безпеки надіслано на "
                        + email + ": " + message
        );
    }
}
