package tn.esprit.tpfoyer.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.tpfoyer.Entity.Etudiant;

import java.util.Date;
import java.util.List;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {

    @Query("SELECT e FROM Etudiant e WHERE e.universite.idUniversite = :idUniversite AND e.dateNaissance > :date")
    List<Etudiant> findByUniversiteAndDateNaissanceAfter(@Param("idUniversite") Long idUniversite, @Param("date") Date date);
    @Query("SELECT e FROM Etudiant e JOIN FETCH e.reservations r JOIN FETCH r.chambre WHERE e.cin = :cin")
    Etudiant findEtudiantWithReservationsByCin(@Param("cin") Long cin);
}

