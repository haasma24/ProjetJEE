package tn.pi.test.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.pi.test.Entity.Client;

@Repository

public interface ClientRepository extends JpaRepository<Client, Long> {
}
