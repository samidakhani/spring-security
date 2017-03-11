package org.dakhani.spring.bean;

import java.util.HashSet;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.dakhani.spring.model.Authority;
import org.dakhani.spring.model.User;
import org.dakhani.spring.service.UserService;
import org.dakhani.spring.vo.UserVO;

/**
 * @author Sami Dakhani Created on Feb 16, 2017 <br />
 *         A registrationBean used with JPA configuration <br />
 *         NOTE: Mainain the bean name as the class name. Issue may occur, such
 *         as injection of autowire classes fails.
 */
// @Component
@ManagedBean(name = "jpaRegistrationManagedBean")
@ViewScoped
public class JpaRegistrationManagedBean {

	// @Autowired
	private UserService service;

	UserVO user;

	/**
	 * @return the user
	 */
	public UserVO getUser() {

		if (this.user == null) {
			this.user = new UserVO();
		}

		return this.user;
	}

	/**
	 * Registers a user
	 */
	public void registerUser() {

		User user = new User();
		user.setUsername(this.user.getUsername());
		user.setPassword(this.user.getPassword());

		Set<Authority> authorities = new HashSet<>();
		Authority authority = new Authority();
		authority.setAuthorityName("ROLE_USER");
		authority.setUser(user);
		authorities.add(authority);

		user.setAuthorities(authorities);

		this.service.createUser(user);

	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(final UserVO user) {
		this.user = user;
	}
}
