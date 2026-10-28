package hotelbooking;

public final class BookingRequest {
    private final String guestName;
    private final String phone;
    private final String season;
    private final int nights;
    private final boolean includeBreakfast;
    private final boolean includeParking;

    public BookingRequest(String guestName, String phone, String season, int nights,
                          boolean includeBreakfast, boolean includeParking) {
        this.guestName = guestName;
        this.phone = phone;
        this.season = season;
        this.nights = nights;
        this.includeBreakfast = includeBreakfast;
        this.includeParking = includeParking;
    }

    public String getGuestName() { return guestName; }
    public String getPhone() { return phone; }
    public String getSeason() { return season; }
    public int getNights() { return nights; }
    public boolean isIncludeBreakfast() { return includeBreakfast; }
    public boolean isIncludeParking() { return includeParking; }
}
