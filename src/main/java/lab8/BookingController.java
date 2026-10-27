package lab8;

public final class BookingController {
    private final BookingRepository repository;
    private final SmsNotifier smsNotifier;
    private final AuditLogger auditLogger;
    private int nextBookingId = 501;

    public BookingController(BookingRepository repository, SmsNotifier smsNotifier,
                             AuditLogger auditLogger) {
        this.repository = repository;
        this.smsNotifier = smsNotifier;
        this.auditLogger = auditLogger;
    }

    public Booking createBooking(BookingRequest request) {
        // Controller координує use case, але не виконує розрахунки й не працює з консоллю.
        Guest guest = new Guest(10, request.getGuestName(), request.getPhone(), "не вказано");
        Room room = new Room(302, "Deluxe", 2000.0);

        Booking booking = Booking.create(nextBookingId++, guest, room, request.getNights(),
                request.getSeason(), request.isIncludeBreakfast(), request.isIncludeParking());

        repository.save(booking);
        auditLogger.record("Створено бронювання #" + booking.getBookingId());
        smsNotifier.sendConfirmation(guest.getPhone(),
                "Бронювання #" + booking.getBookingId() + " підтверджено. До сплати: "
                        + String.format("%.2f", booking.getGrandTotal()) + " грн.");
        return booking;
    }
}
