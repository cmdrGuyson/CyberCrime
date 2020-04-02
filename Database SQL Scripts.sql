CREATE DATABASE cyber_crime;
USE cyber_crime;

CREATE TABLE User(
	username VARCHAR(50) PRIMARY KEY,
    email VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    firstName VARCHAR(50) NOT NULL,
    lastName VARCHAR(50) NOT NULL,
    dateRegistered DATE NOT NULL,
    typeOfUser VARCHAR(20) NOT NULL,
    status VARCHAR(20) NOT NULL,
    
    CHECK(typeOfUser IN ('admin', 'officer', 'user')),
    CHECK(status IN ('Active', 'Inactive', 'Pending'))
    
);

CREATE TABLE Report(
	reportID int NOT NULL AUTO_INCREMENT,
    description VARCHAR(255) NOT NULL,
    typeOfCrime VARCHAR(50) NOT NULL,
    estimatedDateOfCrime DATE NOT NULL,
    reportedDate DATE NOT NULL,
    status VARCHAR(20) NOT NULL,
    response VARCHAR(255),
    handledOfficer VARCHAR(50),
    username VARCHAR(50) NOT NULL, FOREIGN KEY (username) REFERENCES User(username),
    PRIMARY KEY (reportID),
    
    CHECK(status IN ('In-progress', 'Recovered', 'Pending', 'Insufficient Data', 'Rejected')),
    CHECK(typeOfCrime IN ('Hacking Attempt', 'Phishing Attack', 'Ransomware', 'Cash Poisoning', 'Email Bomb', 'DDoS', 'Privacy Violation', 'Malware', 'Other'))
);

SELECT * FROM user;

INSERT INTO user VALUES ('admin', 'admin@email.com', 'password', 'Jason', 'Segal', '2020-04-01', 'admin', 'Active');