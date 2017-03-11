package org.dakhani.spring.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.dakhani.spring.model.User;
import org.springframework.stereotype.Repository;

/**
 * @author Sami Dakhani Created on Feb 12, 2017
 *
 */
@Repository
public class UserDaoImpl implements UserDao {

	@PersistenceContext
	protected EntityManager em;

	/**
	 * @see org.dakhani.spring.dao.UserDao#createUser(org.dakhani.spring.model.User)
	 */
	@Override
	public void createUser(final User user) {

		this.em.persist(user);

	}

	/**
	 * @see org.dakhani.spring.dao.UserDao#findByUsername(java.lang.String)
	 */
	@Override
	public User findByUsername(final String username) {

		TypedQuery<User> query = this.em.createNamedQuery("User.findByUsername",
				User.class);
		query.setParameter("username", username);

		User user = null;
		try {
			user = query.getSingleResult();

		} catch (Exception e) {

		}
		return user;

	}

}
