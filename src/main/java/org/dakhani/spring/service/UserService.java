package org.dakhani.spring.service;

import java.util.List;

import org.dakhani.spring.model.User;
import org.dakhani.spring.vo.UserVO;

/**
 * @author Sami Dakhani Created on Feb 15, 2017
 *
 */

public interface UserService {

	/**
	 * Creates a user
	 * 
	 * @param user
	 */
	void createUser(User user);

	/**
	 * Retrives a user by username
	 * 
	 * @param username
	 * @return
	 */
	UserVO retrieveUser(final String username);

	/**
	 * Retrieve users.
	 * 
	 * @return
	 */
	List<UserVO> retrieveUsers();

	/**
	 * Retrives a user by id.
	 * 
	 * @param userId
	 * @return
	 */
	UserVO retriveById(String username);
}
