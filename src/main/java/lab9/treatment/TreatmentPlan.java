package lab9.treatment;

import lab9.domain.Patient;
import lab9.util.EventLog;

import java.util.*;

/**
 * Prototype: глибоке копіювання списків і змінюваних призначень.
 */
public final class TreatmentPlan {
    private final String diagnosis;
    private Patient patient;
    private final List<String> tests;
    private final List<String> procedures;
    private final List<Prescription> prescriptions;
    private String diet;
    private String regimen;

    private TreatmentPlan(String diagnosis, List<String> tests, List<String> procedures, List<Prescription> prescriptions, String diet, String regimen) {
        this.diagnosis = Objects.requireNonNull(diagnosis);
        this.tests = new ArrayList<>(tests);
        this.procedures = new ArrayList<>(procedures);
        this.prescriptions = new ArrayList<>();
        for (Prescription p : prescriptions) this.prescriptions.add(new Prescription(p));
        this.diet = Objects.requireNonNull(diet);
        this.regimen = Objects.requireNonNull(regimen);
    }

    public static TreatmentPlan createApproved(String diagnosis, List<String> tests, List<String> procedures, List<Prescription> prescriptions, String diet, String regimen) {
        EventLog.expensive("План лікування", "Формування затвердженого плану «" + diagnosis + "»");
        return new TreatmentPlan(diagnosis, tests, procedures, prescriptions, diet, regimen);
    }

    public TreatmentPlan copyFor(Patient patient) {
        TreatmentPlan clone = new TreatmentPlan(diagnosis, tests, procedures, prescriptions, diet, regimen);
        clone.patient = patient;
        EventLog.log("Prototype", "План «" + diagnosis + "» скопійовано для " + patient.getFullName() + " без повторного формування");
        return clone;
    }

    public void addTest(String test) {
        tests.add(Objects.requireNonNull(test));
    }

    public void addProcedure(String procedure) {
        procedures.add(Objects.requireNonNull(procedure));
    }

    public void replaceMedication(String oldMedication, String newMedication) {
        for (Prescription p : prescriptions)
            if (p.getMedication().equals(oldMedication)) {
                p.setMedication(newMedication);
                return;
            }
        throw new IllegalArgumentException("Препарат не знайдено: " + oldMedication);
    }

    public void setDiet(String diet) {
        this.diet = Objects.requireNonNull(diet);
    }

    public void setRegimen(String regimen) {
        this.regimen = Objects.requireNonNull(regimen);
    }

    public List<String> getTests() {
        return List.copyOf(tests);
    }

    public List<String> getProcedures() {
        return List.copyOf(procedures);
    }

    public List<Prescription> getPrescriptions() {
        List<Prescription> result = new ArrayList<>();
        for (Prescription p : prescriptions) result.add(new Prescription(p));
        return List.copyOf(result);
    }

    public String getDiet() {
        return diet;
    }

    public String getRegimen() {
        return regimen;
    }

    public String toString() {
        return "План: " + diagnosis + " | " + (patient == null ? "ЗАТВЕРДЖЕНИЙ ЗРАЗОК" : patient.getFullName()) + "\n  Аналізи: " + tests + "\n  Процедури: " + procedures + "\n  Призначення: " + prescriptions + "\n  Дієта: " + diet + "\n  Режим: " + regimen;
    }
}
