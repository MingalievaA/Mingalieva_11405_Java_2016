package com.shop.service.impl;

import com.shop.form.RegistrationForm;
import com.shop.service.EntityService;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

public abstract class EntityServiceImpl implements EntityService {

    @Override
    public void validPassword(BindingResult result, RegistrationForm form) {
        if (!form.getRepassword().equals(form.getPassword())) {
            result.addError(new FieldError("userform", "repassword", "Пароли не совпадают"));
        }
    }

}