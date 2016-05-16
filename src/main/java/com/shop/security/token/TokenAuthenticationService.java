package com.shop.security.token;

import com.shop.entity.UserEntity;
import com.shop.security.CookieUtil;
import com.shop.security.principal.UserAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Service
public class TokenAuthenticationService {

    @Autowired
    private TokenHandler tokenHandler;

    private static final String TOKEN = "token";

    public void addAuthentication(HttpServletResponse response, UserAuthentication authentication) {
        final UserEntity user = authentication.getDetails();
        CookieUtil.addCookie(response, TOKEN, tokenHandler.createTokenForUser(user));
    }

    public Authentication getAuthentication(HttpServletRequest request) {
        String token = CookieUtil.getCookieValue(request, TOKEN);
        if (token != null) {
            final UserEntity user = tokenHandler.parseUserFromToken(token);
            if (user != null) {
                return new UserAuthentication(user);
            }
        }
        return null;
    }

}
