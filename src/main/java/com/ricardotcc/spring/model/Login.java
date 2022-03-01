package com.ricardotcc.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Login 
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nomelogin;
    private String senhalogin;
    private int permit;

    public Login()
    {

    }

    public Login(Long id, String nome_login, String senha_login, int permit)
    {
        this.id = id;
        this.nomelogin = nome_login;
        this.senhalogin = senha_login;
        this.permit = permit;
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
        // TODO Auto-generated method stub
        return getNomelogin() + " - " + getSenhalogin();
    }
}
