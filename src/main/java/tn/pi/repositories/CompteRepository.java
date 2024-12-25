package tn.pi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.pi.entities.Compte;

@Repository
public interface CompteRepository extends JpaRepository<Compte, Long> {
}
