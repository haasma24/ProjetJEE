//package tn.pi.BankApp.web;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//
//@Controller
//public class DashboardController {
//
//
//
//    @GetMapping("/dashboard")
//    public String dashboard() {
//        return "dashboard";
//    }
//
//    @GetMapping("/cards")
//    public String cards() {
//        return "cards";
//    }
//
////    @GetMapping("/profile")
////    public String profile() {
////        return "profile";
////    }
//
//    @GetMapping("/operations")
//    public String operations() {
//        return "operations";
//    }
//
//    @GetMapping("/accounts")
//    public String accounts() {
//        return "accounts";
//    }
//}
package tn.pi.BankApp.web;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tn.pi.BankApp.entities.User;
import tn.pi.BankApp.repository.UserRepository;

import java.util.Optional;

@Controller
//@RequestMapping("/dashboard")
public class DashboardController {

    private final UserRepository userRepository;

    public DashboardController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping("/dashboard")
    public String dashboard() {
        return "dashboard";
    }

    @GetMapping("/cards")
    public String cards() {
        return "cards";
    }

    @GetMapping("/operations")
    public String operations() {
        return "operations";
    }

    @GetMapping("/accounts")
    public String accounts() {
        return "accounts";
    }

    @GetMapping("/profile")
    public String profile() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName(); // Récupérer l'email de l'utilisateur connecté

        Optional<User> user = userRepository.findByEmail(email); // Modifier selon ton UserRepository

        if (user.isPresent()) {
            return "redirect:/users/" + user.get().getId();
        } else {
            return "error";
        }
    }
}
