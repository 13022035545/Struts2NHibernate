package com.service;

import com.dao.BookingDao;
import com.dao.BookingDaolmpl;
import com.domain.Booking;

public class ChangeBookingService implements BookingService {
    BookingDao bookingDao = new BookingDaolmpl();
    @Override
    public void service(Booking booking) {
        bookingDao.updateByBooking(booking);
    }
}
