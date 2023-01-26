package com.vitoria.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.vitoria.models.Users;
import com.vitoria.repositories.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	final UserRepository repo;
	
	public UserDetailsServiceImpl(UserRepository repo) {
		this.repo=repo;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user=repo.findByUsername(username);
		if(user==null) {
			throw new UsernameNotFoundException("user not found with username: "+username);
		}
		return user;
	}

}
