package com.shop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.shop.entity.enums.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "user_table")
public class UserEntity implements UserDetails {

    @Id
    @SequenceGenerator(name = "UserIdSequence", sequenceName = "user_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UserIdSequence")
    @JsonIgnore
    private Integer id;


    @Column
    @JsonIgnore
    private String name;

    @Column
    @JsonIgnore
    private String email;

    @Column
    @JsonProperty
    private String login;

    @Column
    @JsonProperty
    private String password;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    @JsonProperty
    private Role role;

    @OneToMany(mappedBy = "userId")
    @JsonIgnore
    private List<BasketEntity> basketIds;

    public UserEntity(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public UserEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<BasketEntity> getBasketIds() {
        return basketIds;
    }

    public void setBasketIds(List<BasketEntity> basketIds) {
        this.basketIds = basketIds;
    }

    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add((GrantedAuthority) () -> role.toString());
        return authorities;
    }
    @JsonIgnore
    public String getPassword() {
        return password;
    }

    @Override
    @JsonIgnore
    public String getUsername() {
        return login;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isEnabled() {
        return true;
    }

}
