package percentage.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public interface HTMLController {

	@GetMapping(path = "/welcome", produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	String welcomeAsHTML();

	@GetMapping(path= "/weights-table/{rm}", produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	String getWeightTableGiven1RMValue(@PathVariable("rm") String rm);

	@GetMapping(path = "/")
	ResponseEntity healthCheck();
}
