package com.ricardotcc.spring.model;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table
public class Login implements UserDetails
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nomelogin;
    private String senhalogin;     
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> roles = new ArrayList<>();

    public Login(String nome_login, String senha_login, Collection<? extends GrantedAuthority> collection)
    {
        this.nomelogin = nome_login;
        this.senhalogin = senha_login;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    public Login(Long id, String nome_login, String senha_login, int permit)
    {
        this.id = id;
        this.nomelogin = nome_login;
        this.senhalogin = senha_login;
    }

    public Login(){
        
    }    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSenhalogin() {
        return senhalogin;
    }

    public void setSenhalogin(String senhalogin) {
        this.senhalogin = senhalogin;
    }

    public String getNomelogin() {
        return nomelogin;
    }

    public void setNomelogin(String nome_login) {
        this.nomelogin = nome_login;
    }
    @Override
    public String toString() {
        
        return getNomelogin() + " - " + getSenhalogin();
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.senhalogin;
    }

    @Override
    public String getUsername() {
        return nomelogin;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
