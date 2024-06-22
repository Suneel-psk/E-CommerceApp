package in.psk.restcontroller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

import in.psk.constants.AppConstants;
import in.psk.entity.Users;
import in.psk.props.AppProperties;
import in.psk.response.ApiResponse;
import in.psk.service.UserService;

@RestController
public class UserRestController {
	//Here Log Messages are not keep in yml file this are unique 
	private static final Logger log=LoggerFactory.getLogger(UserRestController.class);
	@Autowired
	private UserService userService;
	@Autowired
	private AppProperties props;
	

	@PostMapping("/register")
	public ResponseEntity<ApiResponse<Users>> createUser(@RequestParam("user") String userJson,
			@RequestParam("file") MultipartFile file) throws Exception {
		log.info("User Registeration Process Started");
		ApiResponse<Users> response=new ApiResponse<Users>();
		Map<String, String> messages = props.getMessages();
		ObjectMapper mapper = new ObjectMapper();
		Users user = mapper.readValue(userJson, Users.class);
		Users addUser = userService.addUser(user, file);
		if(addUser!=null) {
			response.setStatus(201);
			response.setMessage(messages.get(AppConstants.USER_REG));
			response.setData(addUser);
		}else {
			response.setStatus(500);
			response.setMessage(messages.get(AppConstants.USER_REG_ERR));
		}
		log.info("User Registeration Process Completed");
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	@PostMapping("/login")
	public ResponseEntity<ApiResponse<Users>> loginUser(@RequestBody Users user){
		log.info("User Login Process Started");
		ApiResponse<Users> response=new ApiResponse<Users>();
		Map<String, String> messages = props.getMessages();
		Users loggedInUser=userService.login(user);
		if(loggedInUser!=null) {
			response.setStatus(201);
			response.setMessage(messages.get(AppConstants.USER_LOGIN));
			response.setData(loggedInUser);
		}else {
			log.error("User Login Failed");
			response.setStatus(400);
			response.setMessage(messages.get(AppConstants.USER_LOGIN_ERR));
		}
	  return new ResponseEntity<>(response,HttpStatus.OK);
	}
	

}
