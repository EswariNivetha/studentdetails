package com.theatmo.studentmanagement.service;

import com.theatmo.studentmanagement.model.Student;
import com.theatmo.studentmanagement.studentdao.StudentDao;
import com.theatmo.studentmanagement.studentdao.StudentDaoImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Student Rest Service Implementation Implements the service provided by Student Rest Service.
 *
 * @author EswariNivethaVU
 */
public class StudentRestServiceImpl implements StudentRestService {

    private static final StudentDao STUDENTDAO = StudentDaoImpl.getInstance();

    /**
     * Adds the student details to database by using Api.
     *
     * @param student
     */
    @Override
    public Map addStudent(final Student student) {
        final Map map = new HashMap<>();
        boolean isAdded = false;

        if (!STUDENTDAO.getAllStudents().containsKey(student.getRollNo())) {
            isAdded = STUDENTDAO.addStudent(student);
        }
        map.put("Status added", isAdded);
        return map;
    }

    /**
     * Removes the student details from database by using Api.
     *
     * @param rollNo
     */
    @Override
    public Map removeStudent(final Integer rollNo) {
        final Map map = new HashMap<>();
        final boolean isDeleted = STUDENTDAO.removeStudent(rollNo);

        map.put("Status deleted", isDeleted);
        return map;
    }

    /**
     * Get All Students details from database by using Api.
     *
     * @param page
     *
     * @param limit
     */
    @Override
    public List getAllStudents(final int page, final int limit) {
        List<Student> studentList = new ArrayList<>(STUDENTDAO.getAllStudents().values());
        int start = 0, end = 0;

        if (page > 0 && limit >= 0) {
            start = (page - 1) * limit;
            end = limit * page;
        }

        if (start < studentList.size() && end < studentList.size()) {
            return studentList.subList(start, end);
        } else if (start < studentList.size()) {
            return studentList.subList(start, studentList.size());
        } else {
            final List emptyList = new ArrayList();
            emptyList.add("Page not found");
            return emptyList;
        }
    }

    /**
     * Select Student details from database by using Api.
     *
     * @param rollNo
     */
    @Override
    public List selectStudent(final Integer rollNo) {
        final List studentList = new ArrayList();
        final Student selectStudent = STUDENTDAO.selectStudent(rollNo);

        if (selectStudent == null) {
            studentList.add("Record  not found");
            return studentList;
        } else {
            studentList.add(selectStudent);
            return studentList;
        }
    }

    /**
     * Update Student Details to database by using Api.
     *
     * @param student
     */
    @Override
    public Map updateStudentDetails(final Student student) {
        final Map map = new HashMap<>();
        boolean isUpdated = false;

        if(STUDENTDAO.getAllStudents().containsKey(student.getRollNo())){
            isUpdated = STUDENTDAO.updateStudents(student);
        }
        map.put("Status updated", isUpdated);
        return map;
    }
}