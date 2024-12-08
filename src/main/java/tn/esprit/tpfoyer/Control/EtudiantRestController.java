package tn.esprit.tpfoyer.Control;




import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import tn.esprit.tpfoyer.Entity.Etudiant;
import tn.esprit.tpfoyer.Entity.Reservation;
import tn.esprit.tpfoyer.Services.IEtudiantService;

import java.util.List;
import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("/etudiant")


public class EtudiantRestController {


    IEtudiantService etudiantService;
    // http://localhost:8089/tpfoyer/etudiant/retrieve-all-etudiants
    @GetMapping("/retrieve-all-etudiants")
    public List<Etudiant> getEtudiants() {
        List<Etudiant> listEtudiants = etudiantService.retrieveAllEtudiants();
        return listEtudiants;
    }
    // http://localhost:8089/tpfoyer/etudiant/retrieve-etudiant/8
    @GetMapping("/retrieve-etudiant/{etudiant-id}")
    public Etudiant retrieveEtudiant(@PathVariable("etudiant-id") Long idEtudiant) {
        Etudiant etudiant = etudiantService.retrieveEtudiant(idEtudiant);
        return etudiant;
    }

    @PostMapping("/add-etudiant")
    public Etudiant addEtudiant(@RequestBody Etudiant e) {
        Etudiant etudiant = etudiantService.addEtudiant(e);
        return etudiant;
    }
    // http://localhost:8089/tpfoyer/etudiant/remove-etudiant/{etudiant-id}
    @DeleteMapping("/remove-etudiant/{etudiant-id}")
    public void removeEtudiant(@PathVariable("etudiant-id") Long idEtudiant) {
        etudiantService.removeEtudiant(idEtudiant);
    }
    // http://localhost:8089/tpfoyer/etudiant/modify-etudiant
    @PutMapping("/modify-etudiant")
    public Etudiant modifyEtudiant(@RequestBody Etudiant e) {
        Etudiant etudiant = etudiantService.modifyEtudiant(e);
        return etudiant;
    }
    @GetMapping("/retrieve-etudiant-reservations/{cin}")
    public Set<Reservation> getReservationsByCin(@PathVariable("cin") Long cin) {
        Etudiant etudiant = etudiantService.getEtudiantWithReservationsByCin(cin);
        if (etudiant != null) {
            return etudiant.getReservations();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Etudiant not found with CIN: " + cin);
        }
    }
}


