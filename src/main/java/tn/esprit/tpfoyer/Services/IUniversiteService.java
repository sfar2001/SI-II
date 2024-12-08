package tn.esprit.tpfoyer.Services;
import tn.esprit.tpfoyer.Entity.Etudiant;
import tn.esprit.tpfoyer.Entity.Universite;

import java.util.Date;
import java.util.List;

public interface IUniversiteService {
    List<Universite> retrieveAllUniversites();
    Universite addUniversite(Universite u);
    Universite modifyUniversite(Universite u);
    Universite retrieveUniversite(Long idUniversite);
    void removeUniversite(Long idUniversite);
    List<Etudiant> getEtudiantsByUniversiteAndDate(Long idUniversite, Date date);

}