package tn.esprit.tpfoyer.Entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.Set;


@Entity
@Getter
@ToString
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Foyer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFoyer;

    private String nomFoyer;
    private Long capaciteFoyer;
    @OneToOne
    Universite universite;
    @OneToMany(mappedBy = "foyer")
    private Set<Bloc> blocs;
}