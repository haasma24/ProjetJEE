package tn.pi.BankApp.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import tn.pi.BankApp.entities.User;
import tn.pi.BankApp.web.dto.UserRegistrationDto;
import tn.pi.BankApp.exceptions.UserAlreadyExistsException;

public interface UserService extends UserDetailsService {
	User save(UserRegistrationDto registrationDto) throws UserAlreadyExistsException;
	User getCurrentUser();

	User findByEmail(String email);

//	User findByEmail(String email);
}
