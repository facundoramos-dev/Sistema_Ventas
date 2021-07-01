package ar.edu.unju.fi.tpfinal;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class ManejadorAUTH implements AuthenticationSuccessHandler {
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		// TODO Auto-generated method stub
		boolean userEmployee = false;
		boolean userAdmin = false;		

		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

		for (GrantedAuthority grantedAuthority : authorities) {
			if (grantedAuthority.getAuthority().equals("EMPLEADO")) {
				userEmployee = true;
				break;
			} else {
				if (grantedAuthority.getAuthority().equals("ADMINISTRADOR")) {
					userAdmin = true;
					break;
				} 
			}
		}

		if (userEmployee) {
			redirectStrategy.sendRedirect(request, response, "/customer/nuevo");
		} else {
			if (userAdmin) {
				redirectStrategy.sendRedirect(request, response, "/office/nuevo");
			} else {
					throw new IllegalStateException();
				}
			
		}	
    }
}
