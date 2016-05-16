package com.shop.service.impl;

import com.shop.entity.UserEntity;
import com.shop.form.RegistrationForm;
import com.shop.repository.UserRepository;
import com.shop.service.UserService;
import com.shop.util.UserRegFormToUserTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

@Service
public class UserServiceImpl extends EntityServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public void saveNewUser(RegistrationForm form) {
        UserEntity userEntity = UserRegFormToUserTransformer.transform(form);
        userRepository.save(userEntity);
    }

    @Override
    public UserEntity getUserEntity(String login) {
        UserEntity findUser = userRepository.findOneByLogin(login);
        if (findUser != null) {
            return findUser;
        }
        return null;
    }

    @Override
    public void validLogin(BindingResult result, RegistrationForm form) {
        if (getUserEntity(form.getLogin()) != null) {
            result.addError(new FieldError("userform", "login", "Логин уже используется"));
        }
    }

}
