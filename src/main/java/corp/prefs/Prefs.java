package corp.prefs;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Prefs {
    public static final String DEFAULT_PREFS_FILENAME = "./json/prefs.json";
    public static final String DB_JDBC_CONNECTION_URL = "dbUrl";
    public static final String DB_JDBC_CONNECTION_USER = "dbUser";
    public static final String DB_JDBC_CONNECTION_PASSWORD = "dbPass";
    public static final String INIT_DB_SQL_FILE_PATH = "./sql/init_db.sql";
    public static final String POPULATE_DB_SQL_WORKERS_FILE_PATH = "./json/workers.json";
    public static final String POPULATE_DB_SQL_CLIENTS_FILE_PATH = "./json/clients.json";
    public static final String POPULATE_DB_SQL_PROJECTS_FILE_PATH = "./json/projects.json";
    public static final String POPULATE_DB_SQL_PROJECT_WORKER_FILE_PATH = "./json/project_worker.json";
    public static final String FIND_MAX_PROJECTS_CLIENT_SQL_FILE_PATH = "./sql/find_max_projects_client.sql";
    public static final String FIND_LONGEST_PROJECT_SQL_FILE_PATH = "./sql/find_longest_project.sql";
    public static final String PRINT_PROJECT_PRICES_SQL_FILE_PATH = "./sql/print_project_prices.sql";
    public static final String FIND_MAX_SALARY_WORKER_SQL_FILE_PATH = "./sql/find_max_salary_worker.sql";
    public static final String FIND_YOUNGEST_ELDEST_WORKERS_SQL_FILE_PATH = "./sql/find_youngest_eldest_workers.sql";

    private Map<String, Object> prefsList = new HashMap<>();

    public Prefs() {
        this(DEFAULT_PREFS_FILENAME);
    }
    public Prefs(String filename) {
        try {
            String json = String.join(
                    "\n",
                    Files.readAllLines(Paths.get(filename))
            );

            TypeToken<?> typeToken = TypeToken.getParameterized(
                    Map.class,
                    String.class,
                    Object.class
            );

            prefsList = new Gson().fromJson(json, typeToken.getType());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getString(String key) {
        return prefsList.get(key).toString();
    }
}
