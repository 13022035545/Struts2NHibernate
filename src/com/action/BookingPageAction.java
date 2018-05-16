package com.action;

import com.dao.BookingDao;
import com.dao.BookingDaolmpl;
import com.domain.Booking;
import com.domain.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


import java.awt.print.Book;
import java.sql.Date;
import java.util.List;
import java.util.Map;

public class BookingPageAction extends ActionSupport {

    private String name;
    private String from;
    private String to;
    private Date date;
    private int which;
    private BookingDao bookingDao = new BookingDaolmpl();
    private Map session = ActionContext.getContext().getSession();

    public String queryBooking(){
        User user;
        user = (User)session.get("user");
        Booking booking = new Booking();
        booking.setUser(user);
        booking.setName(this.name);
        booking.setFrom(this.from);
        booking.setTo(this.to);
        booking.setDate(this.date);

        session.put("booking", booking);
        return SUCCESS;

    }

    public String firstPage(){
        Booking booking = this.initBooking();

        List<Booking> bookings = bookingDao.queryByBooking(booking, 0);
        session.put("bookings", bookings);
        session.put("firstPage", true);
        session.put("page", 0);
        if (bookings.size() < 5){
            session.put("lastPage", true);
        }else{
            session.put("lastPage", false);
        }

        return SUCCESS;
    }

    public String nextPage(){
        Booking booking = this.initBooking();
        int page = (int)session.get("page");

        List<Booking> bookings = bookingDao.queryByBooking(booking, page + 1);
        session.put("bookings", bookings);
        session.put("firstPage", false);
        session.put("page", page + 1);
        if (bookings.size() < 5){
            session.put("lastPage", true);
        }else{
            session.put("lastPage", false);
        }


        return SUCCESS;
    }

    public String formPage(){
        Booking booking = this.initBooking();
        int page = (int)session.get("page");

        List<Booking> bookings = bookingDao.queryByBooking(booking,page - 1);
        session.put("bookings", bookings);
        session.put("lastPage", false);
        session.put("page", page - 1);
        if(page - 1 == 0){
            session.put("firstPage", true);
        }else{
            session.put("firstPage", false);
        }

        return SUCCESS;
    }

    public String nowPage(){
        Booking booking = this.initBooking();
        int page = (int)session.get("page");

        List<Booking> bookings = bookingDao.queryByBooking(booking,page);
        session.put("bookings", bookings);

        return SUCCESS;
    }

    public String deleteBooking(){
        List<Booking> list = (List)session.get("bookings");
        Booking booking = list.get(which);
        list.remove(which);
        bookingDao.deleteByBookingId(booking.getBookingId());


        if (which < 5) list.remove(which);
        else addFieldError("deleteError", "删除失败");

        session.put("bookings", list);
        return SUCCESS;
    }

    public String changeBooking(){
        List<Booking> list = (List)session.get("bookings");
        Booking booking = list.get(which);
        session.put("changeBooking", booking);
        return SUCCESS;
    }

    private Booking initBooking(){
        User user;
        user = (User)session.get("user");
        Booking booking = (Booking)session.get("booking");
        if (booking == null){
            booking = new Booking();
            booking.setUser(user);
            booking.setName(null);
            booking.setTo(null);
            booking.setFrom(null);
            booking.setDate(null);
            session.put("booking", booking);
        }

        return booking;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public int getWhich() {
        return which;
    }

    public void setWhich(int which) {
        this.which = which;
    }

    public BookingPageAction() {
    }
}
