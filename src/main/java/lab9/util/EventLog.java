package lab9.util;

import java.util.concurrent.atomic.AtomicInteger;

public final class EventLog {
    private static final AtomicInteger CLOCK = new AtomicInteger(8 * 3600);

    private EventLog() {
    }

    public static void log(String source, String message) {
        int s = CLOCK.getAndIncrement();
        System.out.printf("[%02d:%02d:%02d] [%s] %s%n", s / 3600, s / 60 % 60, s % 60, source, message);
    }

    public static void expensive(String source, String message) {
        log(source, message + " (дорога операція)");
        try {
            Thread.sleep(120);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IllegalStateException("Операцію перервано", e);
        }
    }
}
