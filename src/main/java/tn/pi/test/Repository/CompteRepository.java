package tn.pi.test.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.pi.test.Entity.Compte;

@Repository

public interface CompteRepository extends JpaRepository<Compte, Long> {
}
