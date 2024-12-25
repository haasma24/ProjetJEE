package tn.pi.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.pi.entities.Compte;
import tn.pi.repositories.CompteRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompteService {

    private final CompteRepository compteRepository;

    public List<Compte> getAllComptes() {
        return compteRepository.findAll();
    }

    public Optional<Compte> getCompteById(Long id) {
        return compteRepository.findById(id);
    }

    public Compte createCompte(Compte compte) {
        return compteRepository.save(compte);
    }

    public Compte updateCompte(Long id, Compte updatedCompte) {
        return compteRepository.findById(id).map(compte -> {
            compte.setNumero(updatedCompte.getNumero());
            compte.setSolde(updatedCompte.getSolde());
            compte.setClient(updatedCompte.getClient());
            return compteRepository.save(compte);
        }).orElseThrow(() -> new RuntimeException("Compte not found"));
    }

    public void deleteCompte(Long id) {
        compteRepository.deleteById(id);
    }
}
