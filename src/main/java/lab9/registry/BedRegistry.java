package lab9.registry;

import lab9.domain.Bed;
import lab9.domain.Patient;
import lab9.domain.*;
import lab9.util.EventLog;

import java.util.*;

/**
 * Singleton: один узгоджений реєстр для всіх відділень.
 */
public final class BedRegistry {
    private final Map<String, Bed> beds = new LinkedHashMap<>();

    private BedRegistry() {
        EventLog.log("Реєстр", "Реєстр ліжкового фонду ініціалізовано");
    }

    private static final class Holder {
        private static final BedRegistry INSTANCE = new BedRegistry();
    }

    public static BedRegistry getInstance() {
        return Holder.INSTANCE;
    }

    public synchronized void register(Bed bed) {
        Objects.requireNonNull(bed);
        if (beds.putIfAbsent(bed.getId(), bed) != null)
            throw new IllegalArgumentException("Ліжко вже зареєстроване: " + bed.getId());
        EventLog.log("Реєстр", "Додано ліжко " + bed.getId());
    }

    public synchronized boolean admit(String bedId, Patient patient, String source) {
        Objects.requireNonNull(patient);
        Bed bed = required(bedId);
        if (!bed.isFree()) {
            EventLog.log(source, "ВІДМОВА: Ліжко " + bedId + " зайняте: " + bed.getOccupant().getFullName());
            return false;
        }
        boolean alreadyAdmitted = beds.values().stream().anyMatch(b -> b.getOccupant() != null && b.getOccupant().getId().equals(patient.getId()));
        if (alreadyAdmitted) {
            EventLog.log(source, "ВІДМОВА: Пацієнт " + patient.getFullName() + " уже займає інше ліжко");
            return false;
        }
        bed.occupy(patient);
        patient.setDepartment(bed.getDepartment());
        EventLog.log(source, "Ліжко " + bedId + " → " + patient.getFullName());
        return true;
    }

    public synchronized void discharge(String bedId, String source) {
        Bed bed = required(bedId);
        String name = bed.getOccupant() == null ? "" : bed.getOccupant().getFullName();
        bed.release();
        EventLog.log(source, "Ліжко " + bedId + " звільнено (" + name + ")");
    }

    public synchronized String status(String bedId) {
        return required(bedId).toString();
    }

    public synchronized int freeCount() {
        return (int) beds.values().stream().filter(Bed::isFree).count();
    }

    private Bed required(String id) {
        Bed bed = beds.get(id);
        if (bed == null) throw new IllegalArgumentException("Невідоме ліжко: " + id);
        return bed;
    }
}
