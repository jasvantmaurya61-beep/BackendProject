package sample.webmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class UserController {

	// @RequestParam Can read Query Parameter
	@GetMapping("/")

	public String greet(@RequestParam(name = "user", defaultValue = "GuestUser") String user, Model model) {
		System.out.println("UsrController.greet:" + user);

		model.addAttribute("user", user);
		return "welcome";
	}

	@GetMapping("/login")
	public String login() {
		System.out.println("UserController.login()");
		return "login";
	}

	@GetMapping("/path/{id}")
	public String pathVariablle(@PathVariable(name = "id") int id) {
		System.out.println("UserController.pathVariablle:"+id);
		return "login";
	}

	@PostMapping("/login")
	public String userLogin(@RequestParam(name = "username") String username , @RequestParam(name = "password") String password, Model model) {
		System.out.println("UserController.username:" + username);
		System.out.println("UsernameController.userpassword:" + password);
		model.addAttribute("username", username);
		model.addAttribute("password", password);

		return "profile";
	}

}
