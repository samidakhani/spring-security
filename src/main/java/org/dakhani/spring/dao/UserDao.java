package org.dakhani.spring.dao;

import org.dakhani.spring.model.User;

/**
 * @author Sami Dakhani Created on Feb 12, 2017
 *
 */
public interface UserDao {

	void createUser(User user);

	User findByUsername(String username);
}
