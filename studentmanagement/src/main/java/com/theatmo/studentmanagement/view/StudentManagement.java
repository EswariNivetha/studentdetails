package com.theatmo.studentmanagement.view;


import com.theatmo.studentmanagement.Activator;

import java.util.Scanner;

/**
 * StudentDetails!
 *
 * @author EswariNivethaVU
 * @version 17.0.1
 * @since 1.2
 */
public class StudentManagement {

    public static final Scanner SCANNER = new Scanner(System.in);

    /**
     * Select choice from user.
     */
    public static void selectChoice() {
        int choice = 0;
        do {
            System.out.println("STUDENT MANAGEMENT \n1.CREATE \n2.SHOW\n3.DELETE\n4.UPDATE\n5.SEARCH\n6.Exit\nEnter your choice:");
            choice = Integer.parseInt(StudentView.getChoice());

            switch (choice) {
                case 1:
                    StudentView.addStudent();
                    break;
                case 2:
                    StudentView.showAllStudents();
                    break;
                case 3:
                    StudentView.removeStudent();
                    break;
                case 4:
                    StudentView.updateStudent();
                    break;
                case 5:
                    StudentView.selectStudent();
                    break;
                case 6:
                    SCANNER.close();
                    System.exit(0);
            }
        } while (choice < 6);
    }
}
