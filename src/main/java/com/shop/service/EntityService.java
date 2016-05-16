package com.shop.service;

import com.shop.form.RegistrationForm;
import org.springframework.validation.BindingResult;

public interface EntityService {

    void saveNewUser(RegistrationForm form);

    void validPassword(BindingResult result, RegistrationForm form);

}
