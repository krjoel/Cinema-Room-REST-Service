package cinema.domain;

import java.util.Map;
import java.util.Objects;

public class Seat {

    private int row;
    private int column;
    private int price;

    public Seat(SeatLocation seatLocation) {
        this(seatLocation.getRow(), seatLocation.getColumn());
    }

    public Seat(int row, int column) {
        this.row = row;
        this.column = column;
        setTicketPrice();
    }

    private void setTicketPrice() {
        if (row < 1 || row > 9) {
            price = 0;
            return;
        }
        if (column < 1 || column > 9) {
            price = 0;
            return;
        }

        if (row <= 4) {
            price = 10;
        } else {
            price = 8;
        }
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public int getPrice() {
        return price;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seat seat = (Seat) o;
        return getRow() == seat.getRow() && getColumn() == seat.getColumn();
    }
}
