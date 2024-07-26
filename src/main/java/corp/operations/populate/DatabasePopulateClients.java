package corp.operations.populate;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import corp.database.Database;
import corp.classes.Client;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.List;

import static corp.prefs.Prefs.POPULATE_DB_SQL_CLIENTS_FILE_PATH;

public class DatabasePopulateClients {
    public static void main(String[] args) {
        populate();
    }

    public static void populate() {
        try {
            String json = String.join(
                    "\n",
                    Files.readAllLines(Paths.get(POPULATE_DB_SQL_CLIENTS_FILE_PATH))
            );

            TypeToken<?> typeToken = TypeToken.getParameterized(
                    List.class,
                    Client.class
            );
            List<Client> clients = new Gson().fromJson(json, typeToken.getType());

            PreparedStatement statement = Database.getPreparedStatement("INSERT INTO client (name) VALUES (?)");

            for (Client client : clients) {
                statement.setString(1, client.getName());
                statement.addBatch();
            }
            statement.executeBatch();
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
