package corp.classes.query;

public class PriceProject {
    private final String projectName;
    private final int projectPrice;

    public PriceProject(String projectName, int projectPrice) {
        this.projectName = projectName;
        this.projectPrice = projectPrice;
    }

    public String getProjectName() {
        return projectName;
    }

    public int getProjectPrice() {
        return projectPrice;
    }
}
