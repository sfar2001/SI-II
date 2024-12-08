package tn.esprit.tpfoyer.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReservation;
    private Date anneeUniversitaire;
    private boolean estValide;

    @ManyToMany
    @JoinTable(
            name = "reservation_etudiant", // Name of the join table
            joinColumns = @JoinColumn(name = "reservation_id"), // Foreign key column referring to Reservation
            inverseJoinColumns = @JoinColumn(name = "etudiant_id") // Foreign key column referring to Etudiant
    )
    private Set<Etudiant> etudiants;

    @OneToMany(cascade = CascadeType.ALL)
    @ToString.Exclude
    @JsonIgnore
    Set<Reservation> reservations;

}