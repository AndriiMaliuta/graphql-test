package com.anma.gql.graphql1.graph;

import com.anma.gql.graphql1.models.web.MyRequest;
import com.anma.gql.graphql1.models.web.StudentResponse;
import com.anma.gql.graphql1.service.StudentService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Query implements GraphQLQueryResolver {

    @Autowired
    private StudentService studentService;

    public String firstQuery() {
        return "First query from Spring!";
    }

    public String fullName(MyRequest request) {
        return request.getFirstName() + " " + request.getLastName();
    }

    public StudentResponse student(long id) {
        return new StudentResponse(studentService.getStudentById(id));
    }
}
