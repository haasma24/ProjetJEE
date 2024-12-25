package tn.pi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.pi.entities.Carte;

@Repository
public interface CarteRepository extends JpaRepository<Carte, Long> {
}
