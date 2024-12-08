package tn.esprit.tpfoyer.Services;

import tn.esprit.tpfoyer.Entity.Chambre;
import tn.esprit.tpfoyer.Entity.TypeChambre;

import java.util.List;

public interface IChambreService {
    public List<Chambre> retrieveAllChambres();
    public  Chambre addChambre(Chambre c);

    public Chambre retrieveChambre(Long idChambre);
    public void removeChambre(Long idChambre);

    Chambre modifyChambre(Chambre c);

    List<Chambre> recupererChambreSelonTyp(TypeChambre tc);

    Chambre trouverchambreselonetudiant(long cin);
}

