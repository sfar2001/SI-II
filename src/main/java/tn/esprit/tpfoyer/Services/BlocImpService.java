package tn.esprit.tpfoyer.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.Entity.Bloc;
import tn.esprit.tpfoyer.Repositories.BlocRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;


import java.util.List;

@Service
@Slf4j
@AllArgsConstructor

public class BlocImpService implements IBlocService{
    BlocRepository blocRepository;
    @Override
    @Scheduled(fixedRate = 60000)
    public List<Bloc> retrieveAllBlocs() {
        List<Bloc> lb= blocRepository.findAll();

        log.info("nbr blocs: " + lb.size());
        for(Bloc b: lb){
            log.info("bloc : " + b);
        }
        return lb;
    }


    @Override
    public Bloc addBloc(Bloc b) {
        return blocRepository.save(b);
    }

    @Override
    public Bloc modifyBloc(Bloc b) {
        return blocRepository.save(b);
    }

    @Override
    public Bloc retrieveBloc(Long idBloc) {
        return blocRepository.findById(idBloc).orElse(null);
    }

    @Override
    public void removeBloc(Long idBloc) {
        blocRepository.deleteById(idBloc);
    }
}