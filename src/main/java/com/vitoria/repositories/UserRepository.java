package com.vitoria.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vitoria.models.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, UUID> {
	
	public Users findByUsername(String username);
	
}
