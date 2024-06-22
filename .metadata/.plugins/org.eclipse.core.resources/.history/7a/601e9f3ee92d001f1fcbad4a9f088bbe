package in.psk.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import in.psk.entity.Users;
import in.psk.repo.UsersRepository;
import in.psk.utils.FileUtils;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UsersRepository userRepo;
	@Autowired
	private PasswordEncoder pwdEncoder;
	@Autowired
	private AuthenticationManager authManager;

	@Override
	public Users addUser(Users user, MultipartFile file) throws Exception {
		Users u=userRepo.findByEmail(user.getEmail());
		if(u==null) {
		String fileName=FileUtils.saveFile(file.getName(), file);
		String encpodedPwd=pwdEncoder.encode(user.getPwd());
		user.setPwd(encpodedPwd);
		user.setUserPic(fileName);
		Users savedUser=userRepo.save(user);
		return savedUser;}
		else {
			return u;
		}
		
	}

	@Override
	public Users login(Users user) {
		UsernamePasswordAuthenticationToken token=new
				UsernamePasswordAuthenticationToken(user.getEmail(),user.getPwd());
		Authentication authenticate=authManager.authenticate(token);
		if(authenticate.isAuthenticated()) {
			return userRepo.findByEmail(user.getEmail());
		}else {
			throw new AuthenticationCredentialsNotFoundException("Invalid Credintials");
		}
		
	}

	@Override
	public Users getUserById(Integer userId) {
		
		return userRepo.findById(userId).orElseThrow();
	}

	@Override
	public List<Users> getAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public Users deleteUserById(Integer userId) {
	Users user=userRepo.findById(userId).orElseThrow();
	if(user!=null) {
		userRepo.deleteById(userId);
		return user;
	}else {
		return null;
	}
	}

}
