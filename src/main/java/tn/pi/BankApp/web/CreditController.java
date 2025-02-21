package tn.pi.BankApp.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tn.pi.BankApp.entities.Credit;
import tn.pi.BankApp.repository.CreditRepository;


@Controller
public class CreditController {

    private final CreditRepository creditRepository;

    public CreditController(CreditRepository creditRepository) {
        this.creditRepository = creditRepository;
    }

    @GetMapping("/credits")
    public String listCredits(Model model) {
        model.addAttribute("credits", creditRepository.findAll());
        return "credits"; // Vue affichant la liste des crédits
    }

    @GetMapping("/creditDetails")
    public String creditDetails(@RequestParam Long id, Model model) {
        Credit credit = creditRepository.findById(id).orElseThrow(() -> new RuntimeException("Credit not found"));
        model.addAttribute("credit", credit);
        return "creditDetails"; // Vue affichant les détails d'un crédit
    }

    @GetMapping("/deleteCredit")
    public String deleteCredit(@RequestParam Long id) {
        creditRepository.deleteById(id);
        return "redirect:/credits"; // Redirection vers la liste des crédits
    }

    @GetMapping("/formCredit")
    public String formCredit(Model model) {
        model.addAttribute("credit", new Credit());
        return "creditForm"; // Vue pour ajouter un nouveau crédit
    }

    @PostMapping("/saveCredit")
    public String saveCredit(Credit credit, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return "creditForm";
        creditRepository.save(credit);
        return "redirect:/credits";
    }

    @GetMapping("/editCredit")
    public String editCredit(@RequestParam Long id, Model model) {
        Credit credit = creditRepository.findById(id).orElseThrow(() -> new RuntimeException("Credit not found"));
        model.addAttribute("credit", credit);
        return "creditForm"; // Réutilisation de la vue du formulaire pour modification
    }
}
