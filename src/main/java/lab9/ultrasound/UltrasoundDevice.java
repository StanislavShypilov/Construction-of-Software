package lab9.ultrasound;

import lab9.domain.Patient;
import lab9.util.EventLog;

import java.util.Objects;

/**
 * Pooled object: обладнання не створюється на кожне обстеження.
 */
public final class UltrasoundDevice {
    private final String id;
    private Patient patient;
    private String settingsProfile;
    private String examinationData;
    private int examinationCount;
    private boolean disinfected = true;

    UltrasoundDevice(String id) {
        this.id = id;
        EventLog.expensive(id, "Самодіагностика та калібрування датчиків");
    }

    public String getId() {
        return id;
    }

    public int getExaminationCount() {
        return examinationCount;
    }

    public Patient getPatient() {
        return patient;
    }

    public String getSettingsProfile() {
        return settingsProfile;
    }

    public String getExaminationData() {
        return examinationData;
    }

    public boolean isDisinfected() {
        return disinfected;
    }

    void assign(Patient patient) {
        if (this.patient != null || !disinfected) throw new IllegalStateException("Апарат не готовий");
        this.patient = Objects.requireNonNull(patient);
        settingsProfile = "Профіль: " + patient.getDiagnosis();
        disinfected = false;
        examinationCount++;
        EventLog.log("УЗД", id + " → " + patient.getFullName());
    }

    public void recordResult(String result) {
        if (patient == null) throw new IllegalStateException("Обстеження не розпочато");
        examinationData = Objects.requireNonNull(result);
    }

    void reset() {
        patient = null;
        settingsProfile = null;
        examinationData = null;
        disinfected = true;
        EventLog.log("УЗД", id + " повернено, дані стерто, датчик продезінфіковано");
    }
}
