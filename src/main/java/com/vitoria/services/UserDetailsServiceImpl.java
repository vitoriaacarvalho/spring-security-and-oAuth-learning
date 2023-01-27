package com.vitoria.services;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;
import com.vitoria.models.Users;
import com.vitoria.repositories.UserRepository;

@Service
@Transactional
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
		return new User(user.getUsername(),user.getPassword(), true, true, true,true, user.getAuthorities());
	}

	/*private void checkGrantAuthorities(Users user, List<GrantedAuthority> listGrantAuthority) {
		if(user!=null && user.getAuthorities()!=null && user.getAuthorities().isEmpty()==false)
				for(Roles roleUser : user.getAuthorities()){
					final String PREFIX = "ROLE_";
					String role = PREFIX + roleUser.getRoleDescription();
					listGrantAuthority.add(new GrantedAuthorityImpl(role));	
		
				}
		
	*/	
}
