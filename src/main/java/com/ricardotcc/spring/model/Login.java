package com.ricardotcc.spring.model;

import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
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
    private int permit;

	@ManyToMany
	// @JoinTable( 
    //     name = "usuarios_roles", 
    //     joinColumns = JoinColumns(
    //         name = "usuario_id", referencedColumnName = "login"), 
    //     inverseJoinColumns = JoinColumns(
    //         name = "role_id", referencedColumnName = "nomeRole")
    // ) 
    private List<Role> roles;

    public Login(String nome_login, String senha_login, Collection<? extends GrantedAuthority> collection)
    {
        this.nomelogin = nome_login;
        this.senhalogin = senha_login;
        this.permit = collection.size();
    }

    public Login(Long id, String nome_login, String senha_login, int permit)
    {
        this.id = id;
        this.nomelogin = nome_login;
        this.senhalogin = senha_login;
        this.permit = permit;
    }

    public Login(){
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPermit() {
        return permit;
    }

    public void setPermit(int permit) {
        this.permit = permit;
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
        // TODO Auto-generated method stub
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
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return true;
    }
}
