package tn.pi.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tn.pi.entities.Compte;
import tn.pi.services.CompteService;

import java.util.List;

@Controller
@RequestMapping("/api/comptes")
@RequiredArgsConstructor
public class CompteController {

    private final CompteService compteService;

    @GetMapping
    public List<Compte> getAllComptes() {
        return compteService.getAllComptes();
    }

    @GetMapping("/{id}")
    public Compte getCompteById(@PathVariable Long id) {
        return compteService.getCompteById(id).orElseThrow(() -> new RuntimeException("Compte not found"));
    }

    @PostMapping
    public Compte createCompte(@RequestBody Compte compte) {
        return compteService.createCompte(compte);
    }

    @PutMapping("/{id}")
    public Compte updateCompte(@PathVariable Long id, @RequestBody Compte updatedCompte) {
        return compteService.updateCompte(id, updatedCompte);
    }

    @DeleteMapping("/{id}")
    public void deleteCompte(@PathVariable Long id) {
        compteService.deleteCompte(id);
    }
}
