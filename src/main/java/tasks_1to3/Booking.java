package tasks_1to3;

public final class Booking {
    private final int bookingId;
    private final Guest guest;
    private final Room room;
    private final int nights;
    private final String season;
    private final boolean includeBreakfast;
    private final boolean includeParking;
    private final double roomTotal;
    private final double servicesTotal;
    private final double touristTax;
    private final double grandTotal;
    private final String status;

    private Booking(int bookingId, Guest guest, Room room, int nights, String season,
                    boolean includeBreakfast, boolean includeParking) {
        if (guest == null || room == null) throw new IllegalArgumentException("Гість і номер обов'язкові.");
        if (nights <= 0) throw new IllegalArgumentException("Кількість ночей має бути більшою за нуль.");
        this.bookingId = bookingId;
        this.guest = guest;
        this.room = room;
        this.nights = nights;
        this.season = season;
        this.includeBreakfast = includeBreakfast;
        this.includeParking = includeParking;

        // Information Expert: Booking зберігає дані, потрібні для підсумкового розрахунку.
        this.roomTotal = room.calculatePriceForNights(nights, season);
        double services = 0.0;
        if (includeBreakfast) services += 300.0 * nights;
        if (includeParking) services += 150.0 * nights;
        this.servicesTotal = services;
        this.touristTax = (roomTotal + servicesTotal) * 0.01;
        this.grandTotal = roomTotal + servicesTotal + touristTax;
        this.status = "Confirmed";
    }

    // Creator: створення Booking централізовано, об'єкт відразу має завершений стан.
    public static Booking create(int bookingId, Guest guest, Room room, int nights,
                                 String season, boolean includeBreakfast, boolean includeParking) {
        return new Booking(bookingId, guest, room, nights, season, includeBreakfast, includeParking);
    }

    public String createReceipt() {
        return "Бронювання #" + bookingId + " для " + guest.getFullName()
                + "\nКімната: " + room.getRoomNumber() + " (" + room.getCategory() + ")"
                + "\nСезон: " + season + ", ночей: " + nights
                + "\nПроживання: " + String.format("%.2f", roomTotal) + " грн"
                + "\nПослуги: " + String.format("%.2f", servicesTotal) + " грн"
                + "\nТуристичний збір: " + String.format("%.2f", touristTax) + " грн"
                + "\nВсього: " + String.format("%.2f", grandTotal) + " грн"
                + "\nСтатус: " + status;
    }

    public int getBookingId() { return bookingId; }
    public Guest getGuest() { return guest; }
    public Room getRoom() { return room; }
    public int getNights() { return nights; }
    public String getSeason() { return season; }
    public double getRoomTotal() { return roomTotal; }
    public double getServicesTotal() { return servicesTotal; }
    public double getTouristTax() { return touristTax; }
    public double getGrandTotal() { return grandTotal; }
    public String getStatus() { return status; }
}
