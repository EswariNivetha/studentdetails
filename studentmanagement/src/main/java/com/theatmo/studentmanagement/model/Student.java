package com.theatmo.studentmanagement.model;

import jakarta.validation.constraints.NotNull;

import java.sql.Date;

/**
 * Model class to hold Student information
 *
 * @author EswariNivethaVU
 */
public class Student {

    @NotNull(message = "Please Enter RollNo", groups = {StudentSelectChecks.class, StudentAddChecks.class, StudentUpdateChecks.class, StudentSelectChecks.class, StudentDeleteChecks.class})
    private Integer rollNo;

    @NotNull(message = "Please Enter Name", groups = {StudentAddChecks.class, StudentUpdateChecks.class})
    private String name;

    @NotNull(message = "Please Enter Standard", groups = {StudentAddChecks.class, StudentUpdateChecks.class})
    private String standard;

    @NotNull(message = "Please Enter PhoneNumber", groups = {StudentAddChecks.class, StudentUpdateChecks.class})
    private Long phoneNumber;

    @NotNull(message = "Please Enter MailId", groups = {StudentAddChecks.class, StudentUpdateChecks.class})
    private String emailId;

    @NotNull(message = "Please Enter Date", groups = {StudentAddChecks.class, StudentUpdateChecks.class})
    private Date date;

    public Student() {
        super();
    }

    public Student(Integer rollNo, String name, String standard, Long phoneNumber, String emailId, Date date) {
        this.rollNo = rollNo;
        this.name = name;
        this.standard = standard;
        this.phoneNumber = phoneNumber;
        this.emailId = emailId;
        this.date = date;
    }

    public Integer getRollNo() {
        return rollNo;
    }

    public void setRollNo(Integer rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public Long getPhonenumber() {
        return phoneNumber;
    }

    public void setPhonenumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Convert to standard string format
     *
     * @return a <code> string </code> representing Student in standard format
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("RollNo: ").append(rollNo).append("\n").append("Name: ").append(name).append("\n").append("Standard: ").append(standard).append("\n").append("PhoneNumber: ").append(phoneNumber)
                .append("\n").append("EmailId: ").append(emailId).append("\n").append("Date: ").append(date).append("\n");
        return builder.toString();
    }
}

