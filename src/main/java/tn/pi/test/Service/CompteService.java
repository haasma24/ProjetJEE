package tn.pi.test.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.pi.test.Entity.Client;
import tn.pi.test.Entity.Compte;
import tn.pi.test.Repository.ClientRepository;
import tn.pi.test.Repository.CompteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CompteService implements iCompteService {
    @Autowired
    private CompteRepository compteRepository;
    @Autowired
private ClientRepository clientRepository;
    @Override
    public Compte createCompte(Compte compte) {
        return compteRepository.save(compte);
    }

    @Override
    public Compte affecterClient(Long compteId, Long clientId) {
        // Rechercher le compte par son ID
        Compte compte = compteRepository.findById(compteId)
                .orElseThrow(() -> new RuntimeException("Compte not found with id " + compteId));

        // Rechercher le client par son ID
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client not found with id " + clientId));

        // Affecter le client au compte
        compte.setClient(client);

        // Enregistrer les modifications
        return compteRepository.save(compte);
    }

    @Override
    public Compte updateCompte(Long id, Compte compte) {
        Optional<Compte> existingCompte = compteRepository.findById(id);
        if (existingCompte.isPresent()) {
            Compte updatedCompte = existingCompte.get();
            updatedCompte.setNumero(compte.getNumero());
            updatedCompte.setSolde(compte.getSolde());
            updatedCompte.setClient(compte.getClient());
            return compteRepository.save(updatedCompte);
        } else {
            throw new RuntimeException("Compte not found with id " + id);
        }
    }

    @Override
    public Compte getCompteById(Long id) {
        return compteRepository.findById(id).orElseThrow(() -> new RuntimeException("Compte not found with id " + id));
    }

    @Override
    public List<Compte> getAllComptes() {
        return compteRepository.findAll();
    }

    @Override
    public void deleteCompte(Long id) {
        if (compteRepository.existsById(id)) {
            compteRepository.deleteById(id);
        } else {
            throw new RuntimeException("Compte not found with id " + id);
        }
    }
}
