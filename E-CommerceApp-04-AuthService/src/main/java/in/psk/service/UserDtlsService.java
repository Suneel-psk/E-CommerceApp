package in.psk.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import in.psk.entity.Users;
import in.psk.repo.UsersRepository;

@Service
public class UserDtlsService implements UserDetailsService{

	@Autowired
	private UsersRepository repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users u=repo.findByEmail(username);
		
		return new User(u.getEmail(),u.getPwd(),Collections.emptyList());
	}
}
