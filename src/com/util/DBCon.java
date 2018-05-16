package com.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBCon {

    public static Connection connection;

    public static Connection getConn(){

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/planebooking_service?characterEncoding=utf-8",
                    "root", "12345");
        }catch (Exception e){
            e.printStackTrace();
        }

        return connection;
    }
}
