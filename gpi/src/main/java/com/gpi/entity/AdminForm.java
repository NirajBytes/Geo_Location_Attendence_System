package com.gpi.entity;

import lombok.*;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document(collection = "adminform")
public class AdminForm {

	@Id
	private String adminId; // Assuming admin_id is the unique identifier for the student

	@Field("name") // Optional, used if you want to explicitly specify the field name in MongoDB
	private String name;

	@Field("email")
	private String email;

	@Field("course")
	private String course;

	@Field("section")
	private String section;

	@Field("subject")
	private String subject;

//	@Field("subjectCode")
	@Indexed(unique = true)

	private String subjectCode;

	@Field("radius")
	private double radius; // Assuming radius is a numeric field, change type if needed

	@Field("latitude")
	private double latitude;

	@Field("longitude")
	private double longitude;

}