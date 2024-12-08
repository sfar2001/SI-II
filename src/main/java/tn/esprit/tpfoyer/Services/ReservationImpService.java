package tn.esprit.tpfoyer.Services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.Entity.Reservation;
import tn.esprit.tpfoyer.Repositories.ReservationRepository;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ReservationImpService implements IReservationService {

 ReservationRepository reservationRepository;



    // Autres méthodes de service
    @Override
    public List<Reservation> retrieveAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation addReservation(Reservation r) {
        return reservationRepository.save(r);
    }

    @Override
    public Reservation modifyReservation(Reservation r) {
        return reservationRepository.save(r);
    }

    @Override
    public Reservation retrieveReservation(String idReservation) {
        return reservationRepository.findById(Long.valueOf(idReservation)).orElse(null);
    }

    @Override
    public void removeReservation(String idReservation) {
        reservationRepository.deleteById(Long.valueOf(idReservation));
    }
    @Scheduled(fixedRate = 50000) // Exécution toutes les 50 secondes
    public void mettreAJourEtAfficherReservations() {
        Date seuil = new Date(123, 0, 1); // 01/01/2024 (année 123 = 2023+1900)
        List<Reservation> reservations = reservationRepository.findAll();

        // Mettre à jour les réservations
        for (Reservation reservation : reservations) {
            if (reservation.getAnneeUniversitaire().before(seuil)) {
                reservation.setEstValide(false); // Met à jour estValide à false
                reservationRepository.save(reservation); // Sauvegarde
            }
        }

        // Afficher toutes les réservations mises à jour
        log.info("Liste des réservations après mise à jour :");
        reservations.forEach(reservation -> log.info(reservation.toString()));
    }

}
