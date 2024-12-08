package tn.esprit.tpfoyer.Services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.Entity.Reservation;
import tn.esprit.tpfoyer.Repositories.ReservationRepository;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j // To handle logging
public class ReservationImpService implements IReservationService {

    private final ReservationRepository reservationRepository;

    // Other service methods
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
        try {
            return reservationRepository.findById(String.valueOf(Long.valueOf(idReservation))).orElse(null);
        } catch (NumberFormatException e) {
            log.error("Invalid reservation ID format: " + idReservation, e);
            return null;
        }
    }

    @Override
    public void removeReservation(String idReservation) {
        try {
            reservationRepository.deleteById(String.valueOf(Long.valueOf(idReservation)));
        } catch (NumberFormatException e) {
            log.error("Invalid reservation ID format: " + idReservation, e);
        }
    }

    @Scheduled(fixedRate = 50000) // Every 50 seconds
    public void mettreAJourEtAfficherReservations() {
        try {
            // Define the target date
            LocalDate targetDate = LocalDate.of(2024, 1, 1);
            Date targetDateConverted = Date.from(targetDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

            // Fetch reservations before the target date
            List<Reservation> reservations = reservationRepository.findByAnneeUniversitaireBefore(targetDateConverted);

            for (Reservation reservation : reservations) {
                // Update each reservation
                reservation.setEstValide(false);
                reservationRepository.save(reservation);

                // Log the updated reservation
                log.info("Reservation after update: {}", reservation);
            }
        } catch (Exception e) {
            log.error("Error while updating reservations", e);
        }
    }

    // creation d'une chambre et une reservation en mm temps

}
