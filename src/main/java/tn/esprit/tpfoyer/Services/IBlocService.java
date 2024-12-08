package tn.esprit.tpfoyer.Services;

import tn.esprit.tpfoyer.Entity.Bloc;

import java.util.List;

public interface IBlocService {
    List<Bloc> retrieveAllBlocs();
    Bloc addBloc(Bloc b);
    Bloc modifyBloc(Bloc b);
    Bloc retrieveBloc(Long idBloc);
    void removeBloc(Long idBloc);
}

