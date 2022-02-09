package cinema.domain;

import java.util.*;

public class Cinema {

    private int totalRows;
    private int totalColumns;
    private List<Seat> availableSeats = new ArrayList<>(81);
    //private List<Seat> purchasedSeats = new ArrayList<>(81);
    private Map<UUID, Ticket> purchasedTickets = new HashMap<>();

    public Cinema (int totalRows, int totalColumns) {
        this.totalRows = totalRows;
        this.totalColumns = totalColumns;
        initAvailableSeats();
    }

    private void initAvailableSeats () {
        for (int row = 1; row <= 9; row++) {
            for (int column = 1; column <= 9; column++) {
                availableSeats.add(new Seat(row, column));
            }
        }
    }

    private void reserveSeat(UUID ticketID, Seat seat) {

    }

    /*
    private Ticket createTicket(Seat seat) {
        int price;

        if (seat.getRow() <= 4) {
            price = 8;
        } else {
            price = 10;
        }
        return new Ticket(price, seat);
    }
     */

    public boolean isSeatValid(Seat seat) {
        if (seat.getRow() < 1 || seat.getRow() > 9) {
           return false;
        }
        if (seat.getColumn() < 1 || seat.getColumn() > 9) {
           return false;
        }
        return true;
    }

    public boolean isSeatAvailable(Seat seat) {
        return availableSeats.contains(seat);
    }

    public Ticket purchaseTicket(Seat seat) {
        UUID ticketID = UUID.randomUUID();
        availableSeats.remove(seat);
        Ticket ticket = new Ticket(seat, ticketID);
        purchasedTickets.put(ticketID, ticket);
        return ticket;
    }

    public boolean isTicketSold(UUID ticketID) {
        return purchasedTickets.containsKey(ticketID);
    }

    public Seat returnTicket(UUID ticketID) {
        return purchasedTickets.remove(ticketID).getTicket();
    }

    public int getTotalRows() {
        return totalRows;
    }

    public int getTotalColumns() {
        return totalColumns;
    }

    public List<Seat> getAvailableSeats() {
        return availableSeats;
    }
}
