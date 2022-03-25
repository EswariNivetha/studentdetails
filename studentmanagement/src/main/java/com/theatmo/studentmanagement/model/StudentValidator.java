package com.theatmo.studentmanagement.model;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.ws.rs.ext.Provider;
import org.hibernate.validator.HibernateValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 *  Validations by using Hibernate Validator
 *
 *  @author EswariNivethaVU
 */
@Provider
public class StudentValidator {

    private static final ValidatorFactory VALIDATOR_FACTORY = Validation.byProvider(HibernateValidator.class).configure().buildValidatorFactory();
    private static final Validator VALIDATOR = VALIDATOR_FACTORY.getValidator();

    /**
     * ConstraintViolation grouped by AddChecks and UpdateChecks.
     *
     * @param student
     */
    public static List validator(final Student student) {
        final Set<ConstraintViolation<Student>> constraintViolations = VALIDATOR.validate(student, StudentAddChecks.class, StudentUpdateChecks.class);
        final List message = new ArrayList();

        for (ConstraintViolation<Student> violation : constraintViolations) {
            message.add(violation.getMessage());
        }
        return message;
    }

    /**
     * ConstraintViolation grouped by SelectChecks and DeleteChecks by using RollNo.
     *
     * @param rollNo
     */
    public static List idValidator(final Integer rollNo) {
        final Student student = new Student();
        student.setRollNo(rollNo);

        final Set<ConstraintViolation<Student>> constraintViolations = VALIDATOR.validate(student, StudentSelectChecks.class, StudentDeleteChecks.class);
        final List message = new ArrayList();

        for (ConstraintViolation<Student> violation : constraintViolations) {
            message.add(violation.getMessage());
        }
        return message;
    }
}
