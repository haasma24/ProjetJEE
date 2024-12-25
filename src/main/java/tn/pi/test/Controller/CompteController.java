package tn.pi.test.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.pi.test.Entity.Compte;
import tn.pi.test.Service.CompteService;
import tn.pi.test.Service.iCompteService;

import java.util.List;

@RestController
@RequestMapping("/comptes")
public class CompteController {

    @Autowired
    private iCompteService compteService;

    @PostMapping("/createcompte")
    public ResponseEntity<Compte> createCompte(@RequestBody Compte compte) {
        return ResponseEntity.ok(compteService.createCompte(compte));
    }

    @PutMapping("/updatecompte/{id}")
    public ResponseEntity<Compte> updateCompte(@PathVariable Long id, @RequestBody Compte compte) {
        return ResponseEntity.ok(compteService.updateCompte(id, compte));
    }
    @PutMapping("/{compteId}/client/{clientId}")
    public ResponseEntity<Compte> affecterClient(@PathVariable Long compteId, @PathVariable Long clientId) {
        return ResponseEntity.ok(compteService.affecterClient(compteId, clientId));
    }


    @GetMapping("/afficherid/{id}")
    public ResponseEntity<Compte> getCompteById(@PathVariable Long id) {
        return ResponseEntity.ok(compteService.getCompteById(id));
    }

    @GetMapping("/afficherallcomptes")
    public ResponseEntity<List<Compte>> getAllComptes() {
        return ResponseEntity.ok(compteService.getAllComptes());
    }

    @DeleteMapping("/deletecompte/{id}")
    public ResponseEntity<String> deleteCompte(@PathVariable Long id) {
        compteService.deleteCompte(id);
        return ResponseEntity.ok("Compte deleted successfully.");
    }
}