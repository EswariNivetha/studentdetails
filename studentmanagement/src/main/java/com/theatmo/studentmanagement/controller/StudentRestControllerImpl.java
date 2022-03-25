package com.theatmo.studentmanagement.controller;

import com.theatmo.studentmanagement.model.*;
import com.theatmo.studentmanagement.service.StudentRestService;
import com.theatmo.studentmanagement.service.StudentRestServiceImpl;
import jakarta.validation.Valid;

import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * StudentRestController implements the Api Service.
 *
 * @author EswariNivethaVU
 */
@Path("/")
public class StudentRestControllerImpl implements StudentRestController {

    private static final StudentRestService STUDENT_REST_SERVICE = new StudentRestServiceImpl();

    /**
     * Adds new Student by using api.
     *
     * @param student
     */
    @Path("/add")
    @Consumes("application/json")
    @Produces("application/json")
    @POST
    @Override
    public Map addStudent(@Valid final Student student) {
        final List addStudentList = StudentValidator.validator(student);

        if (!addStudentList.isEmpty()) {
            final Map message = new HashMap();

            message.put("Message", addStudentList);
            return message;
        }
        return STUDENT_REST_SERVICE.addStudent(student);
    }

    /**
     * Deletes student by using api.
     *
     * @param rollNo
     */
    @Path("/delete")
    @Produces("application/json")
    @DELETE
    @Override
    public Map removeStudent(@Valid @QueryParam("rollNo") final Integer rollNo) {
        final List removeStudentList = StudentValidator.idValidator(rollNo);

        if (!removeStudentList.isEmpty()) {
            final Map message = new HashMap();

            message.put("Message", removeStudentList);
            return message;
        }
        return STUDENT_REST_SERVICE.removeStudent(rollNo);
    }

    /**
     * Update Student by using api.
     *
     * @param student
     */
    @Path("/update")
    @Consumes("application/json")
    @Produces("application/json")
    @PUT
    @Override
    public Map updateStudentDetails(@Valid final Student student) {
        final List updateStudentList = StudentValidator.validator(student);

        if (!updateStudentList.isEmpty()) {
            final Map message = new HashMap();

            message.put("Message", updateStudentList);
            return message;
        }
        return STUDENT_REST_SERVICE.updateStudentDetails(student);
    }

    /**
     * Select Student by using rollNo.
     */
    @Path("/select")
    @Produces("application/json")
    @Consumes("application/json")
    @GET
    @Override
    public List selectStudent(@Valid @QueryParam("rollNo") final Integer rollNo) {
        final List selectStudentList = StudentValidator.idValidator(rollNo);

        if (!selectStudentList.isEmpty()) {
            final List selectList = new ArrayList();

            selectList.add(selectStudentList);
            return selectStudentList;
        }
        return STUDENT_REST_SERVICE.selectStudent(rollNo);
    }

    /**
     * Shows all Students by using api and pagination.
     *
     * @param page
     * @param limit
     */
    @Path("/view")
    @Produces("application/json")
    @GET
    @Override
    public List getAllStudents(@Valid @QueryParam("page") final int page, @DefaultValue("3") @QueryParam("limit") final int limit) {
        return STUDENT_REST_SERVICE.getAllStudents(page, limit);
    }
}










