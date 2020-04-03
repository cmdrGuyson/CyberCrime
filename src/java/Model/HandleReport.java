package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class HandleReport {

    private final Connection connection;

    public HandleReport() {

        connection = Database_Connection.connectToDatabase();
    }

    public void addComplaint(Report report) {

        try {

            PreparedStatement statement = connection.prepareStatement("INSERT INTO report (username, description, typeOfCrime, estimatedDateOfCrime, reportedDate, status)" + " VALUES (?,?,?,?,?,?);");

            statement.setString(1, report.getUsername());
            statement.setString(2, report.getDescription());
            statement.setString(3, report.getTypeOfCrime());
            statement.setString(4, report.getEstimatedDateOfCrime());
            statement.setString(5, report.getReportedDate());
            statement.setString(6, report.getStatus());

            statement.execute();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /* USED TO GET 'PENDING' AND 'IN-PROGRESS' REPORTS FOR ADMINS AND OFFICERS */
    public List<Report> getReports(String status) {

        List<Report> reports = new ArrayList<>();

        try {

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM report WHERE status = ?;");
            statement.setString(1, status);
            ResultSet results = statement.executeQuery();

            while (results.next()) {

                PreparedStatement newStatement = connection.prepareStatement("SELECT firstName, lastName, email FROM user WHERE username = ?;");
                newStatement.setString(1, results.getString("username"));
                ResultSet newResults = newStatement.executeQuery();

                while (newResults.next()) {
                    Report report = new Report(results.getInt("reportID"), results.getString("description"), results.getString("typeOfCrime"), results.getString("status"), results.getString("username"), results.getString("estimatedDateOfCrime"), (newResults.getString("firstName") + " " + newResults.getString("lastName")), newResults.getString("email"), results.getString("reportedDate"));
                    reports.add(report);
                }

            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return reports;
    }

    /* GET INFORMATION ON ADDRESSED REPORTS BY A CERTAIN OFFICER */
    public List<Report> getMyAddressedReports(String handledOfficer) {

        List<Report> reports = new ArrayList<>();

        try {

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM report WHERE handledOfficer = ?;");
            statement.setString(1, handledOfficer);
            ResultSet results = statement.executeQuery();

            while (results.next()) {

                PreparedStatement newStatement = connection.prepareStatement("SELECT firstName, lastName, email FROM user WHERE username = ?;");
                newStatement.setString(1, results.getString("username"));
                ResultSet newResults = newStatement.executeQuery();

                while (newResults.next()) {
                    Report report = new Report(results.getInt("reportID"), results.getString("description"), results.getString("typeOfCrime"), results.getString("status"), results.getString("response"), results.getString("handledOfficer"), results.getString("username"), results.getString("estimatedDateOfCrime"), (newResults.getString("firstName") + " " + newResults.getString("lastName")), newResults.getString("email"), results.getString("reportedDate"));
                    reports.add(report);
                }

            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return reports;
    }

    /* GET INFORMATION ON A CERTAIN USERS REPORTS */
    public List<Report> getMyReports(String username) {

        List<Report> reports = new ArrayList<>();

        try {

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM report WHERE username = ?;");
            statement.setString(1, username);
            ResultSet results = statement.executeQuery();

            while (results.next()) {
                Report report = new Report(results.getInt("reportID"), results.getString("description"), results.getString("typeOfCrime"), results.getString("status"), results.getString("response"), results.getString("handledOfficer"), results.getString("estimatedDateOfCrime"), results.getString("reportedDate"));
                reports.add(report);

            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return reports;
    }

    public void changeStatus(String reportID, String status) {

        try {

            PreparedStatement statement = connection.prepareStatement("UPDATE report SET status = ? WHERE reportID = ?;");

            statement.setString(1, status);
            statement.setString(2, reportID);

            statement.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void addressReport(Report report) {

        try {

            PreparedStatement statement = connection.prepareStatement("UPDATE report SET status = ?, response = ?, handledOfficer = ? WHERE reportID = ?;");

            statement.setString(1, report.getStatus());
            statement.setString(2, report.getResponse());
            statement.setString(3, report.getHandledOfficer());
            statement.setString(4, Integer.toString(report.getReportID()));

            statement.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
