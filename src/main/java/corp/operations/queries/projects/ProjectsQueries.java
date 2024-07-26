package corp.operations.queries.projects;

import corp.database.Database;
import corp.classes.query.LongestProject;
import corp.classes.query.PriceProject;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import static corp.prefs.Prefs.FIND_LONGEST_PROJECT_SQL_FILE_PATH;
import static corp.prefs.Prefs.PRINT_PROJECT_PRICES_SQL_FILE_PATH;

public class ProjectsQueries {
    public List<LongestProject> findLongestProject() {
        List<LongestProject> longestProjectList = new ArrayList<>();

        try {
            String sql = String.join(
                    "\n",
                    Files.readAllLines(Paths.get(FIND_LONGEST_PROJECT_SQL_FILE_PATH))
            );

            PreparedStatement statement =  Database.getPreparedStatement(sql);
            ResultSet searchResult = statement.executeQuery();

            while(searchResult.next()) {
                String clientName = searchResult.getString("name");
                int monthCount = searchResult.getInt("month_count");

                LongestProject project = new LongestProject(clientName, monthCount);
                longestProjectList.add(project);
            }
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }

        return longestProjectList;
    }

    public List<PriceProject> printProjectPrices() {
        List<PriceProject> projectPricesList = new ArrayList<>();

        try {
            String sql = String.join(
                    "\n",
                    Files.readAllLines(Paths.get(PRINT_PROJECT_PRICES_SQL_FILE_PATH))
            );

            PreparedStatement statement =  Database.getPreparedStatement(sql);
            ResultSet searchResult = statement.executeQuery();

            while(searchResult.next()) {
                String projectName = searchResult.getString("name");
                int projectPrice = searchResult.getInt("price");

                PriceProject project = new PriceProject(projectName, projectPrice);
                projectPricesList.add(project);
            }
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }

        return projectPricesList;
    }
}
