package tn.pi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.pi.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
