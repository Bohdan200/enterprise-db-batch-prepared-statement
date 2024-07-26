package corp.classes;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter

public class Worker {
    private final String name;
    private final String birthday;
    private final String level;
    private final int salary;
}
