package Model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Report {

    private int reportID;
    private String description, typeOfCrime, status, response, handledOfficer, username, estimatedDateOfCrime, fullName, email, reportedDate;

    /* Constructor used when making report */
    public Report(String description, String typeOfCrime, String username, String estimatedDateOfCrime) {
        this.description = description;
        this.typeOfCrime = typeOfCrime;
        this.status = "Pending";
        this.username = username;
        this.estimatedDateOfCrime = estimatedDateOfCrime;
        
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        
        this.reportedDate = formatter.format(new Date());
    }

    /* Constructor used when retrieving data for public*/
    public Report(int reportID, String description, String typeOfCrime, String status, String response, String handledOfficer, String username, String estimatedDateOfCrime, String reportedDate, String fullName, String email) {
        this.reportID = reportID;
        this.description = description;
        this.typeOfCrime = typeOfCrime;
        this.status = status;
        this.response = response;
        this.handledOfficer = handledOfficer;
        this.username = username;
        this.estimatedDateOfCrime = estimatedDateOfCrime;
        this.reportedDate = reportedDate;
        this.fullName = fullName;
        this.email = email;
    }
    
    /* Constructor used when retrieving data for admin */
    public Report(int reportID, String description, String typeOfCrime, String status, String username, String estimatedDateOfCrime, String fullName, String email, String reportedDate) {
        this.reportID = reportID;
        this.description = description;
        this.typeOfCrime = typeOfCrime;
        this.status = status;
        this.username = username;
        this.estimatedDateOfCrime = estimatedDateOfCrime;
        this.fullName = fullName;
        this.email = email;
        this.reportedDate = reportedDate;
    }

    public int getReportID() {
        return reportID;
    }

    public void setReportID(int reportID) {
        this.reportID = reportID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTypeOfCrime() {
        return typeOfCrime;
    }

    public void setTypeOfCrime(String typeOfCrime) {
        this.typeOfCrime = typeOfCrime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getHandledOfficer() {
        return handledOfficer;
    }

    public void setHandledOfficer(String handledOfficer) {
        this.handledOfficer = handledOfficer;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEstimatedDateOfCrime() {
        return estimatedDateOfCrime;
    }

    public void setEstimatedDateOfCrime(String estimatedDateOfCrime) {
        this.estimatedDateOfCrime = estimatedDateOfCrime;
    }

    public String getReportedDate() {
        return reportedDate;
    }

    public void setReportedDate(String reportedDate) {
        this.reportedDate = reportedDate;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
