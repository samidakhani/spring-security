package org.dakhani.spring.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.dakhani.spring.vo.UserVO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.UserDetailsManager;

/**
 * @author Sami Dakhani Created on Feb 12, 2017 <Br />
 *         A registrationBean used with JDBC configuration <br />
 *         NOTE: Mainain the bean name as the class name. Issue may occur, such
 *         as injection of autowire classes fails.
 */
// @Component
@ManagedBean(name = "jdbcRegistrationManagedBean")
@ViewScoped
public class JdbcRegistrationManagedBean {

	UserVO user;

	// @Autowired
	private UserDetailsManager userDetailsManager;

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
	 * @return the userDetailsManager
	 */
	public UserDetailsManager getUserDetailsManager() {
		return this.userDetailsManager;
	}

	/**
	 * Registers a user
	 */
	public void registerUser() {

		List<GrantedAuthority> authorities = AuthorityUtils
				.createAuthorityList("ROLE_USER");
		this.userDetailsManager.createUser(new User(this.user.getUsername(),
				this.user.getPassword(), authorities));

	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(final UserVO user) {
		this.user = user;
	}

	/**
	 * @param userDetailsManager
	 *            the userDetailsManager to set
	 */
	public void setUserDetailsManager(
			final UserDetailsManager userDetailsManager) {
		this.userDetailsManager = userDetailsManager;
	}
}
