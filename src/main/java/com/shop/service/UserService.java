package com.shop.service;

import com.shop.entity.UserEntity;
import com.shop.form.RegistrationForm;
import org.springframework.validation.BindingResult;

public interface UserService extends EntityService{

    UserEntity getUserEntity(String login);

    void validLogin(BindingResult result, RegistrationForm form);

}
