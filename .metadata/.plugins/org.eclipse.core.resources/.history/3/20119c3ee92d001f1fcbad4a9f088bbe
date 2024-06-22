package in.psk.service;

import java.util.List;

import org.springframework.security.core.userdetails.User;
import org.springframework.web.multipart.MultipartFile;

import in.psk.entity.Users;

public interface UserService {

	// Add
	public Users addUser(Users user, MultipartFile file) throws Exception;
    //Login
	public Users login(Users user);
    //Get USer By Id
	public Users getUserById(Integer userId);
    //Get All Users
	public List<Users> getAllUsers();
    //Delete User By Id
	public Users deleteUserById(Integer userId);
}
