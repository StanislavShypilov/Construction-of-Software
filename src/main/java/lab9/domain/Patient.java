package lab9.domain;

import java.util.Objects;

public final class Patient {
    private final String id;
    private final String fullName;
    private Department department;
    private String diagnosis;
    private Doctor attendingDoctor;

    public Patient(String id, String fullName, Department department, String diagnosis, Doctor doctor) {
        this.id = Objects.requireNonNull(id);
        this.fullName = Objects.requireNonNull(fullName);
        this.department = Objects.requireNonNull(department);
        this.diagnosis = Objects.requireNonNull(diagnosis);
        this.attendingDoctor = Objects.requireNonNull(doctor);
    }

    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public Department getDepartment() {
        return department;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public Doctor getAttendingDoctor() {
        return attendingDoctor;
    }

    public void setDepartment(Department department) {
        this.department = Objects.requireNonNull(department);
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = Objects.requireNonNull(diagnosis);
    }

    public void setAttendingDoctor(Doctor doctor) {
        this.attendingDoctor = Objects.requireNonNull(doctor);
    }

    public String toString() {
        return fullName + " [" + id + ", " + department.getLabel() + ", " + diagnosis + ", лікар: " + attendingDoctor.getName() + "]";
    }
}
