package corp.operations.populate;


import java.nio.file.Files;
import java.nio.file.Paths;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import corp.database.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.io.IOException;
import java.sql.SQLException;

import java.util.List;
import corp.classes.Project_Worker;
import static corp.prefs.Prefs.POPULATE_DB_SQL_PROJECT_WORKER_FILE_PATH;

public class DatabasePopulateProjectWorkerRelations {
    public static void main(String[] args) {
        populate();
    }

    public static void populate() {
        try {
            String json = String.join(
                    "\n",
                    Files.readAllLines(Paths.get(POPULATE_DB_SQL_PROJECT_WORKER_FILE_PATH))
            );

            TypeToken<?> typeToken = TypeToken.getParameterized(
                    List.class,
                    Project_Worker.class
            );
            List<Project_Worker> relations = new Gson().fromJson(json, typeToken.getType());

            PreparedStatement statement = Database.getPreparedStatement("INSERT INTO project_worker (project_id, worker_id) VALUES (?, ?)");

            for (Project_Worker relation : relations) {
                statement.setInt(1,relation.getProject_id());
                statement.setInt(2, relation.getWorker_id());
                statement.addBatch();
            }
            statement.executeBatch();

        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
