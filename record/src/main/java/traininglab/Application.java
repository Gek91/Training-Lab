package traininglab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import traininglab.rest.RestConfiguration;

@SpringBootApplication
@Import({RestConfiguration.class, WebSecurityConfiguration.class})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
