package hotelbooking;

/** Координує сценарій бронювання через спеціалізовані сервіси. */
public final class DefaultBookingUseCase implements BookingUseCase {
    private final BookingCreationService creationService;
    private final BookingCompletionService completionService;
    private int nextBookingId = 501;

    public DefaultBookingUseCase(BookingCreationService creationService, BookingCompletionService completionService) {
        if (creationService == null || completionService == null) {
            throw new IllegalArgumentException("Сервіси створення та завершення обов'язкові.");
        }
        this.creationService = creationService;
        this.completionService = completionService;
    }

    @Override
    public Booking execute(BookingRequest request) {
        if (request == null) throw new IllegalArgumentException("Запит бронювання обов'язковий.");
        Booking booking = creationService.create(request, nextBookingId++);
        completionService.complete(booking);
        return booking;
    }
}
