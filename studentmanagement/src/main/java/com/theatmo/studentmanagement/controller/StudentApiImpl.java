package com.theatmo.studentmanagement.controller;

import com.theatmo.studentmanagement.model.Student;

import javax.ws.rs.*;
import java.util.List;


/**
 * StudentApiImpl.
 *
 * @author EswariNivethaVU
 */
@Path("/")
public class StudentApiImpl extends StudentController implements StudentRestController {

    /**
     * POST
     *
     * @param student
     */
    @Override
    @Path("/add")
    @Consumes("application/json")
    @POST
    public boolean addStudent(final Student student) {
        return super.addStudent(student);
    }

    /**
     * DELETE
     *
     * @param rollNo
     */
    @Override
    @Path("/{rollNo}")
    @Produces("application/json")
    @DELETE
    public boolean removeStudent(@PathParam("rollNo") final int rollNo) {
        return super.removeStudent(rollNo);
    }

    /**
     * PUT
     *
     * @param student
     */
    @Override
    @Path("/put")
    @Produces("application/json")
    @PUT
    public boolean updateStudentDetails(final Student student) {
        return super.updateStudentDetails(student);
    }

    /**
     * GET which view the student details by particular limit.
     */
    @Override
    @Path("/view")
    @Produces("application/json")
    @GET
    public List<Student> getAllStudentdetails(@QueryParam("page") int page,@DefaultValue("5") @QueryParam("limit") int limit) {
        List<Student> list = super.getAllStudents();
        int start = 0, end = 0;

        if (page > 0 && limit >= 0) {
            start = ((page - 1) * limit);
            end = limit * page;
        }

        if(start < list.size() && end < list.size()){
            return list.subList(start , end);
        }

        else if(start < list.size()){
            return list.subList(start, list.size());
        }
       return null;
    }

    /**
     * GET which view all the student details.
     */
    @Path("/view")
    @Produces("application/json")
    @GET
    public List<Student> getAllStudentdetails(){
        return super.getAllStudents();
    }

    /**
     * GET which Search and get Student Detail by using rollno
     *
     * @param rollNo
     */
    @Override
    @Path("/{rollNo}")
    @Produces("application/json")
    @GET
    public Student searchStudentDetail(@PathParam("rollNo") final int rollNo) {
        return super.searchStudentDetail(rollNo);
    }
}
