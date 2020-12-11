/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bd;

//import com.mycompany.log.ControllerLog;
import com.mycompany.log.ControllerLog;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sakurah
 */
public class ConnectionAzure {
    public static java.sql.Connection getConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
             ControllerLog log= new ControllerLog();
            log.printarLog("Conexão feita com sucesso", "Instalação");
            return DriverManager.getConnection("jdbc:sqlserver://svrpantec.database.windows.net:1433;"
                        + "database=pantec;"
                        + "user=adminlocal@svrpantec;"
                        + "password=#Pantec123;"
                        + "encrypt=true;"
                        + "trustServerCertificate=false;"
                        + "loginTimeout=30;");
        } catch (ClassNotFoundException | SQLException ex) {
            ControllerLog log= new ControllerLog();
            log.printarLog("Erro na conexão", "Erro");
            throw new RuntimeException("Erro na conexão: ", ex);
        }
    }
    
    
    public static void closeConnection(java.sql.Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionAzure.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void closeConnection(java.sql.Connection con, PreparedStatement stmt) {

        closeConnection(con);

        try {

            if (stmt != null) {
                stmt.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConnectionAzure.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void closeConnection(java.sql.Connection con, PreparedStatement stmt, ResultSet rs) {

        closeConnection(con, stmt);

        try {

            if (rs != null) {
                rs.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConnectionAzure.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}
