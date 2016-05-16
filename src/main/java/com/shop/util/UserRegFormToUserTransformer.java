package com.shop.util;


import com.shop.entity.UserEntity;
import com.shop.entity.enums.Role;
import com.shop.form.RegistrationForm;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Objects;

public class UserRegFormToUserTransformer {

    static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public static UserEntity transform(RegistrationForm form) {
        if (form == null || (!Objects.equals(form.getPassword(), form.getRepassword()))) {
            return null;
        }
        UserEntity user = new UserEntity();
        user.setName(form.getName());
        user.setEmail(form.getEmail());
        user.setLogin(form.getLogin());
        user.setPassword(encoder.encode(form.getPassword()));
        user.setRole(Role.ROLE_USER);
        return user;
    }
}
