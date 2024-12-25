package tn.pi.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.pi.entities.Credit;
import tn.pi.repositories.CreditRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CreditService {

    private final CreditRepository creditRepository;

    public List<Credit> getAllCredits() {
        return creditRepository.findAll();
    }

    public Optional<Credit> getCreditById(Long id) {
        return creditRepository.findById(id);
    }

    public Credit createCredit(Credit credit) {
        return creditRepository.save(credit);
    }

    public Credit updateCredit(Long id, Credit updatedCredit) {
        return creditRepository.findById(id).map(credit -> {
            credit.setMontant(updatedCredit.getMontant());
            credit.setTauxInteret(updatedCredit.getTauxInteret());
            credit.setDateDebut(updatedCredit.getDateDebut());
            credit.setDateFin(updatedCredit.getDateFin());
            credit.setClient(updatedCredit.getClient());
            return creditRepository.save(credit);
        }).orElseThrow(() -> new RuntimeException("Credit not found"));
    }

    public void deleteCredit(Long id) {
        creditRepository.deleteById(id);
    }
}
