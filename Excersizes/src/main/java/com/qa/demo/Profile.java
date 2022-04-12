package com.qa.demo;

import org.springframework.stereotype.Component;

@Component
public class Profile {
	
	@Size(min = 2, max = 20)
	private String forename;
	
	@Size(min = 2, max = 20)
	private String surname;
	
	@Pattern("^([a-zA-Z0-9_\-\.]+)@([a-zA-Z0-9_\-\.]+)\.([a-zA-Z]{2,5})$")
	private Integer dateOfBirth;
	
	private String gender;
	
	@NotNull
	private String ethnicity;
	
	
	

}
