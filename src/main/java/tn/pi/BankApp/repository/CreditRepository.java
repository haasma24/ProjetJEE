package tn.pi.BankApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.pi.BankApp.entities.Credit;

@Repository
public interface CreditRepository extends JpaRepository<Credit, Long> {
}
