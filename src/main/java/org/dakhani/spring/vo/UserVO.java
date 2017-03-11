package org.dakhani.spring.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @author Sami Dakhani Created on Feb 12, 2017
 *
 */
public class UserVO implements Serializable {

	/**
	 * Attribute for serialVersionUID
	 */
	private static final long serialVersionUID = 3156565024285876519L;

	private Long age;

	private List<AuthorityVO> authorities;

	private String firstname;

	private String lastname;

	private String password;

	private String username;

	/**
	 * @return the age
	 */
	public Long getAge() {
		return this.age;
	}

	/**
	 * @return the authorities
	 */
	public List<AuthorityVO> getAuthorities() {
		return this.authorities;
	}

	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return this.firstname;
	}

	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return this.lastname;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return this.username;
	}

	/**
	 * @param age
	 *            the age to set
	 */
	public void setAge(final Long age) {
		this.age = age;
	}

	/**
	 * @param authorities
	 *            the authorities to set
	 */
	public void setAuthorities(final List<AuthorityVO> authorities) {
		this.authorities = authorities;
	}

	/**
	 * @param firstname
	 *            the firstname to set
	 */
	public void setFirstname(final String firstname) {
		this.firstname = firstname;
	}

	/**
	 * @param lastname
	 *            the lastname to set
	 */
	public void setLastname(final String lastname) {
		this.lastname = lastname;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(final String password) {
		this.password = password;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(final String username) {
		this.username = username;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [password=" + this.password + ", username=" + this.username
				+ "]";
	}

}
