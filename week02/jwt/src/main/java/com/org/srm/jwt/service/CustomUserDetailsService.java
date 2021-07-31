package com.org.srm.jwt.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import com.org.srm.jwt.model.DAOUser;
import com.org.srm.jwt.model.Role;
import com.org.srm.jwt.model.UserDTO;
import com.org.srm.jwt.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userDao;

	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<SimpleGrantedAuthority> roles = null;
		
			
		DAOUser user = userDao.findByUsername(username);
		if (user != null) {
			roles = new ArrayList<>();
			for(int i=0;i<user.getRoles().toArray().length;i++){
				roles.add(new SimpleGrantedAuthority(user.getRoles().get(i).getRoleName()));
			}
			return new User(user.getUsername(), user.getPassword(), roles);
		}
		throw new UsernameNotFoundException("User not found with the name " + username);	}
	
	public DAOUser save(UserDTO user) {
		DAOUser newUser = new DAOUser();
		newUser.setUsername(user.getUsername());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		
		List<Role> roles = new ArrayList<>();
		for(int i=0;i<user.getRole().length;i++){
			Role role = new Role();
			role.setRoleName(user.getRole()[i]);
			roles.add(role);
		}
		
		newUser.setRoles(roles);
		return userDao.save(newUser);
	}
}
