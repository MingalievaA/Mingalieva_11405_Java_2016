package com.shop.security;

import com.shop.security.filter.AuthenticationFilter;
import com.shop.security.filter.AuthorizationFilter;
import com.shop.security.principal.UserDetailsServiceImpl;
import com.shop.security.token.TokenAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@ComponentScan
public class RestAuthSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Autowired
    TokenAuthenticationService tokenAuthenticationService;

    public RestAuthSecurityConfig() {
        super(true);
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .exceptionHandling().accessDeniedPage("/").and()
                .anonymous().and()
                .servletApi().and()
                .headers().cacheControl().and();
        httpSecurity.formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/login/process")
                .usernameParameter("username")
                .passwordParameter("password")
                .defaultSuccessUrl("/");
        httpSecurity.authorizeRequests()
                .antMatchers("/login", "/registration").anonymous()
//                .antMatchers("/").permitAll()
                .antMatchers("/", "/basket").hasRole("USER");
        httpSecurity
                .addFilterBefore(new AuthenticationFilter("/login/process", tokenAuthenticationService,
                        userDetailsService, authenticationManager()), UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(new AuthorizationFilter(tokenAuthenticationService),
                        UsernamePasswordAuthenticationFilter.class);
        httpSecurity.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

}
