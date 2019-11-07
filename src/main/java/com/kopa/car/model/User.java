package com.kopa.car.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	
	@Id
    @GeneratedValue (strategy=GenerationType.AUTO)
	@Column(name = "uid")
    private Long uid;
	
	@Column(name = "first_name")
	private String first_name;
	
	@Column(name = "last_name")
	private String last_name;
	
	@Column(name = "email")
	private String email;
	
//	@Column(name = "user_password")
//	private String user_password;
//	
//	@Column(name = "user_type")
//	private String user_type;
//	
//	public User(){
//        super();
//    }
	
//	public User(Long uid, String first_name, String last_name, String email, String user_password, String user_type) {
//		super();
//		this.uid = uid;
//		this.first_name = first_name;
//		this.last_name = last_name;
//		this.email = email;
//		this.user_password = user_password;
//		this.user_type = user_type;
//	}
//
	public Long getId() {
		return uid;
	}

	public void setId(Long uid) {
		this.uid = uid;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
//
//	public String getUser_password() {
//		return user_password;
//	}
//
//	public void setUser_password(String user_password) {
//		this.user_password = user_password;
//	}
//
//	public String getUser_type() {
//		return user_type;
//	}
//
//	public void setUser_type(String user_type) {
//		this.user_type = user_type;
//	}
	
	@Override
    public String toString() {
        return "User [uid=" + uid + ", firstName=" + first_name + 
                ", lastName=" + last_name + ", email=" + email   + "]";
    }
}
