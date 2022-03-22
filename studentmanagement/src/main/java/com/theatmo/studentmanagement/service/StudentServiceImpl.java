package com.theatmo.studentmanagement.service;


import com.theatmo.studentmanagement.exception.IdAlreadyFoundException;
import com.theatmo.studentmanagement.exception.RecordNotfoundException;
import com.theatmo.studentmanagement.model.Student;
import com.theatmo.studentmanagement.studentdao.StudentDao;
import com.theatmo.studentmanagement.studentdao.StudentDaoImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Student Service Version2.
 *
 * @author EswariNivethaVU
 */
public class StudentServiceImpl implements StudentService {

    private static final StudentDao STUDENTDAO = StudentDaoImpl.getInstance();

    private static StudentService studentService;

    private StudentServiceImpl(){

    }
    /**
     * Create instance of Singleton class
     */
    public static StudentService getInstance(){

        if(studentService == null){
            studentService = new StudentServiceImpl();
        }
        return studentService;
    }

    /**
     * Adds the student details to database.
     *
     * @param student
     */
    public boolean addStudent(final Student student) {
        return STUDENTDAO.addStudent(student);
    }

    /**
     * Removes the student details from the database.
     *
     * @param rollNo
     */
    public boolean removeStudent(final int rollNo) {

        if (STUDENTDAO.removeStudent(rollNo)) {
            return true;
        }
        throw new RecordNotfoundException(" Record Not Found ");
    }

    /**
     * Get all students details from database.
     */
    public List< Student> getAllStudents() {
        return new ArrayList<Student>(STUDENTDAO.getAllStudents().values());
    }

    /**
     * Update student details to the database.
     *
     * @param student
     */
    public boolean updateStudentDetails(final Student student) {

        if (STUDENTDAO.updateStudents(student)) {
            return true;
        }
        throw new RecordNotfoundException(" Record Not Found ");
    }

    /**
     * Get values from the database.
     *
     * @param rollNo
     */
    public Student selectStudent(final int rollNo) {

        if (STUDENTDAO.getAllStudents().containsKey(rollNo)) {
            return STUDENTDAO.selectStudent(rollNo);
        } else {
            throw new RecordNotfoundException("Record Not Found");
        }
    }

    /**
     * Checks whether rollno already exist or not.
     *
     * @param rollNo
     */
    public boolean checkRollNo(final int rollNo) {

        if (!STUDENTDAO.getAllStudents().containsKey(rollNo)) {
            return true;
        }
        throw new IdAlreadyFoundException("The Given RollNo Already Exist in Table.\n Re-Enter RollNo ");
    }

    /**
     * Checks whether rollno is present or not.
     *
     * @param rollNo
     */
    public boolean checkRollNoForUpdate(final int rollNo) {

        if (STUDENTDAO.getAllStudents().containsKey(rollNo)) {
            return true;
        }
        throw new RecordNotfoundException("Record Not Found");
    }
}
