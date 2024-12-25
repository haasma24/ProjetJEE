package tn.pi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tn.pi.entities.*;
import tn.pi.repositories.*;

import java.time.LocalDate;


@SpringBootApplication
public class ProjectBankApplication  {


	public static void main(String[] args) {
		SpringApplication.run(ProjectBankApplication.class, args);
		System.out.println("Hello World!");
	}

	public CommandLineRunner init(CreditRepository creditRepository,
								  CompteRepository compteRepository,
								  OperationRepository operationRepository,
								  ClientRepository clientRepository ,
								  CarteRepository carteRepository) { //
		return args -> {
			/**
			 * Begin transaction
			 */

			// 1. Créer un client
		Client client = Client.builder()
				.nom("Doe")
				.prenom("John")
				.email("john.doe@example.com")
				.telephone("123456789")
				.build();
		client = clientRepository.save(client);
		System.out.println("Client créé : " + client);

			// 2. Créer un compte pour ce client
		Compte compte = Compte.builder()
				.numero("ACC123")
				.solde(1000.0)
				.client(client)
				.build();
		compte = compteRepository.save(compte);
		System.out.println("Compte créé : " + compte);

			// 3. Créer une carte pour ce compte
		Carte carte = Carte.builder()
				.numero("CARD123")
				.type("Débit")
				.compte(compte)
				.build();
		carte = carteRepository.save(carte);
		System.out.println("Carte créée : " + carte);

			// 4. Ajouter un crédit pour le client
		Credit credit = Credit.builder()
				.montant(5000.0)
				.tauxInteret(5.0)
				.dateDebut(LocalDate.now())
				.dateFin(LocalDate.now().plusYears(1))
				.client(client)
				.build();
		credit = creditRepository.save(credit);
		System.out.println("Crédit créé : " + credit);

			// 5. Effectuer une opération sur le compte
		Operation operation = Operation.builder()
				.type("Débit")
				.montant(200.0)
				.date(LocalDate.now())
				.compte(compte)
				.build();
		operation = operationRepository.save(operation);
		System.out.println("Opération créée : " + operation);

			// 6. Afficher toutes les cartes
		System.out.println("\nListe des cartes :");
		carteRepository.findAll().forEach(System.out::println);

			// 7. Afficher tous les comptes
		System.out.println("\nListe des comptes :");
		compteRepository.findAll().forEach(System.out::println);

			// 8. Afficher toutes les opérations
		System.out.println("\nListe des opérations :");
		operationRepository.findAll().forEach(System.out::println);

			/**
			 * End transaction
			 */
		};
	}
}
