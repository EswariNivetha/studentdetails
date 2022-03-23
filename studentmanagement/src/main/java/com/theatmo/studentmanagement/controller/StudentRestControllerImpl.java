package com.theatmo.studentmanagement.controller;

import com.theatmo.studentmanagement.model.Student;
import com.theatmo.studentmanagement.service.StudentRestService;
import com.theatmo.studentmanagement.service.StudentRestServiceImpl;

import javax.ws.rs.*;
import java.util.List;
import java.util.Map;

/**
 * StudentApi implements the Api Service .
 *
 * @author EswariNivethaVU
 */
@Path("/")
public class StudentRestControllerImpl implements StudentRestController {

    private static final StudentRestService STUDENT_REST_SERVICE = new StudentRestServiceImpl();

    /**
     * Adds new Student using api.
     *
     * @param student
     */
    @Path("/add")
    @Consumes("application/json")
    @Produces("application/json")
    @POST
    @Override
    public Map addStudent(final Student student) {
        return STUDENT_REST_SERVICE.addStudent(student);
    }

    /**
     * Deletes student using api.
     *
     * @param rollNo
     */
    @Path("/{rollNo}")
    @Produces("application/json")
    @DELETE
    @Override
    public Map removeStudent(@PathParam("rollNo") final int rollNo) {
        return STUDENT_REST_SERVICE.removeStudent(rollNo);
    }

    /**
     * Update Student using api.
     *
     * @param student
     */
    @Path("/update")
    @Consumes("application/json")
    @Produces("application/json")
    @PUT
    @Override
    public Map updateStudentDetails(Student student) {
        return STUDENT_REST_SERVICE.updateStudentDetails(student);
    }

    /**
     * Select Student using rollNo.
     */
    @Path("/{rollNo}")
    @Produces("application/json")
    @GET
    @Override
    public List selectStudent(@PathParam("rollNo") final int rollNo) {
        return STUDENT_REST_SERVICE.selectStudent(rollNo);
    }

    /**
     * Shows all Students using api and pagination.
     *
     * @param page
     * @param limit
     */
    @Path("/view")
    @Produces("application/json")
    @GET
    @Override
    public List getAllStudents(@QueryParam("page") final int page, @DefaultValue("3") @QueryParam("limit") final int limit) {
        return STUDENT_REST_SERVICE.getAllStudents(page, limit);
    }
}










