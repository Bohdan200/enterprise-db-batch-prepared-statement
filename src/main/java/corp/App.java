package corp;

import corp.database.Database;
import corp.operations.queries.DatabaseQueryService;

public class App {
    public static void main(String[] args) {
        Database database = Database.getInstance();

        new DatabaseQueryService().makeQueries();
    }
}