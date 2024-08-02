package corp;

import corp.database.Database;
import corp.operations.populate.DatabasePopulateClients;
import corp.operations.populate.DatabasePopulateProjectWorkerRelations;
import corp.operations.populate.DatabasePopulateProjects;
import corp.operations.populate.DatabasePopulateWorkers;
import corp.operations.queries.DatabaseQueryService;

public class App {
    public static void main(String[] args) {
        Database database = Database.getInstance();

        DatabasePopulateClients.populate();
        DatabasePopulateProjects.populate();
        DatabasePopulateWorkers.populate();
        DatabasePopulateProjectWorkerRelations.populate();

        new DatabaseQueryService().makeQueries();
    }
}