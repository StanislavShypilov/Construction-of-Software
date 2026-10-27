package tasks_1to3;

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

    public double calculatePriceForNights(int nights, String season) {
        if (nights <= 0) throw new IllegalArgumentException("Кількість ночей має бути більшою за нуль.");
        double multiplier;
        if ("Peak".equalsIgnoreCase(season)) {
            multiplier = 1.5;
        } else if ("High".equalsIgnoreCase(season)) {
            multiplier = 1.25;
        } else if ("Low".equalsIgnoreCase(season)) {
            multiplier = 0.9;
        } else {
            throw new IllegalArgumentException("Невідомий сезон. Використайте Low, High або Peak.");
        }
        return basePricePerNight * nights * multiplier;
    }

    public int getRoomNumber() { return roomNumber; }
    public String getCategory() { return category; }
    public double getBasePricePerNight() { return basePricePerNight; }
}
