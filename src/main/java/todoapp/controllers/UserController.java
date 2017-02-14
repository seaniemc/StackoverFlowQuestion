package todoapp.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import todoapp.models.User;
import todoapp.repositories.UserRepository;

@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	UserRepository userRepository;
	
	//return all data
	@RequestMapping(method=RequestMethod.GET)
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	//create statement
	@RequestMapping(method=RequestMethod.POST)
	public User createUser(@Valid @RequestBody User user) {
		return userRepository.save(user);
	}

	//return by Id
	@RequestMapping(value="{id}", method=RequestMethod.GET)
	public ResponseEntity<User> getUserById(@PathVariable("id") String id) {
		User user = userRepository.findOne(id);
		if(user == null) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.PUT)
	public ResponseEntity<User> updateUser(@Valid @RequestBody User user, @PathVariable("id") String id) {
		User userData = userRepository.findOne(id);
		if(userData == null) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		userData.setName(user.getName());
		userData.setUsername(user.getUsername());
		userData.setPassword(user.getPassword());
		userData.setRole(user.getRole());
		
		User updatedUser = userRepository.save(userData);
		return new ResponseEntity<User>(updatedUser, HttpStatus.OK);
	}
	
	
	//delete by Id
	@RequestMapping(value="{id}", method=RequestMethod.DELETE)
	public void deleteUser(@PathVariable("id") String id) {
		userRepository.delete(id);
	}
	
}