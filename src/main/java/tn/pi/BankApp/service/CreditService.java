package tn.pi.BankApp.service;

import org.springframework.stereotype.Service;
import tn.pi.BankApp.entities.Credit;
import tn.pi.BankApp.repository.CreditRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CreditService {

    private final CreditRepository creditRepository;

    public CreditService(CreditRepository creditRepository) {
        this.creditRepository = creditRepository;
    }

    public List<Credit> getAllCredits() {
        return creditRepository.findAll();
    }

    public Optional<Credit> getCreditById(Long id) {
        return creditRepository.findById(id);
    }

    public Credit saveCredit(Credit credit) {
        return creditRepository.save(credit);
    }

    public void deleteCredit(Long id) {
        creditRepository.deleteById(id);
    }
}
