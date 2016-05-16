package com.shop.form;

import com.shop.entity.enums.Role;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class RegistrationForm {

    @NotEmpty(message = "Поле не может быть пустым")
    @Size(min = 2, max = 30, message = "Максимальная длина 30 символов")
    private String name;

    @NotEmpty(message = "Поле не может быть пустым")
    @Email(message = "Невалидный email")
    private String email;

    @Pattern(message = "Поле не может быть пустым, должно содержать латинские символы или цифры", regexp = "^[a-zA-Z0-9_-]{3,16}")
    private String login;

    @Size(min = 6, max = 24, message = "Пароль неверной длины")
    private String password;

    @Size(min = 6, max = 24, message = "Пароль неверной длины")
    private String repassword;

    @Enumerated(EnumType.STRING)
    private Role role;

    private String experience;

    public String getRepassword() {
        return repassword;
    }

    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
