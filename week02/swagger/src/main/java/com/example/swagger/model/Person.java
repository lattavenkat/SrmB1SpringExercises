package com.example.swagger.model;

// Swagger



import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.Table;
	import javax.validation.constraints.Email;
	import javax.validation.constraints.NotBlank;
	import javax.validation.constraints.NotNull;
	import javax.validation.constraints.Size;
	
	@Entity
	@Table(name = "person")
	public class Person {
	
		private long id;
	
		@NotNull(message = "Should not be null")
		@NotBlank(message = "Should not be empty")
		@Size(min = 5, message = " Name must have atleast 5 characters")
		private String fname;
		
		@NotNull(message = "Should not be null")
		@NotBlank(message = "Should not be empty")
		@Size(min = 5, message = "Last Name must have atleast 5 characters")
		private String lname;
		
		@Email
		@NotNull(message = "Should not be null")
		@NotBlank(message = "Should not be empty")
		@Size(min = 5, message = "Email should have atleast 5 characters")
		private String email;
		
		@NotNull(message = "Should not be null")
		@NotBlank(message = "Should not be empty")
		@Size(min = 5, message = "Password should have atleast 5 characters")
		private String password;
	
		public Person() {
	
		}
	
		public Person(String fname, String lname, String email) {
			this.fname = fname;
			this.lname = lname;
			this.email = email;
		}
	
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		public long getId() {
			return id;
		}
	
		public void setId(long id) {
			this.id = id;
		}
	
		@Column(name = "fname", nullable = false)
		public String getFname() {
			return fname;
		}
	
		public void setFname(String fname) {
			this.fname = fname;
		}
	
		@Column(name = "lname", nullable = false)
		public String getLname() {
			return lname;
		}
	
		public void setLname(String lname) {
			this.lname = lname;
		}
	
		@Column(name = "email", nullable = false)
		public String getEmail() {
			return email;
		}
	
		public void setEmail(String email) {
			this.email = email;
		}
	
		@Column(name = "password", nullable = false)
		public String getPassword() {
			return password;
		}
	
		public void setPassword(String password) {
			this.password = password;
		}
	
	}