package com.shop.security.principal;

import com.shop.entity.UserEntity;
import com.shop.entity.enums.Role;
import org.springframework.security.core.GrantedAuthority;

public class UserAuthority implements GrantedAuthority {

    private UserEntity user;

    private Role authority;

    public UserAuthority() {
    }

    public UserAuthority(UserEntity user, Role authority) {
        this.user = user;
        this.authority = authority;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    @Override
    public String getAuthority() {
        return authority.toString();
    }

    public void setAuthority(Role authority) {
        this.authority = authority;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof UserAuthority))
            return false;

        UserAuthority ua = (UserAuthority) obj;
        return ua.getAuthority() == this.getAuthority() || ua.getAuthority().equals(this.getAuthority());
    }

    @Override
    public int hashCode() {
        return getAuthority() == null ? 0 : getAuthority().hashCode();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ": " + getAuthority();
    }

}
