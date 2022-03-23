package com.theatmo.studentmanagement.view;

import com.theatmo.studentinputs.studentinputimpl.StudentInputService;

import com.theatmo.studentinputs.studentinputimpl.StudentInputs;
import com.theatmo.studentmanagement.controller.StudentController;
import com.theatmo.customexception.exception.CustomException;
import com.theatmo.studentmanagement.model.Student;
import com.theatmo.validation.studentvalidation.CommonValidation;
import org.apache.log4j.Logger;

import java.sql.Date;

/**
 * Student, View! The StudentView program implements an application that simply
 * displays "User input".
 *
 * @author EswariNivethaVU
 */
public class StudentView {

    private static final CommonValidation VALIDATOR = new CommonValidation();
    private static final StudentView STUDENT_VIEW = new StudentView();
    private static final Logger LOGGER = Logger.getLogger(StudentView.class);
    private static final StudentInputService STUDENT_INPUTS = StudentInputs.getInstance();
    private static final StudentController STUDENT_CONTROLLER = new StudentController();

    /**
     * Get rollno from the user.
     */
    public int getRollNo() {
        final String rollNo = STUDENT_INPUTS.getString("Enter the RollNo(Give 3 Digit No): \n Press @ To Exit to Main Menu");
        STUDENT_VIEW.mainMenu(rollNo);

        if (Validation.validateRollNo(rollNo)) {
            return Integer.parseInt(rollNo);
        } else {
            LOGGER.warn("InValid RollNo Please Enter a valid RollNo \n Press @ To Exit to Main Menu");
            return STUDENT_VIEW.getRollNo();
        }
    }

    /**
     * Get the name from the user.
     */
    public String getName() {
        final String name = STUDENT_INPUTS.getString("Enter the Name: \n Press @ To Exit to Main Menu");
        STUDENT_VIEW.mainMenu(name);

        if (VALIDATOR.validateName(name)) {
            return name;
        } else {
            LOGGER.warn(" InValid Name Please Enter a valid Name \n Press @ To Exit to Main Menu");
            return STUDENT_VIEW.getName();
        }
    }

    /**
     * Get standard from the user.
     */
    public String getStandard() {
        final String standard = STUDENT_INPUTS.getString("Enter the Standard [PREKG - UKG, 1-12] \n Press @ To Exit to Main Menu");
        STUDENT_VIEW.mainMenu(standard);

        if (Validation.validateStandard(standard)) {
            return standard;
        } else {
            LOGGER.warn(" InValid Standard Please Enter a valid Standard  \n Press @ To Exit to Main Menu");
            return STUDENT_VIEW.getStandard();
        }
    }

    /**
     * Get phone no from the user.
     */
    public long getPhoneNo() {
        final String phoneNo = STUDENT_INPUTS.getString("Enter the PhoneNumber: \n Press @ To Exit to Main Menu");
        STUDENT_VIEW.mainMenu(phoneNo);

        if (VALIDATOR.validatePhoneNo(phoneNo)) {
            return Long.parseLong(phoneNo);
        } else {
            LOGGER.warn(" InValid PhoneNo Please Enter a valid PhoneNo \n Press @ To Exit to Main Menu");
            return STUDENT_VIEW.getPhoneNo();
        }
    }

    /**
     * Get emailid from the user.
     */
    public String getEmailId() {
        final String emailId = STUDENT_INPUTS.getString("Enter the EmailId: \n Press @ To Exit to Main Menu");
        STUDENT_VIEW.mainMenu(emailId);

        if (VALIDATOR.validateEmailId(emailId)) {
            return emailId;
        } else {
            LOGGER.warn("InValid EmailId Please Enter a valid MailId  \n Press @ To Exit to Main Menu");
            return STUDENT_VIEW.getEmailId();
        }
    }

    /**
     * Get a date from the user.
     */
    public Date getDate() {
        final String date = STUDENT_INPUTS.getString("Enter Date of Joining(yyyy-mm-dd):");
        STUDENT_VIEW.mainMenu(date);
        boolean isValid = false;

        try {
            isValid = VALIDATOR.validateDate(date);
        } catch (CustomException customException) {
            LOGGER.error(customException.getMessage());
        }

        if (isValid) {
            return Date.valueOf(date);
        } else {
            LOGGER.warn("InValid Date Please Enter a valid Date \n Press @ To Exit to Main Menu");
            return STUDENT_VIEW.getDate();
        }
    }

    /**
     * AddStudent by getting values from view and sending a request to the
     * controller.
     */
    public static void addStudent() {
        final int rollNo = STUDENT_VIEW.getRollNo();

        try {
            STUDENT_CONTROLLER.checkRollno(rollNo);
        } catch (CustomException customException) {
            LOGGER.error(customException);
            StudentView.addStudent();
            StudentManagement.selectChoice();
        }
        final String name = STUDENT_VIEW.getName();
        final String standard = STUDENT_VIEW.getStandard();
        final long phoneNo = STUDENT_VIEW.getPhoneNo();
        final String emailId = STUDENT_VIEW.getEmailId();
        final Date Date = STUDENT_VIEW.getDate();

        final Student student = new Student(rollNo, name, standard, phoneNo, emailId, Date);

        try {

            if (STUDENT_CONTROLLER.addStudent(student)) {
               LOGGER.info("Inserted SuccessFully");
            }
        } catch (CustomException customException) {
            LOGGER.error(customException.getMessage());
        }
    }

    /**
     * Display all Students and send a request to the controller.
     */
    public static void showAllStudents() {
        LOGGER.info(STUDENT_CONTROLLER.getAllStudents());
    }

    /**
     * RemoveStudent by getting key from StudentView and sending a request to
     * controller.
     */
    public static void removeStudent() {
        try {

            if (STUDENT_CONTROLLER.removeStudent(STUDENT_VIEW.getRollNo())) {
                LOGGER.info("Deleted SuccessFully");
            }
        } catch (CustomException customException) {
            LOGGER.error(customException.getMessage());
        }
    }

    /**
     * GetStudent by getting key from StudentView and sending a request to
     * controller.
     */
    public static void selectStudent() {
        try {
            LOGGER.info(STUDENT_CONTROLLER.searchStudentDetail(STUDENT_VIEW.getRollNo()));
        } catch (CustomException customException) {
            LOGGER.error(customException.getMessage());
        }
    }

    /**
     * UpdateStudents detail.
     */
    public static void updateStudent() {
        final String name = "name";
        final String standard = "standard";
        final String phoneNo = "phoneNo";
        final String emailId = "emailId";
        final String date = "date";
        final Student student = new Student();
        final int rollNo = STUDENT_VIEW.getRollNo();

        try {
            STUDENT_CONTROLLER.checkRollnoForUpdate(rollNo);
        } catch (CustomException customException) {
            LOGGER.error(customException.getMessage());
            StudentView.updateStudent();
            StudentManagement.selectChoice();
        }
        student.setRollNo(rollNo);
        LOGGER.info("Do you want to change your name? yes or no \n Press @ To Exit to Main Menu ");
        StudentView.updateDetail(student, name);
        LOGGER.info("Do you want to change your standard? yes or no \n Press @ To Exit to Main Menu ");
        StudentView.updateDetail(student, standard);
        LOGGER.info("Do you want to change your phoneno? yes or no \n Press @ To Exit to Main Menu");
        StudentView.updateDetail(student, phoneNo);
        LOGGER.info("Do you want to change your email? yes or no \n Press @ To Exit to Main Menu");
        StudentView.updateDetail(student, emailId);
        LOGGER.info("Do you want to change your joiningdate? yes or no \n Press @ To Exit to Main Menu");
        StudentView.updateDetail(student, date);

        try {
            if (STUDENT_CONTROLLER.updateStudentDetails(student)) {
              LOGGER.info("Updated Successfully");
            }
        } catch (CustomException customException) {
            LOGGER.error(customException.getMessage());
        }
    }

    /**
     * Checking next field for update.
     *
     * @param student
     * @param studentdetail
     * @return
     */
    public static Student updateDetail(final Student student, final String studentdetail) {
        final String choiceYes = "yes";
        final String choiceNo = "no";

        while (true) {
            final String option = StudentManagement.SCANNER.next().trim();
            STUDENT_VIEW.mainMenu(option);

            if (choiceYes.equalsIgnoreCase(option)) {

                if ("name".equalsIgnoreCase(studentdetail)) {
                    student.setName(STUDENT_VIEW.getName());
                    break;
                } else if ("standard".equalsIgnoreCase(studentdetail)) {
                    student.setStandard(STUDENT_VIEW.getStandard());
                    break;
                } else if ("phoneno".equalsIgnoreCase(studentdetail)) {
                    student.setPhonenumber(STUDENT_VIEW.getPhoneNo());
                    break;
                } else if ("emailId".equalsIgnoreCase(studentdetail)) {
                    student.setEmailId(STUDENT_VIEW.getEmailId());
                    break;
                } else if ("date".equalsIgnoreCase(studentdetail)) {
                    student.setDate(STUDENT_VIEW.getDate());
                    break;
                }
            } else if (choiceNo.equalsIgnoreCase(option)) {
                break;
            } else {
                LOGGER.warn("Invalid Option");
                continue;
            }
        }
        return student;
    }

    /**
     * Getting choice from the user.
     */
    public static String getChoice() {
        final String choice = StudentManagement.SCANNER.next().trim();

        if (Validation.validateChoice(choice)) {
            return choice;
        } else {
            LOGGER.warn("Please Enter Valid Choice use only [1-6]");
            return StudentView.getChoice();
        }
    }

    /**
     * Back to main menu.
     */
    public void mainMenu(String option) {

        if ("@".equals(option)) {
            StudentManagement.selectChoice();
        }
    }
}