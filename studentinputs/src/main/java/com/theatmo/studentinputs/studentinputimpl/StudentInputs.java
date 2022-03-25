package com.theatmo.studentinputs.studentinputimpl;

import org.apache.log4j.Logger;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * StudentInputs implements the service provided by StudentInputService.
 *
 * @author EswariNivethaVU
 */
public class StudentInputs implements StudentInputService{

    public static final Scanner SCANNER = new Scanner(System.in);
    private static StudentInputService studentInputs;
    private static final Logger LOGGER = Logger.getLogger(StudentInputs.class);


    /**
     * Creating private constructor restricted to this class itself
     */
    private StudentInputs(){

    }

    /**
     * Create instance of Singleton class
     */
    public static StudentInputService getInstance(){

        if(studentInputs == null){
            studentInputs = new StudentInputs();
        }
        return studentInputs;
    }

    /**
     * Getting input String
     *
     * @param content
     */
    public String getString(final String content) {
        System.out.println(content);

        try {
            return SCANNER.next().trim();
        } catch (InputMismatchException e) {
            LOGGER.warn("Enter Correct Value");
            return getString(content);
        }
    }
}
