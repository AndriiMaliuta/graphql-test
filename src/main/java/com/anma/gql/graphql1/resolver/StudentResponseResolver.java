package com.anma.gql.graphql1.resolver;

import com.anma.gql.graphql1.models.Subject;
import com.anma.gql.graphql1.models.web.StudentResponse;
import com.anma.gql.graphql1.models.web.SubjectResponse;
import com.coxautodev.graphql.tools.GraphQLResolver;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentResponseResolver implements GraphQLResolver<StudentResponse> {

    public List<SubjectResponse> getLearningSubjects(StudentResponse response) {

        List<SubjectResponse> learningSubjects = new ArrayList<>();

        if (response.getStudent().getLearningSubjects() != null) {

            for (Subject subject : response.getStudent().getLearningSubjects()) {
                learningSubjects.add(new SubjectResponse(subject));
            }
        }
        return learningSubjects;
    }


}
