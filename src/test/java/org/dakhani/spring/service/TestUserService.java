/**
 * Copyright (c) GCOM Software Inc, NY. All Rights Reserved.
 * 
 * THIS INFORMATION IS COMPANY CONFIDENTIAL.
 * 
 * NOTICE: This material is a confidential trade secret and proprietary
 * information of GCOM Software Inc, NY which may not be reproduced, used, sold, or
 * transferred to any third party without the prior written consent of GCOM Software Inc, NY.
 */
package org.dakhani.spring.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.dakhani.spring.vo.UserVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Sami Dakhani Created on Mar 5, 2017
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/application-context-test.xml" })
public class TestUserService {

	@Autowired
	private UserService service;

	@Test
	@Rollback(true)
	public void testRetrieveUser() {

		List<UserVO> users = this.service.retrieveUsers();
		assertEquals(users.size(), 2);

	}

}
