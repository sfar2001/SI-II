package tn.esprit.tpfoyer.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.Entity.Chambre;
import tn.esprit.tpfoyer.Entity.TypeChambre;
import tn.esprit.tpfoyer.Repositories.ChambreRepository;
import java.util.List;

@Service
@AllArgsConstructor
class ChambreServiceImpl implements IChambreService{
    ChambreRepository chambreRepository;

    @Override
    public List<Chambre> retrieveAllChambres() {
        return chambreRepository.findAll();
    }

    @Override
    public Chambre addChambre(Chambre c) {
        return chambreRepository.save(c);
    }


    @Override
    public Chambre retrieveChambre(Long idChambre) {
        return chambreRepository.findById(idChambre).orElse(null);
    }

    @Override
    public void removeChambre(Long idChambre) {
        chambreRepository.deleteById(idChambre);
    }

    @Override
    public Chambre modifyChambre(Chambre c) {
        return chambreRepository.save(c);
    }

    public List<Chambre> recupererChambreSelonTyp(TypeChambre tc) {
        return chambreRepository.findAllByTypeC(tc);
    }

    public Chambre trouverchambreselonetudiant(long cin) {
        return chambreRepository.trouverChselonEt(cin);
    }
}
