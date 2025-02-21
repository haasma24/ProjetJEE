package tn.pi.BankApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.pi.BankApp.entities.Compte;

@Repository
public interface CompteRepository extends JpaRepository<Compte, Long> {
}
