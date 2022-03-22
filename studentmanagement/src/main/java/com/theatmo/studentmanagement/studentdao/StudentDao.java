package com.theatmo.studentmanagement.studentdao;


import com.theatmo.studentmanagement.model.Student;

import java.util.Map;

/**
 * Interface to provide StudentDao Implementation.
 *
 * @author EswariNivethaVU
 */
public interface StudentDao {

    boolean addStudent(Student student);

    boolean removeStudent(int rollno);

    Map<Integer, Student> getAllStudents();

    boolean updateStudents(Student student);

    Student selectStudent(int rollno);
}
