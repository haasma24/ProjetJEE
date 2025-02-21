package tn.pi.BankApp.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tn.pi.BankApp.entities.Compte;
import tn.pi.BankApp.repository.CompteRepository;


@Controller
public class CompteController {

    private final CompteRepository compteRepository;

    public CompteController(CompteRepository compteRepository) {
        this.compteRepository = compteRepository;
    }

    @GetMapping("/comptes")
    public String listComptes(Model model) {
        model.addAttribute("comptes", compteRepository.findAll());
        return "accounts"; // Vue affichant la liste des comptes
    }

    @GetMapping("/compteDetails")
    public String compteDetails(@RequestParam Long id, Model model) {
        Compte compte = compteRepository.findById(id).orElseThrow(() -> new RuntimeException("Compte not found"));
        model.addAttribute("compte", compte);
        return "compteDetails"; // Vue affichant les détails d'un compte
    }

    @GetMapping("/deleteCompte")
    public String deleteCompte(@RequestParam Long id) {
        compteRepository.deleteById(id);
        return "redirect:/comptes"; // Redirection vers la liste des comptes
    }

    @GetMapping("/formCompte")
    public String formCompte(Model model) {
        model.addAttribute("compte", new Compte());
        return "formCompte"; // Vue pour ajouter un nouveau compte
    }

    @PostMapping("/saveCompte")
    public String saveCompte(Compte compte, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return "formCompte";
        compteRepository.save(compte);
        return "redirect:/comptes";
    }

    @GetMapping("/editCompte")
    public String editCompte(@RequestParam Long id, Model model) {
        Compte compte = compteRepository.findById(id).orElseThrow(() -> new RuntimeException("Compte not found"));
        model.addAttribute("compte", compte);
        return "formCompte"; // Réutilisation de la vue du formulaire pour modification
    }
}
