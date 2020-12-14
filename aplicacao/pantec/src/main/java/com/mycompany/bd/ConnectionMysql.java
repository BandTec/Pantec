/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
// import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author sakurah
 */
public class ConnectionMysql {
    public static java.sql.Connection getConnectMysql() {
        Connection con = null;
        try {
            String driverName = "com.mysql.jdbc.Driver";
            Class.forName(driverName);
            try {
                String url = "jdbc:mysql://localhost:3306/pantec";
                String user = "root";
                String passwd = "urubu100";
                con = DriverManager.getConnection(url, user, passwd);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            } finally {
                try {
                    if (con != null) {
                        System.out.println("Conectado");
                        con.close();
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return con;
    }
}
// private BasicDataSource dataSource;
// public ConnectionMysql() {
// this.dataSource = new BasicDataSource();
// this.dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
// this.dataSource.setUrl("jdbc:mysql://localhost:3306/pantec?useSSL=false");
// this.dataSource.setUsername("root");
// this.dataSource.setPassword("bandtec");
// } public BasicDataSource getDataSource() {
// System.out.println("Conectado com sucesso");
// return dataSource;
