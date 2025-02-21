package tn.pi.BankApp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;  // ✅ Ajout de l'import

import tn.pi.BankApp.exceptions.UserAlreadyExistsException;
import tn.pi.BankApp.service.UserService;
import tn.pi.BankApp.web.dto.UserRegistrationDto;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

	private UserService userService;

	public UserRegistrationController(UserService userService) {
		super();
		this.userService = userService;
	}

	@ModelAttribute("user")
	public UserRegistrationDto userRegistrationDto() {
		return new UserRegistrationDto();
	}

	@GetMapping
	public String showRegistrationForm() {
		return "registration";
	}

	@PostMapping
	public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto registrationDto, Model model) {
		try {
			userService.save(registrationDto);
			return "redirect:/login?success";
		} catch (UserAlreadyExistsException ex) {
			model.addAttribute("error", ex.getMessage());
			return "registration"; // Recharge la page avec l'erreur
		}
	}
}
