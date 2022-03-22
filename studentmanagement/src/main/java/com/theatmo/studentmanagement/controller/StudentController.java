package com.theatmo.studentmanagement.controller;

import com.theatmo.studentmanagement.service.StudentService;
import com.theatmo.studentmanagement.service.StudentServiceImpl;
import com.theatmo.studentmanagement.model.Student;
import java.util.List;

/**
 * Controller act as a mediator between view and model.
 *
 * @author EswariNivethaVU
 */
public class StudentController  {

    private static final StudentService STUDENT_SERVICE =  StudentServiceImpl.getInstance();

    /**
     * Adding Student Details.
     *
     * @param student
     */
    public  boolean addStudent(final Student student) {
        return STUDENT_SERVICE.addStudent(student);
    }

    /**
     * Removing Student Detail
     *
     * @param rollNo
     */
    public  boolean removeStudent(final int rollNo) {
        return STUDENT_SERVICE.removeStudent(rollNo);
    }

    /**
     * Updating Student Detail
     *
     * @param student
     */
    public  boolean updateStudentDetails(final Student student) {
        return STUDENT_SERVICE.updateStudentDetails(student);
    }

    /**
     * Getting all the Student Details.
     */
    public  List<Student> getAllStudents() {
        return STUDENT_SERVICE.getAllStudents();
    }

    /**
     * Searching Student Detail by using rollno
     *
     * @param rollNo
     */
    public  Student searchStudentDetail(final int rollNo) {
        return STUDENT_SERVICE.selectStudent(rollNo);
    }

    /**
     * Checks whether rollno already exist or not.
     *
     * @param rollNo
     */
    public  boolean checkRollno(final int rollNo) {
        return STUDENT_SERVICE.checkRollNo(rollNo);
    }

    /**
     * Checks whether rollno is present or not.
     *
     * @param rollNo
     */
    public  boolean checkRollnoForUpdate(final int rollNo) {
        return STUDENT_SERVICE.checkRollNoForUpdate(rollNo);
    }
}
