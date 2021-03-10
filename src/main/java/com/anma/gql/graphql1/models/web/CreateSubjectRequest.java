package com.anma.gql.graphql1.models.web;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateSubjectRequest {

	private String subjectName;
	
	private Double marksObtained;
}
