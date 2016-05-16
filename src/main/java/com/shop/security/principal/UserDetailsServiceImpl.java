package com.shop.security.principal;

import com.shop.entity.UserEntity;
import com.shop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    private final AccountStatusUserDetailsChecker detailsChecker =
            new AccountStatusUserDetailsChecker();

    @Override
    public final UserEntity loadUserByUsername(String login) throws UsernameNotFoundException {
        UserEntity user = userRepository.findOneByLogin(login);
        if (user == null) {
            throw new UsernameNotFoundException("user not found");
        }
        detailsChecker.check(user);
        return user;
    }

}
