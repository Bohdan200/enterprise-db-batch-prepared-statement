package corp.operations.init;

import corp.database.Database;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.sql.Statement;

import static corp.prefs.Prefs.INIT_DB_SQL_FILE_PATH;

public class DatabaseInitService {
    public static void main(String[] args) {
       init();
    }

    public static void init() {
        try {
            String sqlAll = String.join(
                    "\n",
                    Files.readAllLines(Paths.get(INIT_DB_SQL_FILE_PATH))
            );

            Statement DBstatement = Database.getStatement();
            String[] sqlParts = sqlAll.split("\n\n");

            for (String sql : sqlParts) {
                DBstatement.addBatch(sql);
            }
            DBstatement.executeBatch();
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}