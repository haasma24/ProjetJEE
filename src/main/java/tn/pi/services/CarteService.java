package tn.pi.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.pi.entities.Carte;
import tn.pi.repositories.CarteRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarteService {

    private final CarteRepository carteRepository;

    public List<Carte> getAllCartes() {
        return carteRepository.findAll();
    }

    public Optional<Carte> getCarteById(Long id) {
        return carteRepository.findById(id);
    }

    public Carte createCarte(Carte carte) {
        return carteRepository.save(carte);
    }

    public Carte updateCarte(Long id, Carte updatedCarte) {
        return carteRepository.findById(id).map(carte -> {
            carte.setNumero(updatedCarte.getNumero());
            carte.setType(updatedCarte.getType());
            carte.setCompte(updatedCarte.getCompte());
            return carteRepository.save(carte);
        }).orElseThrow(() -> new RuntimeException("Carte not found"));
    }

    public void deleteCarte(Long id) {
        carteRepository.deleteById(id);
    }
}
