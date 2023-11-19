package traininglab.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public interface WelcomeController {

	@GetMapping(path = "/welcome", produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	String welcomeAsHTML();

	@GetMapping(path = "/")
	ResponseEntity healthCheck();
}
