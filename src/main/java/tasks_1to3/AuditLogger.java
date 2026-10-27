package tasks_1to3;

import java.time.LocalDateTime;

public final class AuditLogger {
    public void record(String message) {
        System.out.println("[AUDIT " + LocalDateTime.now() + "] " + message);
    }
}
