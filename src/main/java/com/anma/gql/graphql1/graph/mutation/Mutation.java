package com.anma.gql.graphql1.graph.mutation;

import com.anma.gql.graphql1.models.web.StudentRequest;
import com.anma.gql.graphql1.models.web.StudentResponse;
import com.anma.gql.graphql1.service.StudentService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Mutation implements GraphQLMutationResolver {

    @Autowired
    private StudentService studentService;

    public StudentResponse createStudent(StudentRequest request) {

        return new StudentResponse(studentService.createStudent(request));
    }
}
