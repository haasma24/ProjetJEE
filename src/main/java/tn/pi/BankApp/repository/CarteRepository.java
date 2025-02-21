package tn.pi.BankApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.pi.BankApp.entities.Carte;

import java.util.List;

@Repository
public interface CarteRepository extends JpaRepository<Carte, Long> {
    List<Carte> findByCompte_User_Id(Long userId);
}
