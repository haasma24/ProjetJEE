package tn.pi.BankApp.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tn.pi.BankApp.entities.Operation;
import tn.pi.BankApp.repository.OperationRepository;


@Controller
public class OperationController {

    private final OperationRepository operationRepository;

    public OperationController(OperationRepository operationRepository) {
        this.operationRepository = operationRepository;
    }

    @GetMapping("/operation")
    public String listOperations(Model model) {
        model.addAttribute("operations", operationRepository.findAll());
        return "operations"; // Vue affichant la liste des opérations
    }

    @GetMapping("/operationDetails")
    public String operationDetails(@RequestParam Long id, Model model) {
        Operation operation = operationRepository.findById(id).orElseThrow(() -> new RuntimeException("Operation not found"));
        model.addAttribute("operation", operation);
        return "operationDetails"; // Vue affichant les détails d'une opération
    }

    @GetMapping("/deleteOperation")
    public String deleteOperation(@RequestParam Long id) {
        operationRepository.deleteById(id);
        return "redirect:/operations"; // Redirection vers la liste des opérations
    }

    @GetMapping("/formOperation")
    public String formOperation(Model model) {
        model.addAttribute("operation", new Operation());
        return "formOperation"; // Vue pour ajouter une nouvelle opération
    }

    @PostMapping("/saveOperation")
    public String saveOperation(Operation operation, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return "formOperation";
        operationRepository.save(operation);
        return "redirect:/operations";
    }

    @GetMapping("/editOperation")
    public String editOperation(@RequestParam Long id, Model model) {
        Operation operation = operationRepository.findById(id).orElseThrow(() -> new RuntimeException("Operation not found"));
        model.addAttribute("operation", operation);
        return "formOperation"; // Réutilisation de la vue du formulaire pour modification
    }
}
