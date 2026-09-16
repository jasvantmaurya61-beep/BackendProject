package sample.webmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/footwear")
public class UserController {
	
	@RequestMapping("/")

	public String greet() {
		System.out.println("UsrController.welcome");
		return "footwear";
	}
	
	
	// /WEB-INF/JSP/welcome.jsp
	
	//@RequestMapping(value="/movies" , method = RequestMethod.GET)
	@GetMapping(value = {"/movies", "/films" })
	
	public String movie() {
		System.out.println("UsrController.movie");
		return "movies";
	}

}
