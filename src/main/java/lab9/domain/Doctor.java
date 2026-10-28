package lab9.domain;

import java.util.Objects;

public final class Doctor {
    private final String name;
    private final Department department;

    public Doctor(String name, Department department) {
        this.name = Objects.requireNonNull(name);
        this.department = Objects.requireNonNull(department);
    }

    public String getName() {
        return name;
    }

    public Department getDepartment() {
        return department;
    }

    public String toString() {
        return name + " (" + department.getLabel() + ")";
    }
}
