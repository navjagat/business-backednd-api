/**
 * 
 */
package com.interview.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Replica of the User Table in Database
 * 
 * @author navneet.prabhakar
 *
 */

@Entity
@Table
public class User implements Serializable {

	private static final long serialVersionUID = -7231737094370211919L;

	@Id
	private String userId;

	private String pass;

	private String firstName;

	private String lastName;

	private String avatar;

	@ManyToMany(targetEntity = Role.class)
	private List<Role> roles;

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the roles
	 */
	public List<Role> getRoles() {
		return roles;
	}

	/**
	 * @param roles
	 *            the roles to set
	 */
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	/**
	 * @return the password
	 */
	@JsonIgnore
	public String getPass() {
		return pass;
	}

	/**
	 * @param pass
	 *            the password to set
	 */
	public void setPass(String pass) {
		this.pass = pass;
	}

	public User() {

	}

	public User(User user) {
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.userId = user.getUserId();
		this.roles = user.getRoles();
		this.pass = user.getPass();
	}

	/**
	 * @param userId
	 * @param pass
	 * @param firstName
	 * @param lastName
	 * @param avatar
	 * @param roles
	 */
	public User(String userId, String pass, String firstName, String lastName,
			String avatar) {
		super();
		this.userId = userId;
		this.pass = pass;
		this.firstName = firstName;
		this.lastName = lastName;
		this.avatar = avatar;
	}

	/**
	 * @return the avatar
	 */
	public String getAvatar() {
		return avatar;
	}

	/**
	 * @param avatar
	 *            the avatar to set
	 */
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

}
