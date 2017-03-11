package org.dakhani.spring.security;

import java.util.List;

import org.dakhani.spring.service.UserService;
import org.dakhani.spring.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * @author Sami Dakhani Created on Mar 5, 2017 <br />
 *         For security setup --Handling applicationContext events<br />
 *         https://www.tutorialspoint.com/spring/event_handling_in_spring.htm
 * 
 *         NOTE: Transaction is not available in this context.
 */
@Component
public class ContextListener
		implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private UserService service;

	/**
	 * @see org.springframework.context.ApplicationListener#onApplicationEvent(org.springframework.context.ApplicationEvent)
	 */
	@Override
	public void onApplicationEvent(final ContextRefreshedEvent event) {

		System.out.println("a context refreshed event happened");

		SecurityContextHolder.getContext()
				.setAuthentication(new UsernamePasswordAuthenticationToken(
						"sami", "sami", AuthorityUtils
								.createAuthorityList("ROLE_ADMIN")));

		List<UserVO> users = this.service.retrieveUsers();
		System.out.println(users);

		SecurityContextHolder.getContext().setAuthentication(null);

	}

}
