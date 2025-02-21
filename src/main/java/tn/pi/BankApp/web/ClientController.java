package tn.pi.BankApp.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tn.pi.BankApp.entities.Client;
import tn.pi.BankApp.entities.User;
import tn.pi.BankApp.repository.ClientRepository;
import tn.pi.BankApp.repository.UserRepository;
import tn.pi.BankApp.service.UserService;
import tn.pi.BankApp.service.UserServiceImpl;

import java.security.Principal;


@Controller
public class ClientController {

    private final ClientRepository clientRepository;
    private final UserServiceImpl userServiceImpl;
    private final UserService userService;
    private final UserRepository userRepository;

    public ClientController(ClientRepository clientRepository, UserServiceImpl userServiceImpl , UserService userService, UserRepository userRepository) {
        this.clientRepository = clientRepository;
        this.userServiceImpl = userServiceImpl;
        this.userService = userService ;
        this.userRepository = userRepository;
    }


//    @GetMapping("/profile")
//    public String showProfile(Model model, Principal principal) {
//        String firstname = principal.getName(); // Récupérer le nom d'utilisateur connecté
////        User utilisateur = userService.findByFirstname(firstname);
//        User utilisateur = userRepository.findByFirstName(firstname);
//
//        if (utilisateur == null) {
//            return "redirect:/login"; // Rediriger si l'utilisateur n'est pas trouvé
//        }
//
//        model.addAttribute("utilisateur", utilisateur);
//        return "profile";
//    }


    @GetMapping("/clients")
    public String listClients(Model model) {
        model.addAttribute("clients", clientRepository.findAll());
        return "clients"; // Vue affichant la liste des clients
    }

    @GetMapping("/clientDetails")
    public String clientDetails(@RequestParam Long id, Model model) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new RuntimeException("Client not found"));
        model.addAttribute("client", client);
        return "clientDetails"; // Vue affichant les détails d'un client
    }

    @GetMapping("/deleteClient")
    public String deleteClient(@RequestParam Long id) {
        clientRepository.deleteById(id);
        return "redirect:/clients"; // Redirection vers la liste des clients
    }

    @GetMapping("/formClient")
    public String formClient(Model model) {
        model.addAttribute("client", new Client());
        return "formClient"; // Vue pour ajouter un nouveau client
    }

    @PostMapping("/saveClient")
    public String saveClient(Client client, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return "formClient";
        clientRepository.save(client);
        return "redirect:/clients";
    }

    @GetMapping("/editClient")
    public String editClient(@RequestParam Long id, Model model) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new RuntimeException("Client not found"));
        model.addAttribute("client", client);
        return "formClient"; // Réutilisation de la vue du formulaire pour modification
    }
}
