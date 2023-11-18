package edu.dandaev_it.jdbc.jdbc_educational_project.utils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.dandaev_it.jdbc.jdbc_educational_project.model.Student;

public class CRUDOperationsProvider {
	private static final String INSERTION_QUERY = "insert into students(first_name, last_name, departament_name) values(?, ?, ?);";
	private static final String SELECTION_QUERY = "select * from students;";

	public static List<Student> selectAllStudents () {
		List<Student> students = new ArrayList<Student> ();
		try (PreparedStatement preparedStatement = DatabaseConnector.getConnection ()
																	.prepareStatement (SELECTION_QUERY);
				ResultSet resultSet = preparedStatement.executeQuery ();) {

			Student studentHolder = new Student ();
			while (resultSet.next ()) {
				studentHolder.setId (resultSet.getInt ("id"));
				studentHolder.setFirstName (resultSet.getString ("first_name"));
				studentHolder.setLastName (resultSet.getString ("last_name"));
				studentHolder.setDepartmentName (resultSet.getString ("departament_name"));
				students.add (new Student (studentHolder));
			}
		} catch (SQLException e) {
			e.printStackTrace ();
		}
		return students;
	}

	public static void insertStudent () {
		List<Student> students = Student.getStudentList ();
		try (PreparedStatement preparedStatement = DatabaseConnector.getConnection ()
																	.prepareStatement (INSERTION_QUERY);
				ResultSet resultSet = preparedStatement.executeQuery ();) {
			preparedStatement.setString (1, students.get (0)
													.getFirstName ());
			preparedStatement.setString (2, students.get (1)
													.getLastName ());
			preparedStatement.setString (3, students.get (2)
													.getDepartmentName ());
			preparedStatement.execute ();
			
		} catch (SQLException e) {
			e.printStackTrace ();
		}
	}

}
