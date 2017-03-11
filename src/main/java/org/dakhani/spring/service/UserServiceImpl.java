package org.dakhani.spring.service;

import static org.springframework.transaction.annotation.Propagation.REQUIRED;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.dakhani.spring.dao.UserDao;
import org.dakhani.spring.model.Authority;
import org.dakhani.spring.model.User;
import org.dakhani.spring.vo.AuthorityVO;
import org.dakhani.spring.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Sami Dakhani Created on Feb 15, 2017
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao dao;

	/**
	 * @see org.dakhani.spring.service.UserService#createUser(org.dakhani.spring.model.User)
	 */
	@Override
	@Transactional(propagation = REQUIRED, readOnly = false, rollbackFor = Exception.class)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void createUser(final User user) {

		try {
			this.dao.createUser(user);
		} catch (DataAccessException e) {
			throw e;
		}

	}

	@Override
	@Transactional(propagation = REQUIRED, readOnly = true, rollbackFor = Exception.class)
	public UserVO retrieveUser(final String username) {

		UserVO userVO = null;

		User user = null;

		try {
			user = this.dao.findByUsername(username);
		} catch (DataAccessException e) {
			throw e;
		}

		if (user != null) {
			userVO = new UserVO();
			userVO.setUsername(user.getUsername());
			userVO.setPassword(user.getPassword());

			Set<Authority> authorites = user.getAuthorities();
			Iterator<Authority> iterator = authorites.iterator();
			List<AuthorityVO> authoritesVOs = new ArrayList<>();

			while (iterator.hasNext()) {

				Authority authority = iterator.next();
				AuthorityVO authoritesVO = new AuthorityVO();

				authoritesVO.setAuthorityName(authority.getAuthorityName());
				authoritesVOs.add(authoritesVO);

			}

			userVO.setAuthorities(authoritesVOs);

		}

		return userVO;
	}

	/**
	 * Method level access control
	 * 
	 * @see org.dakhani.spring.service.UserService#retrieveUsers()
	 */
	@Override
	@Transactional(propagation = REQUIRED, readOnly = true, rollbackFor = Exception.class)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	// @Secured({ "ROLE_ADMIN" })
	public List<UserVO> retrieveUsers() {

		List<UserVO> users = new ArrayList<>();

		UserVO user1 = new UserVO();
		user1.setUsername("samidakhani");
		user1.setFirstname("Sami");
		user1.setLastname("Dakhani");
		user1.setAge(new Long(26));
		users.add(user1);

		UserVO user2 = new UserVO();
		user2.setUsername("surajkadam");
		user2.setFirstname("Suraj");
		user2.setLastname("Kadam");
		user2.setAge(new Long(27));
		users.add(user2);

		return users;

	}

	/**
	 * Method level access control -- special case for access, only accepting
	 * logged in user parameter.
	 * 
	 * @see org.dakhani.spring.service.UserService#retriveById(java.lang.Long)
	 */
	@Override
	@Transactional(propagation = REQUIRED, readOnly = true, rollbackFor = Exception.class)
	@PreAuthorize("authentication.name==#username")
	public UserVO retriveById(final String username) {

		UserVO user = new UserVO();
		user.setUsername("samidakhani");
		user.setFirstname("Sami");
		user.setLastname("Dakhani");
		user.setAge(new Long(26));
		return user;
	}
}
