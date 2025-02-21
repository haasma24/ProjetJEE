package tn.pi.BankApp.service;

import org.springframework.stereotype.Service;
import tn.pi.BankApp.entities.Compte;
import tn.pi.BankApp.repository.CompteRepository;

import java.util.List;
import java.util.Optional;


@Service
public class CompteService {

    private final CompteRepository compteRepository;

    public CompteService(CompteRepository compteRepository) {
        this.compteRepository = compteRepository;
    }

    public List<Compte> getAllComptes() {
        return compteRepository.findAll();
    }

    public Optional<Compte> getCompteById(Long id) {
        return compteRepository.findById(id);
    }

    public Compte saveCompte(Compte compte) {
        return compteRepository.save(compte);
    }

    public void deleteCompte(Long id) {
        compteRepository.deleteById(id);
    }
}
