package corp;

import corp.operations.init.DatabaseInitService;
import corp.operations.populate.DatabasePopulateClients;
import corp.operations.populate.DatabasePopulateProjectWorkerRelations;
import corp.operations.populate.DatabasePopulateProjects;
import corp.operations.populate.DatabasePopulateWorkers;
import corp.operations.queries.DatabaseQueryService;

public class App {
    public static void main(String[] args) {
        DatabaseInitService.init();

        DatabasePopulateClients.populate();
        DatabasePopulateProjects.populate();
        DatabasePopulateWorkers.populate();
        DatabasePopulateProjectWorkerRelations.populate();

        new DatabaseQueryService().makeQueries();
    }
}