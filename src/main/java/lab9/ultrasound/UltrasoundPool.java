package lab9.ultrasound;

import lab9.domain.Patient;
import lab9.util.EventLog;

import java.util.*;

/**
 * Object Pool: фіксована місткість, FIFO-черга очікування.
 */
public final class UltrasoundPool {
    private final List<UltrasoundDevice> devices = new ArrayList<>();
    private final Deque<UltrasoundDevice> available = new ArrayDeque<>();
    private final Set<UltrasoundDevice> inUse = new HashSet<>();
    private final Deque<Patient> waiting = new ArrayDeque<>();

    public UltrasoundPool(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException("Місткість має бути додатною");
        for (int i = 1; i <= capacity; i++) {
            UltrasoundDevice d = new UltrasoundDevice("УЗД-" + i);
            devices.add(d);
            available.addLast(d);
        }
        EventLog.log("Пул УЗД", "Підготовлено апаратів: " + capacity);
    }

    public synchronized Optional<UltrasoundDevice> request(Patient patient) {
        Objects.requireNonNull(patient);
        if (isAssigned(patient) || waiting.stream().anyMatch(p -> p.getId().equals(patient.getId())))
            throw new IllegalArgumentException("Пацієнт уже обстежується або очікує");
        if (available.isEmpty() || !waiting.isEmpty()) {
            waiting.addLast(patient);
            EventLog.log("Черга УЗД", patient.getFullName() + " очікує (позиція " + waiting.size() + ")");
            return Optional.empty();
        }
        UltrasoundDevice device = available.removeFirst();
        inUse.add(device);
        device.assign(patient);
        return Optional.of(device);
    }

    public synchronized void release(UltrasoundDevice device) {
        if (!inUse.remove(device)) throw new IllegalArgumentException("Апарат не видано цим пулом або вже повернуто");
        device.reset();
        available.addLast(device);
        if (!waiting.isEmpty()) {
            Patient next = waiting.removeFirst();
            UltrasoundDevice assigned = available.removeFirst();
            inUse.add(assigned);
            assigned.assign(next);
            EventLog.log("Черга УЗД", next.getFullName() + " отримав апарат після очікування");
        }
    }

    private boolean isAssigned(Patient patient) {
        return inUse.stream().anyMatch(d -> d.getPatient().getId().equals(patient.getId()));
    }

    public synchronized Optional<UltrasoundDevice> findDeviceFor(Patient patient) {
        return inUse.stream().filter(d -> d.getPatient().getId().equals(patient.getId())).findFirst();
    }

    public synchronized int waitingCount() {
        return waiting.size();
    }

    public synchronized int activeCount() {
        return inUse.size();
    }

    public int totalCreated() {
        return devices.size();
    }

    public void printStatistics() {
        for (UltrasoundDevice d : devices)
            EventLog.log("Статистика", d.getId() + ": обстежень = " + d.getExaminationCount());
        EventLog.log("Статистика", "Усього створено апаратів: " + totalCreated());
    }
}
