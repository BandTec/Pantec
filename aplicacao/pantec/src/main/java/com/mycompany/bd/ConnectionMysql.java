/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author sakurah
 */
public class ConnectionMysql {
    private BasicDataSource dataSource;
    public ConnectionMysql() { 
        this.dataSource = new BasicDataSource(); 
        this.dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver"); 
        this.dataSource.setUrl("jdbc:mysql://localhost:3306/pantec?useSSL=false"); 
        this.dataSource.setUsername("root"); 
        this.dataSource.setPassword("bandtec"); 
    } public BasicDataSource getDataSource() { 
        System.out.println("Conectado com sucesso");
        return dataSource; 
    } 
}
