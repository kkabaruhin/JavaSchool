package com.sbt.jscool;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection connection;
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:/C:/Users/кирилл/OneDrive/Java/JavaSchool homework/21)JDBC1/db");
            System.out.println("Соединение с СУБД выполнено");

            Statement statement = connection.createStatement();
            statement.execute("create table IF NOT EXISTS user(" +
                    "id integer primary key auto_increment, " +
                    "name varchar(100));");
            statement.execute("DELETE FROM user");

            statement.execute("insert into user(name) values('borya'),('petya')");

            ResultSet rs = statement.executeQuery("select * from user");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " : " + rs.getString("name"));
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }

    }
}
