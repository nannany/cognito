package nannany.sample.cognito;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@CrossOrigin
	@GetMapping("/hello")
	public String hello() {
		return "Hello!";
	}

	@CrossOrigin
	@GetMapping("/goodbye")
	public String goodbye() {
		return "Goodbye!";
	}
}
