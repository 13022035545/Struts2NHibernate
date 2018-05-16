package com.dao;


import com.common.HibernateSessionFactory;
import com.domain.Booking;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;


public class BookingDaolmpl implements BookingDao {
    @Override
    public void insertBookingByBooking(Booking booking) {
        Session session = null;

        try{
            session = HibernateSessionFactory.getSession();
            Transaction transaction = session.beginTransaction();

            session.save(booking);

            transaction.commit();
            session.close();

        }catch (Exception e){
            session.close();
            e.printStackTrace();
            System.out.println("插入预订信息失败");
        }
    }

    @Override
    public List queryByBooking(Booking booking, int page) {
        Session session = null;

        try{
            session = HibernateSessionFactory.getSession();
            String startTime;
            String endTime;
            DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date1 = dateFormat1.parse("2000-01-01");
            DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date2 = dateFormat1.parse("2050-01-01");
            Date sqlDate1 = new Date(date1.getTime());
            Date sqlDate2 = new Date(date2.getTime());

            System.out.println(booking.getDate());
            if (booking.getDate() == null){
                startTime = new SimpleDateFormat("yyyy-MM-dd").format(sqlDate1);
                endTime = new SimpleDateFormat("yyyy-MM-dd").format(sqlDate2);
            }else{
                startTime = new SimpleDateFormat().format(booking.getDate());
                endTime = startTime;
            }

            Transaction transaction = session.beginTransaction();

            String hql = "from Booking as b where b.user.userId = ? and b.name like ? and b.from like ?" +
                    " and b.to like ? and b.date between '"+startTime+"' and '"+endTime+"' order by b.bookingId desc";
            Query query = session.createQuery(hql);

            if (booking.getName() != null) query.setParameter(1, "%" + booking.getName() + "%");
            else query.setParameter(1, "%%");

            if (booking.getFrom() != null) query.setParameter(2, "%" + booking.getFrom() + "%");
            else query.setParameter(2, "%%");

            if (booking.getTo() != null) query.setParameter(3, "%" + booking.getTo() + "%");
            else query.setParameter(3, "%%");


            query.setParameter(0, booking.getUser().getUserId());

            page = page * 5;
            query.setFirstResult(page);
            query.setMaxResults(5);

            List<Booking> list = query.list();
            transaction.commit();
            session.close();

            return list;
        }catch (Exception e){
            session.close();
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void deleteByBookingId(int bookingId) {
        Session session = null;
        String hql = "delete from Booking as b where b.bookingId = ?";

        try{
            session = HibernateSessionFactory.getSession();
            Transaction transaction = session.beginTransaction();

            Query query = session.createQuery(hql);
            query.setParameter(0, bookingId);
            int sure = query.executeUpdate();

            if (sure == 1) System.out.println("删除成功");
            else System.out.println("删除失败");

            transaction.commit();
            session.close();

        }catch (Exception e){
            session.close();
            e.printStackTrace();
            System.out.println("删除失败");
        }
    }

    @Override
    public void updateByBooking(Booking booking) {
        Session session = null;

        try{
            session = HibernateSessionFactory.getSession();
            Transaction transaction = session.beginTransaction();

            session.update(booking);

            transaction.commit();
            session.close();

        }catch (Exception e){
            session.close();
            e.printStackTrace();
            System.out.println("更新预订信息失败");
        }
    }
}
