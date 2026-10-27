package tasks_1to3;

public final class ConsoleSmsNotifier implements SmsNotifier {
    @Override
    public void sendConfirmation(String phone, String message) {
        // Демонстраційна реалізація: справжній SMS-шлюз не підключено.
        System.out.println("[SMS — симуляція] На " + phone + " надіслано: " + message);
    }
}
