package cinema.domain;

import java.util.UUID;

public class Ticket {
    private final UUID token;
    private Seat ticket;


    public Ticket(Seat seat, UUID token) {
        this.ticket = seat;
        this.token = token;
    }

    public UUID getToken() {
        return token;
    }

    public Seat getTicket() {
        return ticket;
    }
}
