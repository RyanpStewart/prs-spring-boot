package com.prs.prsspringboot.business;

import javax.persistence.*;


@Entity
@Table(name = "Users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		private String username;
		private String password;
		private String firstName;
		private String lastName;
		private String phone;
		private String email;
		private boolean reviewer;
		private boolean admin;
		
		public User() {}
		
		public User(int id, String username, String password, String firstName, String lastName, String phone, String email,
				boolean isReviewer, boolean isAdmin) {
			this.id = id;
			this.username = username;
			this.password = password;
			this.firstName = firstName;
			this.lastName = lastName;
			this.phone = phone;
			this.email = email;
			this.reviewer = isReviewer;
			this.admin = isAdmin;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public boolean isReviewer() {
			return reviewer;
		}

		public void setReviewer(boolean reviewer) {
			this.reviewer = reviewer;
		}

		public boolean isAdmin() {
			return admin;
		}

		public void setAdmin(boolean admin) {
			this.admin = admin;
		}

		@Override
		public String toString() {
			return "User [id=" + id + ", username=" + username + ", password=" + password + ", firstName=" + firstName
					+ ", lastName=" + lastName + ", phone=" + phone + ", email=" + email + ", isReviewer=" + reviewer
					+ ", isAdmin=" + admin + "]";
		}
		

	}


