package hotelbooking;

/** Тонкий Controller: приймає DTO та делегує сценарій застосунку. */
public final class BookingController {
    private final BookingUseCase bookingUseCase;

    public BookingController(BookingUseCase bookingUseCase) {
        if (bookingUseCase == null) {
            throw new IllegalArgumentException("Сценарій бронювання обов'язковий.");
        }
        this.bookingUseCase = bookingUseCase;
    }

    public Booking createBooking(BookingRequest request) {
        if (request == null) {
            throw new IllegalArgumentException("Запит бронювання обов'язковий.");
        }
        return bookingUseCase.execute(request);
    }
}
