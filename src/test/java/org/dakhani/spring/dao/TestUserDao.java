/**
 * Copyright (c) GCOM Software Inc, NY. All Rights Reserved.
 * 
 * THIS INFORMATION IS COMPANY CONFIDENTIAL.
 * 
 * NOTICE: This material is a confidential trade secret and proprietary
 * information of GCOM Software Inc, NY which may not be reproduced, used, sold, or
 * transferred to any third party without the prior written consent of GCOM Software Inc, NY.
 */
package org.dakhani.spring.dao;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.dakhani.spring.model.Authority;
import org.dakhani.spring.model.User;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Sami Dakhani Created on Feb 14, 2017
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/application-context-test.xml" })
public class TestUserDao {

	@Autowired
	private UserDao dao;

	@Test
	@Transactional
	@Rollback(false)
	public void testCreateUser() {

		User user = new User();
		user.setUsername("pankaj");
		user.setPassword("pankaj");

		Set<Authority> authorities = new HashSet<>();
		Authority authority = new Authority();
		authority.setAuthorityName("ROLE_USER");
		authority.setUser(user);
		authorities.add(authority);

		user.setAuthorities(authorities);

		this.dao.createUser(user);

	}

	@Test
	@Ignore
	@Transactional
	@Rollback(false)
	public void testFindByUsername() {

		String username = "sami";
		User user = this.dao.findByUsername(username);

		System.out.println(user.getUserId() + " :" + user.getUsername());

		Set<Authority> authorities = user.getAuthorities();
		Iterator<Authority> iterator = authorities.iterator();

		while (iterator.hasNext()) {
			Authority authority = iterator.next();
			System.out.println(authority.getAuthorityName());
		}

	}

}
