package com.gpi.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Document(collection = "students") //
public class Student {

	@Id
	private String studentid;
	private String name;
	private int rollno;
	private double latitude;
	private double longitude;
	private boolean present;

}
