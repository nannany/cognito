package nannany.sample.cognito;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/hello")
				.hasAnyAuthority("SCOPE_nannany.sample.cognito/hello.read", "SCOPE_aws.cognito.signin.user.admin")
				.antMatchers(HttpMethod.GET, "/goodbye")
				.hasAnyAuthority("SCOPE_nannany.sample.cognito/goodbye.read", "SCOPE_aws.cognito.signin.user.admin");

		http.oauth2ResourceServer().jwt();
	}

//	private CorsConfigurationSource corsConfigurationSource() {
//		CorsConfiguration corsConfiguration = new CorsConfiguration();
//		corsConfiguration.addAllowedMethod("GET");
//		corsConfiguration.addAllowedOrigin("http://localhost:3000");
//
//		UrlBasedCorsConfigurationSource corsSource = new UrlBasedCorsConfigurationSource();
//		corsSource.registerCorsConfiguration("/hello", corsConfiguration);
//		corsSource.registerCorsConfiguration("/goodbye", corsConfiguration);
//
//		return corsSource;
//	}
}
