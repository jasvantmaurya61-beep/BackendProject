package sample.webmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import sample.webmvc.entity.User;
import sample.webmvc.service.UserService;

@Controller
public  class UserController {

	@Autowired
	UserService userService;
	private Model model;
	private UserController userSrevice;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/")
	public String greet() {
		System.out.println("UserController.greet : ");

		return "welcome";

	}

	@GetMapping("/login")
	public String login() {
		System.out.println("UserController.login()");
		return "login";

	}
	
	
	
   //  Get user by ID one id ke leye h
	
	@GetMapping("/path/{id}")
	@ResponseBody
	public User pathVariablle(@PathVariable(name = "id") int id) {
		
		System.out.println("UserController.pathVariablle : " + id);

		return userService.getUserById(id);
	}
	 
	// Get all users ke liye h 
	
	@GetMapping("/users")
	@ResponseBody
	public  List<User> getAllUser(Model model){
		List<User> users= userService.getAllUsers();
		 model.addAttribute("users", users);
		 
	return userService.getAllUsers();
	
	}
	
	
	// Get Delete user id  ke liye 
	
	@GetMapping("/delete/user/{id}")
	@ResponseBody
	public String deleteUser(@PathVariable("id")int id){
		userService.deleteUser(id);
		return "{\"message\":\"user deleted successfully\"}";
	}
	
	    //Update User ki id k liye 
	
	@GetMapping("/update/user/{id}")
	@ResponseBody
	public String updateUser(@ModelAttribute("user") User user) {
		userService.updateUser(user);
		return "{\"message\":\"user updated successfully\"}";
	}
	
	    // User ko  update karna ke liye h
	
//	@PutMapping("/update/user/{id}")
//	@ResponseBody
//	public User updateUser(@PathVariable("id") int id,
//	                       @RequestBody User user) {
//
//	    User existingUser = userService.getUserById(id);
//
//	    if (existingUser == null) {
//	        return null;
//	    }
//
//	    existingUser.setName(user.getName());
//	    existingUser.setGender(user.getGender());
//	    existingUser.setAddress(user.getAddress());
//
//	    userService.updateUser(existingUser);
//
//	    return existingUser;
//	}

	@GetMapping("/sign-up")
	public String signUp() {
		System.out.println("UserController.login()");
		return "signup";

	}

	@PostMapping("/sign-up")
	public String saveUser(@ModelAttribute User user, Model model) {

		System.out.println("UserController.saveUser : ");
		System.out.println(user);

		userService.saveUser(user);

		model.addAttribute("user", user);

		return "success";

	}



	@PostMapping("/login")
	public String userLogin(@RequestParam(name = "username") String username,
			@RequestParam(name = "password") String password, Model model) {

		System.out.println("UserController.userLogin : " + username);
		System.out.println("UserController.userLogin : " + password);

		model.addAttribute("username", username);
		model.addAttribute("password", password);

		return "profile";

	}

}