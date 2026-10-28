package lab9.app;

import lab9.domain.Bed;
import lab9.domain.Department;
import lab9.domain.Doctor;
import lab9.domain.Patient;
import lab9.treatment.Prescription;
import lab9.treatment.TreatmentPlan;
import lab9.ultrasound.UltrasoundDevice;
import lab9.ultrasound.UltrasoundPool;
import lab9.domain.*;
import lab9.registry.BedRegistry;
import lab9.ultrasound.*;
import lab9.treatment.*;
import lab9.util.EventLog;

import java.util.*;

public final class Main {
    private Main() {
    }

    public static void main(String[] args) {
        task1();
        task2();
        task3();
    }

    private static Patient patient(String id, String name, String diagnosis) {
        return new Patient(id, name, Department.THERAPY, diagnosis, new Doctor("Іваненко О.О.", Department.THERAPY));
    }

    private static void task1() {
        EventLog.log("MAIN", "========== ЗАВДАННЯ 1: SINGLETON ==========");
        BedRegistry admissions = BedRegistry.getInstance();
        admissions.register(new Bed("214", 3, Department.SURGERY));
        Patient kovalenko = patient("P-001", "Коваленко", "Пневмонія");
        Patient melnyk = patient("P-002", "Мельник", "Апендицит");
        admissions.admit("214-3", kovalenko, "Приймальне відділення");
        BedRegistry surgery = BedRegistry.getInstance();
        surgery.admit("214-3", melnyk, "Хірургія");
        EventLog.log("Приймальне відділення", "ID реєстру: " + System.identityHashCode(admissions));
        EventLog.log("Хірургія", "ID реєстру: " + System.identityHashCode(surgery));
        EventLog.log("Перевірка", "Один об'єкт реєстру: " + (admissions == surgery));
        EventLog.log("Адміністрація", BedRegistry.getInstance().status("214-3"));
    }

    private static void task2() {
        EventLog.log("MAIN", "========== ЗАВДАННЯ 2: OBJECT POOL ==========");
        UltrasoundPool pool = new UltrasoundPool(2);
        Patient p1 = patient("U-001", "Коваленко", "Пневмонія"), p2 = patient("U-002", "Мельник", "Гастрит"), p3 = patient("U-003", "Петренко", "Холецистит"), p4 = patient("U-004", "Шевченко", "Панкреатит");
        UltrasoundDevice first = pool.request(p1).orElseThrow();
        pool.request(p2);
        pool.request(p3);
        pool.request(p4);
        EventLog.log("Перевірка", "Одночасно зайнято: " + pool.activeCount() + ", у черзі: " + pool.waitingCount());
        first.recordResult("УЗД органів черевної порожнини: завершено");
        pool.release(first);
        UltrasoundDevice reused = pool.findDeviceFor(p3).orElseThrow();
        EventLog.log("Перевірка", "Після повернення " + reused.getId() + " працює з " + reused.getPatient().getFullName() + ", попередні дані: " + reused.getExaminationData());
        pool.release(pool.findDeviceFor(p2).orElseThrow());
        pool.release(pool.findDeviceFor(p3).orElseThrow());
        pool.release(pool.findDeviceFor(p4).orElseThrow());
        pool.printStatistics();
    }

    private static void task3() {
        EventLog.log("MAIN", "========== ЗАВДАННЯ 3: PROTOTYPE ==========");
        TreatmentPlan approved = TreatmentPlan.createApproved("Пневмонія", List.of("Загальний аналіз крові", "С-реактивний білок"), List.of("Рентгенографія грудної клітки", "Контроль температури"), List.of(new Prescription("Амоксицилін", "500 мг 3 рази на добу"), new Prescription("Парацетамол", "за потреби")), "Стіл №15", "Постільний");
        TreatmentPlan a = approved.copyFor(patient("T-001", "Коваленко", "Пневмонія"));
        TreatmentPlan b = approved.copyFor(patient("T-002", "Петренко", "Пневмонія"));
        TreatmentPlan c = approved.copyFor(patient("T-003", "Шевченко", "Пневмонія"));
        a.replaceMedication("Амоксицилін", "Азитроміцин");
        a.addTest("Посів мокротиння");
        a.setDiet("Безлактозна дієта");
        EventLog.log("Затверджений план", "\n" + approved);
        EventLog.log("План Коваленко", "\n" + a);
        EventLog.log("План Петренко", "\n" + b);
        EventLog.log("План Шевченко", "\n" + c);
        EventLog.log("Перевірка", "Зразок не містить нового аналізу: " + !approved.getTests().contains("Посів мокротиння"));
    }
}
