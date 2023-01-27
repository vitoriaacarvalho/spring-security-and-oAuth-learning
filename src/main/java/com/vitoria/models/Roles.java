package com.vitoria.models;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

import com.vitoria.enums.RoleName;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="roles_table")
@Getter
@Setter 
@AllArgsConstructor
@NoArgsConstructor
public class Roles implements GrantedAuthority, Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private UUID id;
	@Enumerated(EnumType.STRING)
	@Column(nullable=false, unique=true)
	private RoleName name;
	
	@Override
	public String getAuthority() {
		return this.name.toString();
	}
	

}
