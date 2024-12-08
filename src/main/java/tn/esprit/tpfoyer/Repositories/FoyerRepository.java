package tn.esprit.tpfoyer.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.tpfoyer.Entity.Foyer;
@Repository
public interface FoyerRepository extends JpaRepository<Foyer,Long> {
}