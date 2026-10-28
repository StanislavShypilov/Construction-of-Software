package lab9.treatment;

import java.util.Objects;

public final class Prescription {
    private String medication;
    private String dosage;

    public Prescription(String medication, String dosage) {
        this.medication = Objects.requireNonNull(medication);
        this.dosage = Objects.requireNonNull(dosage);
    }

    public Prescription(Prescription other) {
        this(other.medication, other.dosage);
    }

    public String getMedication() {
        return medication;
    }

    public String getDosage() {
        return dosage;
    }

    public void setMedication(String medication) {
        this.medication = Objects.requireNonNull(medication);
    }

    public void setDosage(String dosage) {
        this.dosage = Objects.requireNonNull(dosage);
    }

    public String toString() {
        return medication + " (" + dosage + ")";
    }
}
