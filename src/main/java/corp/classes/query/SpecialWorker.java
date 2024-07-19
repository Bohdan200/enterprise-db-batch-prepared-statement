package corp.classes.query;

import java.time.LocalDate;

public class SpecialWorker {
    private String name = "";
    private int salary = 0;
    private String type = "";
    private LocalDate birthday;

    public SpecialWorker(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public SpecialWorker(String name, String type, LocalDate birthday) {
        this.name = name;
        this.type = type;
        this.birthday = birthday;
    }

    public String getName() { return name; }

    public int getSalary() { return salary; }

    public LocalDate getBirthday() { return birthday; }

    public String getType() { return type; }
}
