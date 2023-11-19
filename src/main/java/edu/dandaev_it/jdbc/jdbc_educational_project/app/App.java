package edu.dandaev_it.jdbc.jdbc_educational_project.app;

import java.util.List;

import edu.dandaev_it.jdbc.jdbc_educational_project.model.Student;
import edu.dandaev_it.jdbc.jdbc_educational_project.utils.CRUDOperationsProvider;

public class App {

	public static void main (String[] args) {
		CRUDOperationsProvider.insertStudent();
		CRUDOperationsProvider.updateStudents("updated_firstName", "updated_LastName", "updated_departamentName", 2);
		CRUDOperationsProvider.deleteStudentAccountViaID(1);

		System.out.println("Retrieving data after insertion");
		List<Student> students = CRUDOperationsProvider.selectAllStudents();

		for (Student student : students) {
			System.out.println(student.toString());
		}
	}

}
