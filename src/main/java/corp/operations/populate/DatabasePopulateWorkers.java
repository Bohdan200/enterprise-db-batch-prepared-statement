package corp.operations.populate;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import corp.database.Database;
import corp.classes.Worker;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import static corp.prefs.Prefs.POPULATE_DB_SQL_WORKERS_FILE_PATH;

public class DatabasePopulateWorkers {
    public static void main(String[] args) {
        populate();
    }

    public static void populate() {
        try {
            String json = String.join(
                    "\n",
                    Files.readAllLines(Paths.get(POPULATE_DB_SQL_WORKERS_FILE_PATH))
            );

            TypeToken<?> typeToken = TypeToken.getParameterized(
                    List.class,
                    Worker.class
            );
            List<Worker> workers = new Gson().fromJson(json, typeToken.getType());

            PreparedStatement statement =  Database.getPreparedStatement("INSERT INTO worker (name, birthday, level, salary) VALUES (?, ?, ?, ?)");

            for (Worker worker : workers) {
                statement.setString(1, worker.getName());
                statement.setString(2, worker.getBirthday());
                statement.setString(3, worker.getLevel());
                statement.setInt(4, worker.getSalary());
                statement.addBatch();
            }
            statement.executeBatch();

        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
