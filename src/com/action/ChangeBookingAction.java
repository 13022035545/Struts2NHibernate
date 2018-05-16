package com.action;

import com.domain.Booking;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.BookingService;
import com.service.BookingServicelmpl;
import com.service.ChangeBookingService;

import java.sql.Date;
import java.util.Map;

public class ChangeBookingAction extends ActionSupport{
    private String name;
    private String from;
    private String to;
    private Date date;
    private BookingService bookingService = new ChangeBookingService();
    Map session = ActionContext.getContext().getSession();

    @Override
    public String execute() throws Exception {
        if (session.get("changeBooking") != null){
            Booking booking = (Booking) session.get("changeBooking");
            session.remove("changeBooking");
            this.setName(this.name);
            booking.setFrom(this.from);
            booking.setTo(this.to);
            booking.setDate(this.date);
            bookingService.service(booking);

            return SUCCESS;
        }else {
            addFieldError("changeBookingError", "修改失败");
            return INPUT;
        }
    }

    @Override
    public void validate() {
        if (name == null || name.equals("")){
            addFieldError("bookingError", "修改的姓名不能为空");
            return;
        }
        if (from == null || from.equals("")){
            addFieldError("bookingError", "修改的始发城市不能为空");
            return;
        }
        if (to == null || to.equals("")){
            addFieldError("bookingError", "修改的目的城市不能为空");
            return;
        }
        if (date == null || date.equals("")){
            addFieldError("bookingError", "修改的日期不能为空");
            return;
        }
    }

    public ChangeBookingAction() {
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
