package com.shop.security.filter;

import com.shop.entity.UserEntity;
import com.shop.security.principal.UserAuthentication;
import com.shop.security.principal.UserDetailsServiceImpl;
import com.shop.security.token.TokenAuthenticationService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class AuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    private final TokenAuthenticationService tokenAuthenticationService;
    private final UserDetailsServiceImpl userDetailsService;

    public AuthenticationFilter(String urlMapping, TokenAuthenticationService tokenAuthenticationService,
                                   UserDetailsServiceImpl userDetailsService, AuthenticationManager authManager) {
        super(new AntPathRequestMatcher(urlMapping));
        this.userDetailsService = userDetailsService;
        this.tokenAuthenticationService = tokenAuthenticationService;
        setAuthenticationManager(authManager);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException, IOException, ServletException {
        UserEntity user = new UserEntity(request.getParameter("username"), request.getParameter("password"));
        final UsernamePasswordAuthenticationToken loginToken = new UsernamePasswordAuthenticationToken(
                user.getLogin(), user.getPassword());
        return getAuthenticationManager().authenticate(loginToken);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                            FilterChain chain, Authentication authentication)
            throws IOException, ServletException {
        final UserEntity authenticatedUser = userDetailsService.loadUserByUsername(authentication.getName());
        final UserAuthentication userAuthentication = new UserAuthentication(authenticatedUser);
        tokenAuthenticationService.addAuthentication(response, userAuthentication);
        SecurityContextHolder.getContext().setAuthentication(userAuthentication);
        chain.doFilter(request, response);
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                              AuthenticationException failed) throws IOException, ServletException {
        response.sendRedirect("/login?error=true");
    }

}
