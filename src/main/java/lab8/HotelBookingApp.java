package lab8;

import java.nio.file.Path;
import java.util.Scanner;

public final class HotelBookingApp {
    public static void main(String[] args) {
        BookingRepository repository = new FileBookingRepository(Path.of("bookings.txt"));
        SmsNotifier notifier = new ConsoleSmsNotifier();
        AuditLogger auditLogger = new AuditLogger();
        BookingController controller = new BookingController(repository, notifier, auditLogger);
        SeasonService seasonService = new SeasonService();

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("=== Бронювання номера в готелі ===");
            System.out.print("Введіть ПІБ гостя: ");
            String name = scanner.nextLine();
            System.out.print("Введіть номер телефону: ");
            String phone = scanner.nextLine();
            System.out.print("Введіть сезон (Low/High/Peak): ");
            Season season = seasonService.getSeason(scanner.nextLine());
            System.out.print("Кількість ночей: ");
            int nights = Integer.parseInt(scanner.nextLine());
            System.out.print("Додати сніданки? (так/ні): ");
            boolean breakfast = scanner.nextLine().trim().equalsIgnoreCase("так");
            System.out.print("Додати парковку? (так/ні): ");
            boolean parking = scanner.nextLine().trim().equalsIgnoreCase("так");

            BookingRequest request = new BookingRequest(name, phone, season, nights, breakfast, parking);
            Booking booking = controller.createBooking(request);
            System.out.println();
            System.out.println(booking.createReceipt());
            System.out.println("Запис додано до bookings.txt.");
        } catch (IllegalArgumentException e) {
            System.out.println("Помилка введення: " + e.getMessage());
        } catch (IllegalStateException e) {
            System.out.println("Помилка виконання: " + e.getMessage());
        }
    }
}
