package corp.operations.populate;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import corp.database.Database;
import corp.classes.Project;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import static corp.prefs.Prefs.POPULATE_DB_SQL_PROJECTS_FILE_PATH;

public class DatabasePopulateProjects {
    public static void main(String[] args) {
        populate();
    }

    public static void populate() {
        try {
            String json = String.join(
                    "\n",
                    Files.readAllLines(Paths.get(POPULATE_DB_SQL_PROJECTS_FILE_PATH))
            );

            TypeToken<?> typeToken = TypeToken.getParameterized(
                    List.class,
                    Project.class
            );
            List<Project> projects = new Gson().fromJson(json, typeToken.getType());

            PreparedStatement statement = Database.getPreparedStatement("INSERT INTO project (client_id, project_name, start_date, finish_date) VALUES (?, ?, ?, ?)");

            for (Project project : projects) {
                statement.setInt(1, project.getClientId());
                statement.setString(2, project.getProjectName());
                statement.setString(3, project.getStartDate());
                statement.setString(4, project.getFinishDate());
                statement.addBatch();
            }
            statement.executeBatch();

        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
