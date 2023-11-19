package edu.dandaev_it.jdbc.jdbc_educational_project.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.dandaev_it.jdbc.jdbc_educational_project.model.Student;

public class CRUDOperationsProvider {
	private static Connection connection = null;

	private static final String INSERTION_QUERY = "insert into students(first_name, last_name, departament_name) values(?, ?, ?);";
	private static final String SELECTION_QUERY = "select * from students;";
	private static final String UPDATE = "update students set departament_name = ?, last_name = ?, first_name = ? where id = ?;";
	private static final String DELETE = "delete students where id = ?;";

	public static List<Student> selectAllStudents () {
		List<Student> students = new ArrayList<Student>();
		try (PreparedStatement preparedStatement = initializeConnection().prepareStatement(SELECTION_QUERY); ResultSet resultSet = preparedStatement.executeQuery();) {

			Student studentHolder = new Student();
			while (resultSet.next()) {
				studentHolder.setId(resultSet.getInt("id"));
				studentHolder.setFirstName(resultSet.getString("first_name"));
				studentHolder.setLastName(resultSet.getString("last_name"));
				studentHolder.setDepartmentName(resultSet.getString("departament_name"));
				students.add(new Student(studentHolder));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return students;
	}

	public static void insertStudent () {
		List<Student> students = Student.getStudentList();
		try (PreparedStatement preparedStatement = initializeConnection().prepareStatement(INSERTION_QUERY);) {
			for (int i = 0; i < 5; ++i) {
				preparedStatement.setString(1, students.get(i)
				                                       .getFirstName());
				preparedStatement.setString(2, students.get(i)
				                                       .getLastName());
				preparedStatement.setString(3, students.get(i)
				                                       .getDepartmentName());
				preparedStatement.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void updateStudents (String first_name, String last_name, String department_name , int id) {
	
		Student stdn = new Student(first_name, last_name, department_name , id);

		try (PreparedStatement preparedStatement = initializeConnection().prepareStatement(UPDATE);) {
			preparedStatement.setString(1, stdn.getFirstName());
			preparedStatement.setString(2, stdn.getLastName());
			preparedStatement.setString(3, stdn.getDepartmentName());
			preparedStatement.setInt(4, stdn.getId());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void deleteStudentAccountViaID (int id) {
		try (PreparedStatement preparedStatement = initializeConnection().prepareStatement(DELETE);) {
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();

			System.out.println("student with id = " + id + " was deleted successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static Connection initializeConnection () {
		if (connection == null) {
			return connection = DatabaseConnector.getConnection();
		} else {
			return connection;
		}
	}
}
