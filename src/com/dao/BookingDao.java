package com.dao;

import com.domain.Booking;
import com.domain.User;

import java.sql.Date;
import java.util.List;

public interface BookingDao {
    public void insertBookingByBooking(Booking booking);
    public List queryByBooking(Booking booking, int page);
    public void deleteByBookingId(int bookingId);
    public void updateByBooking(Booking booking);
}
