package com.vitoria.models;

import java.io.Serializable;
import java.util.Collection;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="users_table")
public class Users implements UserDetails, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private UUID id;
	@Column(unique=true, nullable=false)
	private String username;
	@Column(nullable=false)
	private String password;
	
	
	/*
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	
	}
	*/

	@Override
	public String getPassword() {
		return this.password;
		
	}
	

	@Override
	public String getUsername() {
		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
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


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	public Users(UUID id, String username, String password) {
		this.id = id;
		this.username = username;
		this.password = password;
	}

	public Users(){
		
	}
	
	
	public UUID getId() {
		return id;
	}


	public void setId(UUID id) {
		this.id = id;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public void setPassword(String password) {
		this.password = password;
	}




}
