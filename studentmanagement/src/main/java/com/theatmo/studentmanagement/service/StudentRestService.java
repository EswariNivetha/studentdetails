package com.theatmo.studentmanagement.service;

import com.theatmo.studentmanagement.model.Student;

import java.util.List;
import java.util.Map;

public interface StudentRestService {

    Map addStudent(final Student student);

    Map removeStudent(final int rollNo);

    List getAllStudents(final int page, final int limit);

    List selectStudent(final int rollNo);

    Map updateStudentDetails(final Student student);
}









