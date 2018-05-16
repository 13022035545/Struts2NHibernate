package com.service;
import com.dao.BookingDao;
import com.dao.BookingDaolmpl;
import com.domain.Booking;

import java.util.*;

public class BookingServicelmpl implements BookingService {
    private BookingDao bookingDao = new BookingDaolmpl();
    @Override
    public void service(Booking booking) {
        bookingDao.insertBookingByBooking(booking);
    }

}
