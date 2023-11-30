package travelmanagement;

import java.sql.*;
public class Conn {

    Connection connection;
    Statement statement;
    Conn(){
        try{

            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/touristmanagement", "root", "ILoVeSnowMaN123");
            statement = connection.createStatement();

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
