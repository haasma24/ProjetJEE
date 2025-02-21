////package tn.pi.BankApp.config;
////
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.context.annotation.Bean;
////import org.springframework.context.annotation.Configuration;
////import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
////import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
////import org.springframework.security.config.annotation.web.builders.HttpSecurity;
////import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
////import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
////import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
////import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
////
////import tn.pi.BankApp.service.UserService;
////
////@Configuration
////@EnableWebSecurity
////public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
////
////	@Autowired
////	private UserService userService;
////
////	@Bean
////    public BCryptPasswordEncoder passwordEncoder() {
////        return new BCryptPasswordEncoder();
////    }
////
////	@Bean
////    public DaoAuthenticationProvider authenticationProvider() {
////        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
////        auth.setUserDetailsService(userService);
////        auth.setPasswordEncoder(passwordEncoder());
////        return auth;
////    }
////
////	@Override
////    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////        auth.authenticationProvider(authenticationProvider());
////    }
////
////	@Override
////	protected void configure(HttpSecurity http) throws Exception {
////		http.authorizeRequests().antMatchers(
////				 "/registration**",
////	                "/js/**",
////						"/assets/css/**",
////	                "/img/**").permitAll()
////		.anyRequest().authenticated()
////		.and()
////		.formLogin()
////		.loginPage("/login")
////		.permitAll()
////		.and()
////		.logout()
////		.invalidateHttpSession(true)
////		.clearAuthentication(true)
////		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
////		.logoutSuccessUrl("/login?logout")
////		.permitAll();
////	}
////
////}
//package tn.pi.BankApp.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//public class SecurityConfiguration {
//
//	@Bean
//	public BCryptPasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//
////	@Bean
////	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
////		http
////				.authorizeHttpRequests(auth -> auth
////						.requestMatchers("/registration**", "/css/**", "/js/**").permitAll()
////						.anyRequest().authenticated()
////				)
////				.formLogin(form -> form
////						.loginPage("/login")
////						.loginProcessingUrl("/login")
////						.defaultSuccessUrl("/dashboard", true)
////						.failureUrl("/login?error=true")
////						.permitAll()
////				)
////				.logout(logout -> logout
////						.logoutUrl("/logout")
////						.logoutSuccessUrl("/login?logout=true")
////						.permitAll()
////				)
////				.sessionManagement(session -> session
////						.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
////				)
////				.csrf(csrf -> csrf.ignoringRequestMatchers("/api/**")); // Désactiver CSRF pour les API REST
////
////		return http.build();
////	}
//
//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//		http
//				.authorizeHttpRequests(auth -> auth
//						.requestMatchers("/login", "/css/**", "/js/**").permitAll()
//						.anyRequest().authenticated()
//				)
//				.formLogin(login -> login
//						.loginPage("/login")
//						.defaultSuccessUrl("/dashboard", true)
//						.permitAll()
//				)
//				.logout(logout -> logout
//						.logoutUrl("/logout")
//						.logoutSuccessUrl("/login?logout=true")
//						.permitAll()
//				);
//
//		return http.build();
//	}
//
//}





//*********
package tn.pi.BankApp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
				.authorizeHttpRequests(auth -> auth
						.requestMatchers("/registration**", "/css/**", "/js/**", "/img/**").permitAll()
						.anyRequest().authenticated()
				)
				.formLogin(form -> form
						.loginPage("/login")
						.loginProcessingUrl("/login")
						.defaultSuccessUrl("/dashboard", true)
						.failureUrl("/login?error=true")
						.permitAll()
				)
				.logout(logout -> logout
						.logoutUrl("/logout")
						.logoutSuccessUrl("/login?logout=true")
						.invalidateHttpSession(true)
						.deleteCookies("JSESSIONID")
						.permitAll()
				)
				.sessionManagement(session -> session
						.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
				)
				.csrf(csrf -> csrf.ignoringRequestMatchers("/api/**")); // Désactiver CSRF pour les API REST

		return http.build();
	}
}
