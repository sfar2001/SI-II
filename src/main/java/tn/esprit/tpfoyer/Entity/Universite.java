package tn.esprit.tpfoyer.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Universite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUniversite;

    private String nomUniversite;
    private String adresse;
    @OneToOne(mappedBy = "universite")
    Foyer foyer;
    @OneToMany(mappedBy = "universite", cascade = CascadeType.ALL)
    private Set<Etudiant> etudiants; // Add this relationship
}
