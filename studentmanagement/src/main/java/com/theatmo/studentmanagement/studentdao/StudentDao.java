package com.theatmo.studentmanagement.studentdao;

import com.theatmo.studentmanagement.model.Student;

import java.util.Map;

/**
 * Interface to provide StudentDao Implementation.
 *
 * @author EswariNivethaVU
 */
public interface StudentDao {

    boolean addStudent( final Student student);

    boolean removeStudent(final int rollno);

    Map<Integer, Student> getAllStudents();

    boolean updateStudents(final Student student);

    Student selectStudent(final int rollno);
}
