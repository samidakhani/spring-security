package org.dakhani.spring.vo;

import java.io.Serializable;

/**
 * @author Sami Dakhani Created on Feb 19, 2017
 *
 */
public class AuthorityVO implements Serializable {

	/**
	 * Attribute for serialVersionUID
	 */
	private static final long serialVersionUID = -5011946296563089298L;

	private String authorityName;

	/**
	 * @return the authorityName
	 */
	public String getAuthorityName() {
		return this.authorityName;
	}

	/**
	 * @param authorityName
	 *            the authorityName to set
	 */
	public void setAuthorityName(final String authorityName) {
		this.authorityName = authorityName;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.authorityName;
	}

}
