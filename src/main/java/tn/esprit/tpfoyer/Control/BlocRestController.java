package tn.esprit.tpfoyer.Control;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.Entity.Bloc;
import tn.esprit.tpfoyer.Services.IBlocService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/bloc")
public class BlocRestController {

    IBlocService blocService;

    // http://localhost:8089/tpfoyer/bloc/retrieve-all-blocs
    @GetMapping("/retrieve-all-blocs")
    public List<Bloc> getBlocs() {
        return blocService.retrieveAllBlocs();
    }

    // http://localhost:8089/tpfoyer/bloc/retrieve-bloc/8
    @GetMapping("/retrieve-bloc/{bloc-id}")
    public Bloc retrieveBloc(@PathVariable("bloc-id") Long idBloc) {
        return blocService.retrieveBloc(idBloc);
    }

    // http://localhost:8089/tpfoyer/bloc/add-bloc
    @PostMapping("/add-bloc")
    public Bloc addBloc(@RequestBody Bloc b) {
        return blocService.addBloc(b);
    }

    // http://localhost:8089/tpfoyer/bloc/remove-bloc/8
    @DeleteMapping("/remove-bloc/{bloc-id}")
    public void removeBloc(@PathVariable("bloc-id") Long idBloc) {
        blocService.removeBloc(idBloc);
    }


    // http://localhost:8089/tpfoyer/bloc/modify-bloc
    @PutMapping("/modify-bloc")
    public Bloc modifyBloc(@RequestBody Bloc c) {
        return blocService.modifyBloc(c);
    }
    // http://localhost:8089/tpfoyer/bloc/assign-bloc-to-foyer/{bloc-id}/{foyer-id}
    @PutMapping("/assign-bloc-to-foyer/{bloc-id}/{foyer-id}")
    public Bloc assignBlocToFoyer(@PathVariable("bloc-id") Long blocId, @PathVariable("foyer-id") Long foyerId) {
        return blocService.assignBlocToFoyer(blocId, foyerId);
    }

}