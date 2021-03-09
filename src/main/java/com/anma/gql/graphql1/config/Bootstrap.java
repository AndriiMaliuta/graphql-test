package com.anma.gql.graphql1.config;

import com.anma.gql.graphql1.models.Address;
import com.anma.gql.graphql1.models.Student;
import com.anma.gql.graphql1.models.Subject;
import com.anma.gql.graphql1.repo.AddressRepository;
import com.anma.gql.graphql1.repo.StudentRepository;
import com.anma.gql.graphql1.repo.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class Bootstrap implements CommandLineRunner {

    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    public void run(String... args) throws Exception {
        loadData();
    }

    private void loadData() {

        Address address = new Address();
        address.setId(1L);
        address.setCity("Vancouver");
        address.setStreet("Street 1");
        addressRepository.save(address);

        Subject subject = new Subject();
        subject.setId(1L);
        subject.setSubjectName("History");
        subject.setMarksObtained(4.2);
        subjectRepository.save(subject);

        Student student1 = new Student();
        student1.setId(1L);
        student1.setEmail("student1@mail.com");
        student1.setAddress(addressRepository.getOne(address.getId()));
        student1.setFirstName("Petro");
        student1.setLastName("Petrenko");
        student1.setLearningSubjects(Arrays.asList(subjectRepository.getOne(1L)));
        studentRepository.save(student1);
    }
}
