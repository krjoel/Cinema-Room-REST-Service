package cinema.controllers;

import cinema.domain.Cinema;
import cinema.domain.Seat;
import cinema.domain.SeatLocation;
import cinema.domain.Ticket;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;
import java.util.UUID;

@RestController
public class CinemaController {

    Cinema cinema = new Cinema(9, 9);

    @GetMapping("/seats")
    public Cinema getAvailableSeats() {
        return cinema;
    }

    /*
    @PostMapping("/purchase")
    public ResponseEntity purchaseTicket(@RequestBody SeatLocation seatLocation) {
        Seat seat = new Seat(seatLocation);
        if (!cinema.isSeatValid(seat)) {
            return new ResponseEntity(Map.of("error", "The number of a row or a column is out of bounds!"), HttpStatus.BAD_REQUEST);
        }
        if (!cinema.isSeatAvailable(seat)) {
            return new ResponseEntity(Map.of("error", "The ticket has been already purchased!"), HttpStatus.BAD_REQUEST);
        }

        Ticket ticket = cinema.purchaseTicket(seat);
        return new ResponseEntity(ticket, HttpStatus.OK);
    }

     */

    /*
    @PostMapping("/return")
    public ResponseEntity refundTicket(@RequestBody Map<String, String> token) {
        UUID returnToken;
        try {
            returnToken = UUID.fromString(token.get("token"));
        } catch (IllegalArgumentException i) {
            return new ResponseEntity(Map.of("error", "Wrong token!"), HttpStatus.BAD_REQUEST);
        }

        if (!cinema.isTicketSold(returnToken)) {
           return new ResponseEntity(Map.of("error", "Wrong token!"), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(Map.of("returned_ticket", cinema.returnTicket(returnToken)), HttpStatus.OK);
    }
     */
}
