package org.dakhani.spring.security;

import java.util.List;

import org.dakhani.spring.service.UserService;
import org.dakhani.spring.vo.UserVO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @author Sami Dakhani Created on Feb 15, 2017
 *
 */
// @Service
public class CustomUserService implements UserDetailsService {

	// @Autowired
	private UserService service;

	/**
	 * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
	 */
	@Override
	public UserDetails loadUserByUsername(final String username)
			throws UsernameNotFoundException {

		UserVO user = this.service.retrieveUser(username);

		List<GrantedAuthority> grantedAuthorities = SecurityUtil
				.convertAuthorities(user.getAuthorities());
		return new org.springframework.security.core.userdetails.User(username,
				user.getPassword(), grantedAuthorities);
	}

}
