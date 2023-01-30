package com.vitoria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vitoria.models.RoleModel;

public interface RoleRepository extends JpaRepository<RoleModel, Long> {
	RoleModel findByRoleName(String roleName);
}