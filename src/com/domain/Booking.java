package com.domain;




import java.util.Date;
import java.util.Objects;

public class Booking {
    private int bookingId;
    private String name;
    private String from;
    private String to;
    private Date date;
    private User user;

    public Booking() {
        this.name = null;
        this.from = null;
        this.to = null;
        this.date = null;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) { this.date = date; }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return bookingId == booking.bookingId &&
                Objects.equals(name, booking.name) &&
                Objects.equals(from, booking.from) &&
                Objects.equals(to, booking.to) &&
                Objects.equals(date, booking.date);
    }

    @Override
    public int hashCode() {

        return Objects.hash(bookingId, name, from, to, date);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Booking(int bookingId, String name, String from, String to, Date date){
        this.bookingId = bookingId;
        this.name = name;
        this.from = from;
        this.to = to;
        this.date = date;
    }
}
