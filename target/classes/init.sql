

CREATE TABLE students(
	id INT PRIMARY KEY auto_increment,
	first_name VARCHAR(100) ,
	last_name VARCHAR(100),
	departament_name VARCHAR(100)
);

INSERT 
	INTO students(first_name, last_name, departament_name) 
	VALUES ('Aibek','Dandaev', 'Faculty of Information Technology');