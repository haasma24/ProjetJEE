package tn.pi.test.Service;

import tn.pi.test.Entity.Compte;

import java.util.List;

public interface iCompteService {
    Compte createCompte(Compte compte);
    Compte updateCompte(Long id, Compte compte);
    Compte getCompteById(Long id);
    List<Compte> getAllComptes();
    void deleteCompte(Long id);
    Compte affecterClient(Long compteId, Long clientId);

}
