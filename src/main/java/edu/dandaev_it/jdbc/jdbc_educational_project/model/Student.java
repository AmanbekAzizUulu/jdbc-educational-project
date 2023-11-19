package edu.dandaev_it.jdbc.jdbc_educational_project.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Student {
	private transient int id;
	private String firstName;
	private String lastName;
	private String departmentName;

	public Student () {
		this.firstName = "first_name";
		this.lastName = "last_name";
		this.departmentName = "departament_name";
	}

	public Student (String firstName, String lastName, String departmentName, int id) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.departmentName = departmentName;
	}

	public Student (Student student) {
		this.id = student.id;
		this.firstName = student.firstName;
		this.lastName = student.lastName;
		this.departmentName = student.departmentName;
	}

	public static List<Student> getStudentList () {
		Properties properties = new Properties();
		FileInputStream fis = null;
		Student studentHolder = new Student();
		List<Student> students = new ArrayList<Student>();
		try {
			fis = new FileInputStream("src/main/resources/config.properties");
			properties.load(fis);
			for (int i = 1; i <= 5; ++i) {
				studentHolder.setFirstName(properties.getProperty("student_" + i + ".firstName"));
				studentHolder.setLastName(properties.getProperty("student_" + i + ".lastName"));
				studentHolder.setDepartmentName(properties.getProperty("student_" + i + ".departmentName"));
				students.add(new Student(studentHolder));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return students;
	}

	public int getId () {
		return id;
	}

	public void setId (int id) {
		this.id = id;
	}

	public String getFirstName () {
		return firstName;
	}

	public void setFirstName (String firstName) {
		this.firstName = firstName;
	}

	public String getLastName () {
		return lastName;
	}

	public void setLastName (String lastName) {
		this.lastName = lastName;
	}

	public String getDepartmentName () {
		return departmentName;
	}

	public void setDepartmentName (String departmentName) {
		this.departmentName = departmentName;
	}

	@ Override
	public String toString () {
		return "Student {\n\tid: " + id + "\n\tfirst name: " + firstName + "\n\tlast name: " + lastName
		                + "\n\tdepartament: " + departmentName + "\n}";
	}

}
