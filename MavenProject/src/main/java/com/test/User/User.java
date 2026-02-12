package com.test.User;

public class User {
	int userId;
	String full_name;
	String email;
	String password;
	String phone;
	enum Role{
		ADMIN,CUSTOMER;
	}
	Role role;
	boolean isactive;
	String created_at;
	
	

	public User(int userId, String full_name, String email, String password, String phone, Role role, boolean isactive,
			String created_at) {
		this.userId = userId;
		this.full_name = full_name;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.role = role;
		this.isactive = isactive;
		this.created_at = created_at;
	}


	public String getDetails()
	{
		return "User[id="+userId+
				", name="+full_name+
				", email="+email+
				", password="+password+
				", phone="+phone+
				", Role="+role+
				", Active="+isactive+
				", Created At="+created_at+"]";
	}
	}
