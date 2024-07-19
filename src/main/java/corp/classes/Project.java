package corp.classes;

public class Project {
    private final int client_id;
    private final String project_name;
    private final String start_date;
    private final String finish_date;

    public Project(int client_id, String project_name, String start_date, String finish_date) {
        this.client_id = client_id;
        this.project_name = project_name;
        this.start_date = start_date;
        this.finish_date = finish_date;
    }

    public int getClientId() { return client_id; }

    public String getProjectName() {
        return project_name;
    }

    public String getStartDate() { return start_date; }

    public String getFinishDate() { return finish_date; }
}
