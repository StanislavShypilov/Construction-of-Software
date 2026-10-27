package lab8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public final class FileBookingRepository implements BookingRepository {
    private final Path filePath;

    public FileBookingRepository(Path filePath) {
        this.filePath = filePath;
    }

    @Override
    public void save(Booking booking) {
        try {
            Files.writeString(filePath,
                    booking.createReceipt() + System.lineSeparator() + "--------------------" + System.lineSeparator(),
                    StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new IllegalStateException("Не вдалося зберегти бронювання у файл: " + e.getMessage(), e);
        }
    }
}
