package corp.classes;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter

public class Project {
    private final int client_id;
    private final String project_name;
    private final String start_date;
    private final String finish_date;
}
