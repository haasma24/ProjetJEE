package tn.pi.entities;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Carte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String numero;

    private String type; // Débit ou Crédit

    @ManyToOne
    @JoinColumn(name = "compte_id")
    private Compte compte;
}
