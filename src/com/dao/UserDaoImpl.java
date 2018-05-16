package com.dao;

import com.common.HibernateSessionFactory;
import com.domain.User;
import com.sun.org.apache.xml.internal.resolver.readers.ExtendedXMLCatalogReader;
import com.util.DBCon;
import jdk.jfr.events.ExceptionThrownEvent;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.jws.soap.SOAPBinding;
import java.sql.*;
import java.util.List;

public class UserDaoImpl implements UserDao{

    @Override
    public User findUserByUsername(String username){
            Session session = null;

            try{
                session = HibernateSessionFactory.getSession();
                String hql = "select u.userId, u.username, u.password from User as u " +
                        "where u.username = ?";

                Query query = session.createQuery(hql);
                query.setParameter(0, username);

                List list = query.list();
                if (list.size() == 0) {session.close(); return null;}
                else{
                    Object[] o = (Object[]) list.get(0);
                    User user = new User();
                    user.setUserId(Integer.parseInt(o[0].toString()));
                    user.setUsername(o[1].toString());
                    user.setPassword(o[2].toString());

                    session.close();
                    return user;
                }

            }catch (Exception e){
                //session.close();
                e.printStackTrace();
            }

            return null;
    }

    @Override
    public boolean signInUser(User user) {
        Session session  = null;

        try {
            session = HibernateSessionFactory.getSession();
            Transaction transaction = session.beginTransaction();
            int sure = 0;

            sure = (int)session.save(user);

            transaction.commit();
            session.close();

            if(sure != 0) return true;
            else return false;


        }catch (Exception e){
            session.close();
            e.printStackTrace();
            System.out.println("插入数据失败");
            return false;
        }
    }

    @Override
    public boolean updateUserPassword(User user) {
        Session session = null;

        try{
            session = HibernateSessionFactory.getSession();
            Transaction transaction = session.beginTransaction();

            session.update(user);

            transaction.commit();
            session.close();

            return true;
        }catch(Exception e){
            session.close();
            e.printStackTrace();
            return false;
        }
    }
}
