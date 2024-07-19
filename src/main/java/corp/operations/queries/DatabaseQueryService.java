package corp.operations.queries;

import corp.classes.Client;
import corp.classes.query.LongestProject;
import corp.classes.query.PriceProject;
import corp.classes.query.SpecialWorker;

import corp.operations.queries.clients.ClientsQueries;
import corp.operations.queries.projects.ProjectsQueries;
import corp.operations.queries.workers.WorkersQueries;

import java.util.List;

public class DatabaseQueryService {
    public static void main(String[] args) {
        new DatabaseQueryService().makeQueries();
    }

    public void makeQueries() {
        System.out.println("Clients with the maximum number of projects were found:");
        List<Client> clients = new ClientsQueries().findMaxProjectsClient();
        for (Client client : clients) {
            System.out.println("name: " + client.getName() + "; project_count: " + client.getProjectCount() + ";");
        }

        System.out.println("Workers with the maximum salary were found:");
        List<SpecialWorker> workers = new WorkersQueries().findMaxSalaryWorker();
        for (SpecialWorker worker : workers) {
            System.out.println("name: " + worker.getName() + "; salary: " + worker.getSalary() + ";");
        }

        System.out.println("The youngest and eldest workers were found:");
        List<SpecialWorker> olderWorkers = new WorkersQueries().findYoungestAndEldestWorkers();
        for (SpecialWorker worker : olderWorkers) {
            System.out.println("name: " + worker.getName() + "; type: " + worker.getType() + "; birthday: " + worker.getBirthday() + ";");
        }

        System.out.println("Projects with the longest duration were found:");
        List<LongestProject> projects = new ProjectsQueries().findLongestProject();
        for (LongestProject project : projects) {
            System.out.println("client name: " + project.getClientName() + "; month count: " + project.getMonthCount() + ";");
        }

        System.out.println("Projects with this prices were found:");
        List<PriceProject> projectPrices = new ProjectsQueries().printProjectPrices();
        for (PriceProject project : projectPrices) {
            System.out.println("project name: " + project.getProjectName() + "; project price: " + project.getProjectPrice() + ";");
        }
    }
}
