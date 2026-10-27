package lab8;

public final class Room {
    private final int roomNumber;
    private final String category;
    private final double basePricePerNight;

    public Room(int roomNumber, String category, double basePricePerNight) {
        if (roomNumber <= 0) throw new IllegalArgumentException("Номер кімнати має бути додатним.");
        if (category == null || category.isBlank()) throw new IllegalArgumentException("Не вказано категорію номера.");
        if (basePricePerNight < 0) throw new IllegalArgumentException("Ціна не може бути від'ємною.");
        this.roomNumber = roomNumber;
        this.category = category;
        this.basePricePerNight = basePricePerNight;
    }

    public double calculatePricePerNight(Season season) {
        return basePricePerNight * season.getMultiplier();
    }

    public int getRoomNumber() { return roomNumber; }
    public String getCategory() { return category; }
    public double getBasePricePerNight() { return basePricePerNight; }
}
