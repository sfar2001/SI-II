package tn.esprit.tpfoyer.Entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@ToString
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Etudiant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEtudiant;
    private String nomEt;
    private String prenomEt;
    private Long cin;
    private String ecole;
    private Date dateNaissance;

    @ManyToOne
    @JoinColumn(name = "universite_id")
    private Universite universite; // Add this relationship

    @ManyToMany(mappedBy = "etudiants")
    private Set<Reservation> reservations;


}
