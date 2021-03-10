package com.anma.gql.graphql1.resolver;

import java.util.ArrayList;
import java.util.List;

import com.anma.gql.graphql1.graph.SubjectNameFilter;
import com.anma.gql.graphql1.models.Subject;
import com.anma.gql.graphql1.models.web.StudentResponse;
import com.anma.gql.graphql1.models.web.SubjectResponse;
import org.springframework.stereotype.Service;

import com.coxautodev.graphql.tools.GraphQLResolver;


@Service
public class StudentResponseResolver implements GraphQLResolver<StudentResponse> {

	public List<SubjectResponse> getLearningSubjects (StudentResponse studentResponse,
													  SubjectNameFilter subjectNameFilter) {
		
		List<SubjectResponse> learningSubjects = new ArrayList<SubjectResponse>();
		
		if (studentResponse.getStudent().getLearningSubjects() != null) {
			for (Subject subject: studentResponse.getStudent().getLearningSubjects()) {
				if (subjectNameFilter.name().equalsIgnoreCase(subject.getSubjectName())) {
					learningSubjects.add(new SubjectResponse(subject));
				}
			}
		}
		
		return learningSubjects;
		
	}
	
	public String getFullName (StudentResponse studentResponse) {
		return studentResponse.getFirstName() + " " + studentResponse.getLastName();
	}
}
