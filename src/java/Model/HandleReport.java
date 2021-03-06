package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import static java.util.Comparator.comparingInt;
import java.util.List;
import java.util.TreeSet;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;

public class HandleReport {

    private final Connection connection;

    public HandleReport() {

        /*Make connection upon instantiation*/
        connection = Database_Connection.connectToDatabase();
    }

    /* WHEN ADDING A REPORT */
    public void addReport(Report report) {

        try {

            /* Statement to be executed to add a report to the database */
            PreparedStatement statement = connection.prepareStatement("INSERT INTO report (username, description, typeOfCrime, estimatedDateOfCrime, reportedDate, status)" + " VALUES (?,?,?,?,?,?);");

            statement.setString(1, report.getUsername());
            statement.setString(2, report.getDescription());
            statement.setString(3, report.getTypeOfCrime());
            statement.setString(4, report.getEstimatedDateOfCrime());
            statement.setString(5, report.getReportedDate());
            statement.setString(6, report.getStatus());

            statement.execute();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    /* USED TO GET 'PENDING' AND 'IN-PROGRESS' REPORTS FOR ADMINS AND OFFICERS */
    public List<Report> getReports(String status) {

        List<Report> reports = new ArrayList<>();

        try {

            /* Statement to be executed to get reports from the database with specified status */
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM report WHERE status = ?;");
            statement.setString(1, status);
            ResultSet results = statement.executeQuery();

            while (results.next()) {

                /* Statement to be executed to get user information as per report */
                PreparedStatement newStatement = connection.prepareStatement("SELECT firstName, lastName, email FROM user WHERE username = ?;");
                newStatement.setString(1, results.getString("username"));
                ResultSet newResults = newStatement.executeQuery();

                while (newResults.next()) {
                    // For each result returned make a new report object and add to reports list
                    Report report = new Report(results.getInt("reportID"), results.getString("description"), results.getString("typeOfCrime"), results.getString("status"), results.getString("username"), results.getString("estimatedDateOfCrime"), (newResults.getString("firstName") + " " + newResults.getString("lastName")), newResults.getString("email"), results.getString("reportedDate"));
                    reports.add(report);
                }

            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return reports;
    }

    /* GET INFORMATION ON ADDRESSED REPORTS BY A CERTAIN OFFICER */
    public List<Report> getMyAddressedReports(String handledOfficer) {

        List<Report> reports = new ArrayList<>();

        try {

            /* Statement to be executed to get all reports addressed by a specified officer */
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM report WHERE handledOfficer = ?;");
            statement.setString(1, handledOfficer);
            ResultSet results = statement.executeQuery();

            while (results.next()) {

                /* Statement to be executed to get user information as per report */
                PreparedStatement newStatement = connection.prepareStatement("SELECT firstName, lastName, email FROM user WHERE username = ?;");
                newStatement.setString(1, results.getString("username"));
                ResultSet newResults = newStatement.executeQuery();

                while (newResults.next()) {
                    Report report = new Report(results.getInt("reportID"), results.getString("description"), results.getString("typeOfCrime"), results.getString("status"), results.getString("response"), results.getString("handledOfficer"), results.getString("username"), results.getString("estimatedDateOfCrime"), (newResults.getString("firstName") + " " + newResults.getString("lastName")), newResults.getString("email"), results.getString("reportedDate"));
                    reports.add(report);
                }

            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return reports;
    }

    /* GET INFORMATION ON A CERTAIN USERS REPORTS */
    public List<Report> getMyReports(String username) {

        List<Report> reports = new ArrayList<>();

        try {

            /* Statement to be executed to get a specified users reports */
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM report WHERE username = ?;");
            statement.setString(1, username);
            ResultSet results = statement.executeQuery();

            while (results.next()) {
                Report report = new Report(results.getInt("reportID"), results.getString("description"), results.getString("typeOfCrime"), results.getString("status"), results.getString("response"), results.getString("handledOfficer"), results.getString("estimatedDateOfCrime"), results.getString("reportedDate"));
                reports.add(report);

            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return reports;
    }

    /* GET PUBLISHED REPORTS */
    public List<Report> getPublishedReports() {

        List<Report> reports = new ArrayList<>();

        try {

            /* Statement to be executed to get all published reports */
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM report WHERE status = 'Recovered';");
            ResultSet results = statement.executeQuery();

            while (results.next()) {
                Report report = new Report(results.getInt("reportID"), results.getString("description"), results.getString("typeOfCrime"), results.getString("status"), results.getString("response"), results.getString("handledOfficer"), results.getString("estimatedDateOfCrime"), results.getString("reportedDate"));
                reports.add(report);

            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return reports;
    }

    /* WHEN REPORT STATUS IS CHANGED */
    public void changeStatus(String reportID, String status) {

        try {

            /* Statement to be executed to change the status of a specified report */
            PreparedStatement statement = connection.prepareStatement("UPDATE report SET status = ? WHERE reportID = ?;");

            statement.setString(1, status);
            statement.setString(2, reportID);

            statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    /* WHEN OFFICER ADDRESSES A REPORT */
    public void addressReport(Report report) {

        try {

            /* Statement to be executed to address a specified report */
            PreparedStatement statement = connection.prepareStatement("UPDATE report SET status = ?, response = ?, handledOfficer = ? WHERE reportID = ?;");

            statement.setString(1, report.getStatus());
            statement.setString(2, report.getResponse());
            statement.setString(3, report.getHandledOfficer());
            statement.setString(4, Integer.toString(report.getReportID()));

            statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    /* SEARCHING FOR REPORTS USING USER ENTERED SEARCH STRING */
    public List<Report> searchReports(String searchString) {

        List<Report> reports = new ArrayList<>();

        //searchString is broken into keywords by whitespaces.
        String[] keywords = searchString.trim().split("\\s+");

        //creating a REGEXP that can be used to query.
        String searchExpression = String.join("|", keywords);

        try {

            //Searching through description for reports that have been recovered
            PreparedStatement statementA = connection.prepareStatement("SELECT * FROM report WHERE description REGEXP ? AND status = 'Recovered';");
            statementA.setString(1, searchExpression);

            ResultSet resultsA = statementA.executeQuery();

            while (resultsA.next()) {
                Report report = new Report(resultsA.getInt("reportID"), resultsA.getString("description"), resultsA.getString("typeOfCrime"), resultsA.getString("status"), resultsA.getString("response"), resultsA.getString("handledOfficer"), resultsA.getString("estimatedDateOfCrime"), resultsA.getString("reportedDate"));
                reports.add(report);
            }

            //Searching through typeOfCrime
            PreparedStatement statementB = connection.prepareStatement("SELECT * FROM report WHERE typeOfCrime REGEXP ? AND status = 'Recovered';");
            statementB.setString(1, searchExpression);

            ResultSet resultsB = statementB.executeQuery();

            while (resultsB.next()) {
                Report report = new Report(resultsB.getInt("reportID"), resultsB.getString("description"), resultsB.getString("typeOfCrime"), resultsB.getString("status"), resultsB.getString("response"), resultsB.getString("handledOfficer"), resultsB.getString("estimatedDateOfCrime"), resultsB.getString("reportedDate"));
                reports.add(report);
            }

            //Searching through response
            PreparedStatement statementC = connection.prepareStatement("SELECT * FROM report WHERE response REGEXP ? AND status = 'Recovered';");
            statementC.setString(1, searchExpression);

            ResultSet resultsC = statementC.executeQuery();

            while (resultsC.next()) {
                Report report = new Report(resultsC.getInt("reportID"), resultsC.getString("description"), resultsC.getString("typeOfCrime"), resultsC.getString("status"), resultsC.getString("response"), resultsC.getString("handledOfficer"), resultsC.getString("estimatedDateOfCrime"), resultsC.getString("reportedDate"));
                reports.add(report);
            }

            //Removing duplicates from list by comparing reportIDs and creating a tree set
            List<Report> unique = reports.stream().collect(collectingAndThen(toCollection(() -> new TreeSet<>(comparingInt(Report::getReportID))), ArrayList::new));

            reports = unique;

        } catch (SQLException e) {
            System.out.println(e);
        }

        return reports;
    }


    /* ALLOW OFFICER TO SEARCH FOR REPORTS TO BE ADDRESSED */
    public List<Report> searchReportsOfficer(String searchString) {

        List<Report> reports = new ArrayList<>();

        //searchString is broken into keywords by whitespaces.
        String[] keywords = searchString.trim().split("\\s+");

        //creating a REGEXP that can be used to query.
        String searchExpression = String.join("|", keywords);

        try {

            //Searching through description
            PreparedStatement statementA = connection.prepareStatement("SELECT * FROM report WHERE description REGEXP ? AND status IN ('In-progress');");
            statementA.setString(1, searchExpression);

            ResultSet resultsA = statementA.executeQuery();

            while (resultsA.next()) {

                //Prepared statement to get user details based on username foreign key
                PreparedStatement newStatement = connection.prepareStatement("SELECT firstName, lastName, email FROM user WHERE username = ?;");
                newStatement.setString(1, resultsA.getString("username"));
                ResultSet newResults = newStatement.executeQuery();

                while (newResults.next()) {

                    //Get report data and user data to construct report object added to reports list
                    Report report = new Report(resultsA.getInt("reportID"), resultsA.getString("description"), resultsA.getString("typeOfCrime"), resultsA.getString("status"), resultsA.getString("response"), resultsA.getString("handledOfficer"), resultsA.getString("username"), resultsA.getString("estimatedDateOfCrime"), resultsA.getString("reportedDate"), (newResults.getString("firstName") + " " + newResults.getString("lastName")), newResults.getString("email"));
                    reports.add(report);
                }
            }

            //Searching through typeOfCrime
            PreparedStatement statementB = connection.prepareStatement("SELECT * FROM report WHERE typeOfCrime REGEXP ? AND status IN ('In-progress');");
            statementB.setString(1, searchExpression);

            ResultSet resultsB = statementB.executeQuery();

            while (resultsB.next()) {

                //Prepared statement to get user details based on username foreign key
                PreparedStatement newStatement = connection.prepareStatement("SELECT firstName, lastName, email FROM user WHERE username = ?;");
                newStatement.setString(1, resultsB.getString("username"));
                ResultSet newResults = newStatement.executeQuery();

                while (newResults.next()) {

                    //Get report data and user data to construct report object added to reports list
                    Report report = new Report(resultsB.getInt("reportID"), resultsB.getString("description"), resultsB.getString("typeOfCrime"), resultsB.getString("status"), resultsB.getString("response"), resultsB.getString("handledOfficer"), resultsB.getString("username"), resultsB.getString("estimatedDateOfCrime"), resultsB.getString("reportedDate"), (newResults.getString("firstName") + " " + newResults.getString("lastName")), newResults.getString("email"));
                    reports.add(report);
                }
            }

            //Removing duplicates from list by comparing reportIDs and creating a tree set
            List<Report> unique = reports.stream().collect(collectingAndThen(toCollection(() -> new TreeSet<>(comparingInt(Report::getReportID))), ArrayList::new));

            reports = unique;

        } catch (SQLException e) {
            System.out.println(e);
        }

        return reports;
    }
}
