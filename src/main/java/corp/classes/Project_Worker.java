package corp.classes;

public class Project_Worker {
    private final int project_id;
    private final int worker_id;

    public Project_Worker(int  project_id, int worker_id) {
        this.project_id = project_id;
        this.worker_id = worker_id;
    }

    public int getProjectId() { return project_id; }

    public int getWorkerId() { return worker_id; }
}
