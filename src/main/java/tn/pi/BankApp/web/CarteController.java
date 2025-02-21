package tn.pi.BankApp.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tn.pi.BankApp.entities.Carte;
import tn.pi.BankApp.repository.CarteRepository;


@Controller
public class CarteController {

    private final CarteRepository carteRepository;

    public CarteController(CarteRepository carteRepository) {
        this.carteRepository = carteRepository;
    }

    @GetMapping("/index")
    public String index(Model model) {
        return "main";
    }

    @GetMapping("/cartes")
    public String listCartes(Model model) {
        model.addAttribute("cartes", carteRepository.findAll());
        return "cards"; // Vue affichant la liste des cartes
    }

    @GetMapping("/carteDetails")
    public String carteDetails(@RequestParam Long id, Model model) {
        Carte carte = carteRepository.findById(id).orElseThrow(() -> new RuntimeException("Carte not found"));
        model.addAttribute("carte", carte);
        return "carteDetails"; // Vue affichant les détails d'une carte
    }

    @GetMapping("/deleteCarte")
    public String deleteCarte(@RequestParam Long id) {
        carteRepository.deleteById(id);
        return "redirect:/cartes"; // Redirection vers la liste des cartes
    }

    @GetMapping("/formCarte")
    public String formCarte(Model model) {
        model.addAttribute("carte", new Carte());
        return "formCarte"; // Vue pour ajouter une nouvelle carte
    }

    @PostMapping("/saveCarte")
    public String saveCarte(Carte carte, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return "formCarte";
        carteRepository.save(carte);
        return "redirect:/cartes";
    }

    @GetMapping("/editCarte")
    public String editCarte(@RequestParam Long id, Model model) {
        Carte carte = carteRepository.findById(id).orElseThrow(() -> new RuntimeException("Carte not found"));
        model.addAttribute("carte", carte);
        return "formCarte"; // Réutilisation de la vue du formulaire pour modification
    }
}
