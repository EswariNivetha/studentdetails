package com.theatmo.studentinputs.studentinputimpl;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * StudentInputs.
 *
 * @author EswariNivethaVU
 */
public class StudentInputs implements StudentInputService{

    private static StudentInputService studentInputs;
    public static final Scanner SCANNER = new Scanner(System.in);

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
    public String getString(String content) {
        System.out.println(content);
        try {
            return SCANNER.next().trim();
        } catch (InputMismatchException e) {
            System.out.println("Enter Correct Value");
            return getString(content);
        }
    }
}
