package com.anma.gql.graphql1.service;

import com.anma.gql.graphql1.models.Student;
import com.anma.gql.graphql1.models.web.StudentRequest;
import com.anma.gql.graphql1.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	public Student getStudentById (long id) {
		return studentRepository.findById(id).get();
	}

	public Student createStudent(StudentRequest request) {
		Student student = Student.builder()
				.firstName("Vasyl")
				.lastName("Vasylenko")
				.email("vasul@mail.com")
				.build();
		return studentRepository.save(student);
	}
}
