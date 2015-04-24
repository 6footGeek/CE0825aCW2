package com.barlow.andy.db;
import java.sql.Connection;
import java.sql.DriverManager;


/**
 * Created by andy on 4/8/2015.
 *
 *          Simple ConnectionUtil class for connecting to the db (SQLite) with auth.
 */


public class ConnectionUtil {
    public static Connection getConnection() {
        Connection c = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("DB opened succesfully");
        return c;
    }
}