package com.action;

import com.domain.Booking;
import com.domain.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.BookingService;
import com.service.BookingServicelmpl;

import java.sql.Date;
import java.util.List;

public class BookingAction extends ActionSupport {
    private String name;
    private String from;
    private String to;
    private Date date;
    private BookingService bookingService = new BookingServicelmpl();


    @Override
    public String execute() throws Exception {
        Booking booking = new Booking();
        booking.setName(name);
        booking.setFrom(from);
        booking.setTo(to);
        booking.setDate(date);
        booking.setUser((User)ActionContext.getContext().getSession().get("user"));

        bookingService.service(booking);

        return SUCCESS;
    }

    public BookingAction() {
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

    public void setDate(Date date) {
        this.date = date;
    }
}
