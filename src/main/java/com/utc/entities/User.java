package com.utc.entities;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
public class User {

	@Id
	private ObjectId _id;

	private String email;

	private String password;

	private User() {
	}

	public String get_id() {
		return _id.toString();
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static class Builder {

		private String email;

		private String password;

		public Builder withEmail(String email){
			this.email = email;
			return this;
		}

		public Builder withPassword(String password){
			this.password = password;
			return this;
		}

		public User build(){
			User user = new User();
			user.setEmail(this.email);
			user.setPassword(this.password);
			return user;
		}

	}

}
