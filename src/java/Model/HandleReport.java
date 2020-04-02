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

    public List<Report> getPendingReports() {

        List<Report> pendingReports = new ArrayList<>();

        try {

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM report WHERE status = 'Pending';");
            ResultSet results = statement.executeQuery();

            while (results.next()) {

                PreparedStatement newStatement = connection.prepareStatement("SELECT firstName, lastName, email FROM user WHERE username = ?;");
                newStatement.setString(1, results.getString("username"));
                ResultSet newResults = newStatement.executeQuery();

                while (newResults.next()) {
                    Report report = new Report(results.getInt("reportID"), results.getString("description"), results.getString("typeOfCrime"), results.getString("status"), results.getString("username"), results.getString("estimatedDateOfCrime"), (newResults.getString("firstName") + " " + newResults.getString("lastName")), newResults.getString("email"), results.getString("reportedDate"));
                    pendingReports.add(report);
                }

            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return pendingReports;
    }

    public void changeStatus(String reportID, String status) {
        
        try {
            
            PreparedStatement statement = connection.prepareCall("UPDATE report SET status = ? WHERE reportID = ?;");
            
            statement.setString(1, status);
            statement.setString(2, reportID);
            
            statement.executeUpdate();
            
        }catch(Exception e){
            System.out.println(e);
        }   
    }  
}
