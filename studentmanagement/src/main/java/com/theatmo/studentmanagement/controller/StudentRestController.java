package com.theatmo.studentmanagement.controller;

import com.theatmo.studentmanagement.model.Student;

import java.util.List;
import java.util.Map;

/**
 * StudentRestController provide Api service to Student Api implementation.
 *
 * @author EswariNivethaVU
 */
public interface StudentRestController {

    Map addStudent(final Student student);

    Map removeStudent(final Integer rollNo);

    Map updateStudentDetails(final Student student);

    List selectStudent(final Integer rollNo);

    List getAllStudents(final int page,final int limit);
}
