package com.shop.security;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {

    public static final int COOKIE_AGE_DAY = 60 * 60 * 24;
    public static final String DEFAULT_PATH = "/";

    private static Cookie getCookie(HttpServletRequest request, String name) {
        final Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(name)) {
                    return cookie;
                }
            }
        }
        return null;
    }

    private static void updateCookie(HttpServletResponse response, Cookie cookie) {
        response.addCookie(cookie);
    }

    public static String getCookieValue(HttpServletRequest request, String name) {
        Cookie cookie = getCookie(request, name);
        return cookie != null ? cookie.getValue() : null;
    }

    public static void addCookie(HttpServletResponse response, String name, String value) {
        final Cookie cookie = new Cookie(name, value);
        cookie.setPath(DEFAULT_PATH);
        cookie.setMaxAge(COOKIE_AGE_DAY);
        updateCookie(response, cookie);
    }

    public static void deleteCookie(HttpServletRequest request, HttpServletResponse response, String name) {
        Cookie cookie = getCookie(request, name);
        if (cookie != null) {
            cookie.setMaxAge(0);
            cookie.setPath(DEFAULT_PATH);
            updateCookie(response, cookie);
        }
    }

}
