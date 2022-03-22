package com.theatmo.studentmanagement.controller;

import com.theatmo.studentmanagement.model.Student;

import javax.ws.rs.*;
import java.util.List;
import java.util.Map;

/**
 * StudentRestController provide Api service to Student Api implementation.
 *
 * @author EswariNivethaVU
 */
public interface StudentRestController {

    @Path("/add")
    @Consumes("application/json")
    @POST
    boolean addStudent( final Student student);

    @Path("/{rollNo}")
    @Produces("application/json")
    @DELETE
    boolean removeStudent(final int rollNo);

    @Path("/put")
    @Produces("application/json")
    @PUT
    boolean updateStudentDetails(final Student student);

    @Path("/{rollNo}")
    @Produces("application/json")
    @GET
    Student searchStudentDetail(final int rollNo);

    @Path("/view")
    @Produces("application/json")
    @GET
    List<Student> getAllStudentdetails(int start, int limit);
}
