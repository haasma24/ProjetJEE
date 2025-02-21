package tn.pi.BankApp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import tn.pi.BankApp.entities.User;
import tn.pi.BankApp.repository.UserRepository;
import java.util.Optional;

//@Controller
//@RequestMapping("/user")
//public class UserController {
//
//    private final UserService userService;
//
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }
//
//    @GetMapping("/profile")
//    public String afficherProfil(Model model, Principal principal) {
//        if (principal == null) {
//            return "redirect:/login"; // Redirige si l'utilisateur n'est pas connecté
//        }
//
//        String email = principal.getName(); // Récupère l'email de l'utilisateur connecté
//        User user = userService.findByEmail(email); // Cherche l'utilisateur en BD
//
//        model.addAttribute("user", user); // Ajoute l'utilisateur au modèle
//
//        return "profile"; // Charge la page `profile.html`
//    }
//
//
//
//
//        @GetMapping("/profile")
//        public String showProfile(Model model, Principal principal) {
//            String email = principal.getName(); // Récupère l'email de l'utilisateur connecté
//            User user = userRepository.findByEmail(email).orElse(null);
//
//            if (user == null) {
//                return "redirect:/login"; // Rediriger vers la page de connexion si l'utilisateur n'est pas trouvé
//            }
//
//            model.addAttribute("user", user); // Ajouter l'utilisateur au modèle
//            return "profile";
//        }}


@Controller
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository; // Déclaration correcte

    // Injection via le constructeur
    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/logout")
    public String logout() {
        // Optionally clear the security context if you're not using Spring Security
        SecurityContextHolder.clearContext();
        return "redirect:/"; // Redirect to the home page after logout
    }
    @GetMapping("/{id}")
    public String getUserById(@PathVariable Long id, Model model) {
        Optional<User> user = userRepository.findById(id);

        if (user.isPresent()) {
            model.addAttribute("user", user.get());
            return "profile";
        } else {
            return "error";
        }
    }
}



