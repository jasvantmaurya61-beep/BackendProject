package sample.webmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
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

	// id ke liye
	
	@GetMapping("/{id}")
	@ResponseBody
	public User pathVariablle(@PathVariable(name = "id") int id) {
		
		System.out.println("UserController.pathVariablle : " + id);

		return userService.getUserById(id);
	}
	 
	
	// Save user ki liye
	
	@PostMapping("/save-user")
	@ResponseBody
	public User saveUser(@RequestBody User user) {

		System.out.println("UserController.saveUser : ");
		System.out.println(user);
       return userService.saveUser(user);

	}  
	
	
	//Update User ki id k liye 
	
	@PutMapping("/user/{id}")
	public User updateUser(@PathVariable("id") int id ,@RequestBody User user) {
		
		return  userService.updateUser(id , user);
	}

     @DeleteMapping("/user/{id}")
	public String deleteUser(@PathVariable("id") int id) {
		userService.deleteUser(id);
		return "User deleted Successfull";
	}
}
