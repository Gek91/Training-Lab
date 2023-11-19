package traininglab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.context.NullSecurityContextRepository;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;
	@Autowired
	private UserDetailsService userService;

	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {

		//jdbcAuthentication example
//		auth
//				.userDetailsService(userService)
//				.jdbcAuthentication()
//				.passwordEncoder(new BCryptPasswordEncoder())
//				.dataSource(dataSource)
//				.usersByUsernameQuery("SELECT id, password, enabled FROM \"user\" WHERE id = ?")
//				.authoritiesByUsernameQuery("SELECT user_id, role FROM user_role WHERE user_id = ?");

		//set directly the userDetailsService, no need to specify query, datasource etc..
		auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
	}

	//enable password authentication
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
//				.authorizeRequests()
// use the AuthorizationFilter instead of FilterSecurityInterceptor
				.authorizeHttpRequests()
				.anyRequest().permitAll();
//				.authenticated()
//				.and()
//				.httpBasic(Customizer.withDefaults())

		//no user session enabled
		http.securityContext().securityContextRepository(new NullSecurityContextRepository());

		http.cors().and().csrf().disable();
	}
}
