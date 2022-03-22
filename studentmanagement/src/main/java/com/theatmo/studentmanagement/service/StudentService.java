package com.theatmo.studentmanagement.service;


import com.theatmo.studentmanagement.model.Student;

import java.util.List;
import java.util.Map;


/**
 * Interface to provide StudentService.
 *
 * @author EswariNivethaVU
 */
public interface StudentService {

    boolean addStudent(final Student student);

    boolean removeStudent(final int rollNo);

    List< Student> getAllStudents();

    Student selectStudent(final int rollNo);

    boolean updateStudentDetails(final Student student);

    boolean checkRollNo(final int rollNo);

    boolean checkRollNoForUpdate(final int rollNo);
}

