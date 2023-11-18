package edu.dandaev_it.jdbc.jdbc_educational_project.app;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.dandaev_it.jdbc.jdbc_educational_project.model.Student;
import edu.dandaev_it.jdbc.jdbc_educational_project.utils.CRUDOperationsProvider;

public class App {

	public static void main (String [] args) {
		List<Student> students = CRUDOperationsProvider.selectAllStudents ();

		for (Student student : students) {
			System.out.println (student.toString ());
		}

		List<Student> students_1 = Student.getStudentList ();
		for (Student student : students_1) {
			System.out.println (student);
		}

	}

}
