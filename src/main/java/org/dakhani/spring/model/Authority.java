package org.dakhani.spring.model;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Sami Dakhani Created on Feb 12, 2017
 *
 */
@Entity
@Table(name = "AUTHORITY")
public class Authority implements Serializable {

	/**
	 * Attribute for serialVersionUID
	 */
	private static final long serialVersionUID = 5553961883948443207L;

	@Id
	@SequenceGenerator(name = "AUTHORITY_SEQ", sequenceName = "AUTHORITY_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = SEQUENCE, generator = "AUTHORITY_SEQ")
	@Column(name = "AUTHORITY_ID")
	private Long authorityId;

	@Column(name = "AUTHORITY_NAME")
	private String authorityName;

	@ManyToOne
	@JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
	private User user;

	/**
	 * @return the authorityId
	 */
	public Long getAuthorityId() {
		return this.authorityId;
	}

	/**
	 * @return the authorityName
	 */
	public String getAuthorityName() {
		return this.authorityName;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return this.user;
	}

	/**
	 * @param authorityId
	 *            the authorityId to set
	 */
	public void setAuthorityId(final Long authorityId) {
		this.authorityId = authorityId;
	}

	/**
	 * @param authorityName
	 *            the authorityName to set
	 */
	public void setAuthorityName(final String authorityName) {
		this.authorityName = authorityName;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(final User user) {
		this.user = user;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.authorityName;
	}

}
