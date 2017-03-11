package org.dakhani.spring.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.dakhani.spring.service.UserService;
import org.dakhani.spring.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Sami Dakhani Created on Mar 5, 2017
 *
 */
@Component
@ManagedBean(name = "userProfileManagedBean")
@ViewScoped
public class UserProfileManagedBean {

	@Autowired
	private UserService service;

	private UserVO user;

	private List<UserVO> users;

	/**
	 * @return the user
	 */
	public UserVO getUser() {
		return this.user;
	}

	/**
	 * @return the users
	 */
	public List<UserVO> getUsers() {
		return this.users;
	}

	/**
	 * Retrieve a list of users.
	 */
	public void retrieveUsers() {

		this.users = this.service.retrieveUsers();
	}

	/**
	 * Retrieve a user.
	 */
	public void retriveUser() {

		this.user = this.service.retriveById("sami");
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(final UserVO user) {
		this.user = user;
	}

	/**
	 * @param users
	 *            the users to set
	 */
	public void setUsers(final List<UserVO> users) {
		this.users = users;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserProfileManagedBean [service=" + this.service + ", users="
				+ this.users + "]";
	}

}
