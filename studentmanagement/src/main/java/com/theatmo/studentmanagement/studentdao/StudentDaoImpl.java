package com.theatmo.studentmanagement.studentdao;

import com.theatmo.databaseconnection.dbconnection.DataBaseConnection;
import com.theatmo.studentmanagement.exception.SqlQueryException;
import com.theatmo.studentmanagement.model.Student;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

/**
 * StudentDao Implementation implements the service provided by StudentDao  .
 *
 * @author EswariNivethaVU
 */
public class StudentDaoImpl implements StudentDao {

    private static StudentDao studentDao;

    private StudentDaoImpl(){

    }

    /**
     * Create instance of Singleton class
     */
    public static StudentDao getInstance(){

        if(studentDao == null){
            studentDao = new StudentDaoImpl();
        }
        return studentDao;
    }

    /**
     * AddStudent details to database.
     *
     * @param student
     */
    public boolean addStudent(final Student student) {
        final String InsertStudent = "INSERT INTO student(rollno, name, standard, phoneno, emailid, joiningdate, isdeleted) VALUES (?, ?, ?, ?, ?, ? ,?)";

        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(InsertStudent);) {
            statement.setInt(1, student.getRollNo());
            statement.setString(2, student.getName());
            statement.setString(3, student.getStandard());
            statement.setLong(4, student.getPhonenumber());
            statement.setString(5, student.getEmailId());
            statement.setDate(6, student.getDate());
            statement.setBoolean(7, false);

            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new SqlQueryException("Invalid Query So Database Access Failed");
        }
    }

    /**
     * Remove Student details from database.
     *
     * @param rollno
     */
    public boolean removeStudent(final int rollno) {
        final String removeStudent = "UPDATE student SET isdeleted = ? where rollno = ? and isdeleted = ? ";

        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(removeStudent);) {
            statement.setBoolean(1, true);
            statement.setInt(2, rollno);
            statement.setBoolean(3, false);

            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new SqlQueryException("Invalid Query So Database Access Failed");
        }
    }

    /**
     * Retrive all student details from database.
     */
    public Map<Integer, Student> getAllStudents() {
        final String getstudent = "Select * From student where isdeleted = false ";
        final Map<Integer, Student> Studentlist = new HashMap<Integer, Student>();

        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(getstudent);
             ResultSet resultset = statement.executeQuery();) {

            while (resultset.next()) {
                Student student = new Student(resultset.getInt("rollno"), resultset.getString("name"),
                        resultset.getString("standard"), resultset.getLong("phoneno"), resultset.getString("emailid"),
                        resultset.getDate("joiningdate"));

                Studentlist.put(student.getRollNo(), student);
            }
        } catch (SQLException e) {
            throw new SqlQueryException("Invalid Query So Database Access Failed");
        }
        return Studentlist;
    }

    /**
     * Update student details in database.
     *
     * @param student
     */
    public boolean updateStudents(final Student student) {

        try (Connection connection = DataBaseConnection.getConnection();) {
            final StringBuilder queryBuilder = new StringBuilder();
            String updateStudent = queryBuilder.append("update student set").toString();
            boolean hasNextField = false;
            int name = 1;
            int standard = 1;
            int emailId = 1;
            int phoneNo = 1;
            int date = 1;
            int rollNo = 1;
            int count = 0;

            if (student.getName() != null) {
                updateStudent = queryBuilder.append(" name = ?").toString();
                hasNextField = true;
                count += 1;
            }

            if (student.getStandard() != null) {

                if (hasNextField) {
                    updateStudent = queryBuilder.append(",").toString();
                    standard = count + 1;
                }
                updateStudent = queryBuilder.append(" standard = ?").toString();
                hasNextField = true;
                count += 1;
            }

            if (student.getEmailId() != null) {

                if (hasNextField) {
                    updateStudent = queryBuilder.append(",").toString();
                    emailId = count + 1;
                }
                updateStudent = queryBuilder.append(" emailid = ?").toString();
                hasNextField = true;
                count += 1;
            }

            if (student.getPhonenumber() != 0) {

                if (hasNextField) {
                    updateStudent = queryBuilder.append(",").toString();
                    phoneNo = count + 1;
                }
                updateStudent = queryBuilder.append(" phoneno = ?").toString();
                hasNextField = true;
                count += 1;
            }

            if (student.getDate() != null) {

                if (hasNextField) {
                    updateStudent = queryBuilder.append(",").toString();
                    date = count + 1;
                }
                updateStudent = queryBuilder.append(" joiningdate = ?").toString();
                count += 1;
            }
            updateStudent = queryBuilder.append(" where rollno = ?").toString();
            rollNo = count + 1;
            final PreparedStatement statement = connection.prepareStatement(updateStudent);

            if (student.getName() != null) {
                statement.setString(name, student.getName());
            }

            if (student.getStandard() != null) {
                statement.setString(standard, student.getStandard());
            }

            if (student.getPhonenumber() != 0) {
                statement.setLong(phoneNo, student.getPhonenumber());
            }

            if (student.getEmailId() != null) {
                statement.setString(emailId, student.getEmailId());
            }

            if (student.getDate() != null) {
                statement.setDate(date, student.getDate());
            }
            statement.setInt(rollNo, student.getRollNo());
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new SqlQueryException("Invalid Query So Database Access Failed ");
        }
    }

    /**
     * Select student detail from database.
     *
     * @param rollno
     */
    public Student selectStudent(final int rollno) {
        Student student = null;
        final String getstudent = "Select rollno, name, standard, emailid, phoneno, joiningdate From student where rollno = ?";

        try (final Connection connection = DataBaseConnection.getConnection();
             final PreparedStatement statement = connection.prepareStatement(getstudent);) {
            statement.setInt(1, rollno);

            try (ResultSet resultset = statement.executeQuery();) {

                while (resultset.next()) {
                    final String name = resultset.getString(2);
                    final String standard = resultset.getString(3);
                    final String emailid = resultset.getString(4);
                    final long phoneno = resultset.getLong(5);
                    final Date joiningdate = resultset.getDate(6);

                    student = new Student(rollno, name, standard, phoneno, emailid, joiningdate);
                }
            }
        } catch (SQLException e) {
            throw new SqlQueryException(" Invalid Query So Database Access Failed");
        }
        return student;
    }
}

