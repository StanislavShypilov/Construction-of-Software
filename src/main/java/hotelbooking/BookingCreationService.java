package hotelbooking;

/** Pure Fabrication: ізолює створення доменних об'єктів для сценарію бронювання. */
public final class BookingCreationService {
    private final TouristTaxPolicy taxPolicy;

    public BookingCreationService(TouristTaxPolicy taxPolicy) {
        if (taxPolicy == null) throw new IllegalArgumentException("Політика туристичного збору обов'язкова.");
        this.taxPolicy = taxPolicy;
    }

    public Booking create(BookingRequest request, int bookingId) {
        Guest guest = new Guest(10, request.getGuestName(), request.getPhone(), "не вказано");
        Room room = new Room(302, "Deluxe", 2000.0);
        SeasonPricingPolicy pricingPolicy = SeasonPricingPolicies.forSeason(request.getSeason());
        return Booking.create(bookingId, guest, room, request.getNights(), pricingPolicy,
                request.isIncludeBreakfast(), request.isIncludeParking(), taxPolicy);
    }
}
