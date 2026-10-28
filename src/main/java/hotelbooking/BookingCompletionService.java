package hotelbooking;

/** Pure Fabrication: ізолює збереження та побічні ефекти після створення бронювання. */
public final class BookingCompletionService {
    private final BookingRepository repository;
    private final SmsNotifier smsNotifier;
    private final AuditLogger auditLogger;

    public BookingCompletionService(BookingRepository repository, SmsNotifier smsNotifier, AuditLogger auditLogger) {
        if (repository == null || smsNotifier == null || auditLogger == null) {
            throw new IllegalArgumentException("Репозиторій, сповіщення та журнал обов'язкові.");
        }
        this.repository = repository;
        this.smsNotifier = smsNotifier;
        this.auditLogger = auditLogger;
    }

    public void complete(Booking booking) {
        repository.save(booking);
        auditLogger.record("Створено бронювання #" + booking.getBookingId());
        smsNotifier.sendConfirmation(booking.getGuest().getPhone(),
                "Бронювання #" + booking.getBookingId() + " підтверджено. До сплати: "
                        + String.format(java.util.Locale.ROOT, "%.2f", booking.getGrandTotal()) + " грн.");
    }
}
