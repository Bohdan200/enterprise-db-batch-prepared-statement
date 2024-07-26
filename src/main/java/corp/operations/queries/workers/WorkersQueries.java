package corp.operations.queries.workers;

import java.time.LocalDate;
import corp.classes.query.SpecialWorker;
import corp.database.Database;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import static corp.prefs.Prefs.FIND_MAX_SALARY_WORKER_SQL_FILE_PATH;
import static corp.prefs.Prefs.FIND_YOUNGEST_ELDEST_WORKERS_SQL_FILE_PATH;

public class WorkersQueries {
    public List<SpecialWorker> findMaxSalaryWorker() {
        List<SpecialWorker> maxSalaryWorkerList = new ArrayList<>();

        try {
            String sql = String.join(
                    "\n",
                    Files.readAllLines(Paths.get(FIND_MAX_SALARY_WORKER_SQL_FILE_PATH))
            );

            PreparedStatement statement =  Database.getPreparedStatement(sql);
            ResultSet searchResult = statement.executeQuery();

            while(searchResult.next()) {
                String name = searchResult.getString("name");
                int salary = searchResult.getInt("salary");

                SpecialWorker worker = new SpecialWorker(name, salary);
                maxSalaryWorkerList.add(worker);
            }
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }

        return maxSalaryWorkerList;
    }

    public List<SpecialWorker> findYoungestAndEldestWorkers() {
        List<SpecialWorker> youngestAndEldestWorkersList = new ArrayList<>();

        try {
            String sql = String.join(
                    "\n",
                    Files.readAllLines(Paths.get(FIND_YOUNGEST_ELDEST_WORKERS_SQL_FILE_PATH))
            );

            PreparedStatement statement =  Database.getPreparedStatement(sql);
            ResultSet searchResult = statement.executeQuery();

            while(searchResult.next()) {
                String name = searchResult.getString("name");
                String type = searchResult.getString("type");
                LocalDate birthday = LocalDate.parse(searchResult.getString("birthday"));

                SpecialWorker worker = new SpecialWorker(name, type, birthday);
                youngestAndEldestWorkersList.add(worker);
            }
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }

        return youngestAndEldestWorkersList;
    }
}
