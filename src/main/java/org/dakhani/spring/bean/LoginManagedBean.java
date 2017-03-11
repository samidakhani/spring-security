package org.dakhani.spring.bean;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author Sami Dakhani Created on Feb 12, 2017
 *
 */
@ManagedBean(name = "loginBean")
@RequestScoped
public class LoginManagedBean {

	private static final String LOGOUT = "LOGOUT";

	/**
	 * Authenticates the user
	 * 
	 * @return
	 * @throws IOException
	 * @throws ServletException
	 */
	public void doAuthenticate() {

		try {
			ExternalContext context = FacesContext.getCurrentInstance()
					.getExternalContext();
			RequestDispatcher dispatcher = ((ServletRequest) context
					.getRequest())
							.getRequestDispatcher("/j_spring_security_check");
			dispatcher.forward((ServletRequest) context.getRequest(),
					(ServletResponse) context.getResponse());
			FacesContext.getCurrentInstance().responseComplete();

		} catch (Exception e) {
		}

	}

	/**
	 * Logs out a user
	 * 
	 * @return
	 * @throws IOException
	 */
	public String doLogout() throws IOException {

		return LOGOUT;
	}
}
