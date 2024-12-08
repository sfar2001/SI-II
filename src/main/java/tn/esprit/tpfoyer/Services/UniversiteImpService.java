package tn.esprit.tpfoyer.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.Entity.Etudiant;
import tn.esprit.tpfoyer.Entity.Universite;
import tn.esprit.tpfoyer.Repositories.EtudiantRepository;
import tn.esprit.tpfoyer.Repositories.UniversiteRepository;

import java.util.Date;
import java.util.List;


@Service
@AllArgsConstructor
public class UniversiteImpService implements IUniversiteService{
    UniversiteRepository universiteRepository;
    EtudiantRepository etudiantRepository;

    @Override
    public List<Universite> retrieveAllUniversites() {
        return universiteRepository.findAll();
    }

    @Override
    public Universite addUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public Universite modifyUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public Universite retrieveUniversite(Long idUniversite) {
        return universiteRepository.findById(idUniversite).orElse(null);
    }

    @Override
    public void removeUniversite(Long idUniversite) {
        universiteRepository.deleteById(idUniversite);
    }
    @Override
    public List<Etudiant> getEtudiantsByUniversiteAndDate(Long idUniversite, Date date) {
        return etudiantRepository.findByUniversiteAndDateNaissanceAfter(idUniversite, date);
    }
}

