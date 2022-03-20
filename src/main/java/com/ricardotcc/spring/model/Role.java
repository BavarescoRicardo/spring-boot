package com.ricardotcc.spring.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table
public class Role  implements GrantedAuthority{


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "role", nullable = false)
	private String role;

	@ManyToMany(mappedBy = "role")
    private List<Login> usuarios;
	
	public Long getId() {
		return this.id;
	}

	public void setNomeRole(String nomeRole) {
		this.role = nomeRole;
	}
	
	public List<Login> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Login> usuarios) {
		this.usuarios = usuarios;
	}

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return this.id.toString();
	}

	public String getNomeRole() {
		return this.role;
	}
    
}
