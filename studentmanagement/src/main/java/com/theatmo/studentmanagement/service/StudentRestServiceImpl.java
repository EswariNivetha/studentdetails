package com.theatmo.studentmanagement.service;

import com.theatmo.studentmanagement.model.Student;
import com.theatmo.studentmanagement.studentdao.StudentDao;
import com.theatmo.studentmanagement.studentdao.StudentDaoImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentRestServiceImpl implements StudentRestService {

    private static final StudentDao STUDENTDAO = StudentDaoImpl.getInstance();

    @Override
    public Map addStudent(Student student) {
        final Map map = new HashMap<>();
        boolean isAdded = false;
        if (!STUDENTDAO.getAllStudents().containsKey(student.getRollNo())) {
            isAdded = STUDENTDAO.addStudent(student);
        }
        map.put("Status added", isAdded);
        return map;
    }

    @Override
    public Map removeStudent(int rollNo) {
        final Map map = new HashMap<>();
        final boolean isDeleted = STUDENTDAO.removeStudent(rollNo);
        map.put("Status deleted", isDeleted);
        return map;
    }

    @Override
    public List getAllStudents(int page, int limit) {
        List<Student> list = new ArrayList<>(STUDENTDAO.getAllStudents().values());

        int start = 0, end = 0;

        if (page > 0 && limit >= 0) {
            start = (page - 1) * limit;
            end = limit * page;
        }

        if (start < list.size() && end < list.size()) {
            return list.subList(start, end);
        } else if (start < list.size()) {
            return list.subList(start, list.size());
        } else {
            final List emptyList = new ArrayList();
            emptyList.add("Page not found");
            return emptyList;
        }
    }

    @Override
    public List selectStudent(int rollNo) {
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

    @Override
    public Map updateStudentDetails(Student student) {
        final Map map = new HashMap<>();
        final boolean isUpdated = STUDENTDAO.updateStudents(student);
        map.put("Status updated", isUpdated);
        return map;
    }
}