package com.org.spring.springrest2.model;

import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.Table;
	import javax.validation.constraints.Email;
	import javax.validation.constraints.NotBlank;
	import javax.validation.constraints.Size;
	
	@Entity
	@Table(name = "customer")
	public class Customer {
	
		private long id;
	
		@NotBlank(message = "Name cannot be blank")
		@Size(min = 4, message = "Name must have atleast 4 characters")
		private String name;
		
		
		@Email
		@NotBlank(message="Email cannot be blank")
		private String email;
		
		@NotBlank(message = "Mobile number cannot be blank")
		@Size(min = 10, message = "Mobile number should have atleast 10 characters")
		private String mobilenumber;
	
		public Customer() {
	
		}
	
		public Customer(String name,String email,String mobilenumber) {
			this.name = name;
			
			this.email= email;
			this.mobilenumber = mobilenumber;
		}
	
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		public long getId() {
			return id;
		}
	
		public void setId(long id) {
			this.id = id;
		}
		@Column(name = "name", nullable = false)
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		@Column(name = "email_address", nullable = false)
		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}
		@Column(name = "mobile_number", nullable = false)
		public String getMobilenumber() {
			return mobilenumber;
		}

		public void setMobilenumber(String mobilenumber) {
			this.mobilenumber = mobilenumber;
		}
	
	
	}