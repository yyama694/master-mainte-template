package org.yyama.master.mainte.filter;

import java.io.IOException;

import org.yyama.master.mainte.domain.UserDomain;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter("/*")
public class AuthFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("Filter内の処理です。");
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpSession session = httpRequest.getSession(false);

		String uri = httpRequest.getRequestURI();
		boolean loggedIn = (session != null && session.getAttribute("user") != null);
		boolean loginRequest = uri.equals("/login") || uri.startsWith("/login/auth") || uri.startsWith("/logout");

		if (loggedIn || loginRequest) {
			if (session != null && session.getAttribute("user") != null) {
				System.out.println("セッションが存在します。:" + session.getAttribute("user"));
			}
			if (uri.startsWith("/user") && !isAdmin(session)) {
                httpResponse.sendRedirect("/access-denied");
            } else {
                chain.doFilter(request, response);
            }
		} else {
			System.out.println("セッションがありません。");
			httpResponse.sendRedirect("/login");
		}
	}
	
    private boolean isAdmin(HttpSession session) {
        UserDomain user = (UserDomain) session.getAttribute("user");
        return user != null && user.getAdministrator();
    }

}
