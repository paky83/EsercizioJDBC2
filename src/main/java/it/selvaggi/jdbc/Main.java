package it.selvaggi.jdbc;

import java.sql.*;

public class Main {

    public static void main(String[] args) {

        // create a new connection from MyJdbcUtil
        try (Connection conn = MyJdbcUtil.getConnection()) {
            System.out.println(String.format("Connected to database %s " + "successfully.", conn.getCatalog()));
            System.out.println();

            Statement stmt  = conn.createStatement();
            String sqlCreate = "CREATE TABLE students ( student_id int(10) PRIMARY KEY NOT NULL AUTO_INCREMENT," +
                    "last_name varchar(30), first_name varchar(30));";
            stmt.executeUpdate(sqlCreate);

            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO students (first_name, last_name) VALUES(?,?);");
            pstmt.setString(1,"Paky");
            pstmt.setString(2, "Selva");
            pstmt.executeUpdate();

            pstmt.setString(1,"Mario");
            pstmt.setString(2, "Rossi");
            pstmt.executeUpdate();

            pstmt.setString(1,"Antonio");
            pstmt.setString(2, "Bianchi");
            pstmt.executeUpdate();

            pstmt.setString(1,"Giuseppe");
            pstmt.setString(2, "Verdi");
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

}

