package traininglab.core.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordGenerator {

	public static void main(String[] args) {

		String password = "ciao";
		String encryptedPassword = new BCryptPasswordEncoder().encode(password);
		System.out.println(password + " bcrypt-> " + encryptedPassword);
	}
}
