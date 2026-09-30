package sample.webmvc.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import sample.webmvc.entity.User;

@Controller
@ResponseBody
public class UserController {
	
	static Map<Integer, User> users = new HashMap<>();
	
	static {
		
		users.put(1, new User(1,"Vikas","Male","Noida"));
		users.put(2, new User(2,"Kunal","Male","GZB"));
		users.put(3, new User(3,"Nakul","Male","Noida"));
		users.put(4, new User(4,"Abhi","Male","Gurgaon"));
		users.put(5, new User(5,"Arjun","Male","Noida"));
		
	}

	@GetMapping("/")
	public User greet() {
		System.out.println("UserController.greet : ");
		return new User(99,"Dummy","No","Planet Not Found");

	}
	@GetMapping("/{id}")
	public User pathVariablle(@PathVariable(name = "id") int id) {
		System.out.println("UserController.pathVariablle : " + id);
		return users.get(id);
	}

	
	@GetMapping("/all-users")
	public Map<Integer,User> getAllUsers() {
		System.out.println("UserController.getAllUsers()");
		return users;
	}


	@PostMapping
	public User saveUser(@RequestBody User user) {
		System.out.println("UserController.saveUser : ");
		System.out.println(user);
		users.put(user.getId(), user);
		return user;
	}

	@PutMapping("/{id}")
	public User updateUser(@PathVariable("id") int id,
	                       @RequestBody User user) {

	    user.setId(id);
	    users.put(id, user);

	    return user;
	}

	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable("id") int id) {

	    if (users.containsKey(id)) {
	        users.remove(id);
	        return "User deleted successfully";
	    }

	    return "User not found";
	}
}