package lab9.domain;

import java.util.Objects;

public final class Bed {
    private final String ward;
    private final int number;
    private final Department department;
    private Patient occupant;

    public Bed(String ward, int number, Department department) {
        if (number <= 0) throw new IllegalArgumentException("Номер ліжка має бути додатним");
        this.ward = Objects.requireNonNull(ward);
        this.number = number;
        this.department = Objects.requireNonNull(department);
    }

    public String getId() {
        return ward + "-" + number;
    }

    public Department getDepartment() {
        return department;
    }

    public Patient getOccupant() {
        return occupant;
    }

    public boolean isFree() {
        return occupant == null;
    }

    public void occupy(Patient patient) {
        Objects.requireNonNull(patient);
        if (!isFree()) throw new IllegalStateException("Ліжко зайняте");
        occupant = patient;
    }

    public void release() {
        if (isFree()) throw new IllegalStateException("Ліжко вже вільне");
        occupant = null;
    }

    public String toString() {
        return getId() + " (" + department.getLabel() + "): " + (isFree() ? "вільне" : "зайняте: " + occupant.getFullName());
    }
}
