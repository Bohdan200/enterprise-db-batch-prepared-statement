package corp.classes.query;

import lombok.Getter;
import java.time.LocalDate;

@Getter
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

}
