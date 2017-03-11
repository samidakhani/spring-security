package org.dakhani.spring.model;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Sami Dakhani Created on Feb 12, 2017
 *
 */
@Entity
@Table(name = "SUSER")
@NamedQueries({
		@NamedQuery(name = "User.findByUsername", query = "Select u from User u Where u.username =:username") })
public class User implements Serializable {

	/**
	 * Attribute for serialVersionUID
	 */
	private static final long serialVersionUID = -6274999982991322977L;

	@OneToMany(mappedBy = "user", targetEntity = Authority.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Authority> authorities;

	@Column(name = "SPASSWORD")
	private String password;

	@Id
	@SequenceGenerator(name = "USER_SEQ", sequenceName = "USER_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = SEQUENCE, generator = "USER_SEQ")
	@Column(name = "USER_ID")
	private Long userId;

	@Column(name = "USERNAME")
	private String username;

	/**
	 * @return the authorities
	 */
	public Set<Authority> getAuthorities() {
		return this.authorities;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return this.userId;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return this.username;
	}

	/**
	 * @param authorities
	 *            the authorities to set
	 */
	public void setAuthorities(final Set<Authority> authorities) {
		this.authorities = authorities;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(final String password) {
		this.password = password;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(final Long userId) {
		this.userId = userId;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(final String username) {
		this.username = username;
	}

}
