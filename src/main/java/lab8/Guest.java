package lab8;

public final class Guest {
    private final int id;
    private final String fullName;
    private final String phone;
    private final String passportNumber;

    public Guest(int id, String fullName, String phone, String passportNumber) {
        if (fullName == null || fullName.isBlank()) {
            throw new IllegalArgumentException("Ім'я гостя не може бути порожнім.");
        }
        if (phone == null || phone.isBlank()) {
            throw new IllegalArgumentException("Номер телефону не може бути порожнім.");
        }
        this.id = id;
        this.fullName = fullName;
        this.phone = phone;
        this.passportNumber = passportNumber;
    }

    public int getId() { return id; }
    public String getFullName() { return fullName; }
    public String getPhone() { return phone; }
    public String getPassportNumber() { return passportNumber; }
}
