package tn.pi.BankApp.service;

import org.springframework.stereotype.Service;
import tn.pi.BankApp.entities.Carte;
import tn.pi.BankApp.repository.CarteRepository;
import tn.pi.BankApp.repository.UserRepository;

import java.util.List;
import java.util.Optional;


@Service
public class CarteService {

    private final CarteRepository carteRepository;
    private final UserRepository userRepository ;

    public CarteService(CarteRepository carteRepository, UserRepository userRepository) {
        this.carteRepository = carteRepository;
        this.userRepository = userRepository;
    }

    public List<Carte> getAllCartes() {
        return carteRepository.findAll();
    }

    public Optional<Carte> getCarteById(Long id) {
        return carteRepository.findById(id);
    }

    public Carte saveCarte(Carte carte) {
        return carteRepository.save(carte);
    }

    public void deleteCarte(Long id) {
        carteRepository.deleteById(id);
    }
}
