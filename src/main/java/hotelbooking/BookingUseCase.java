package hotelbooking;

/** Абстракція сценарію бронювання для низького зчеплення UI та реалізації. */
public interface BookingUseCase {
    Booking execute(BookingRequest request);
}
