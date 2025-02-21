package tn.pi.BankApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.pi.BankApp.entities.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
//	User findByEmail(String email);
	Optional<User> findByEmail(String email);
//    User findByFirstName(String firstname);

    boolean existsByEmail(String email);

}
