/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bd;

import com.mycompany.api.Monitoramento;
import com.mycompany.api.MonitoramentoHardware;
import com.mycompany.log.ControllerLog;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sakurah
 */
public class Select {

    java.sql.Connection con = Connection.getConnection();
    Usuario user = new Usuario();
    Maquina maq = new Maquina();
    MonitoramentoHardware hard = new MonitoramentoHardware();
    Monitoramento monitoramento = new Monitoramento();
    PreparedStatement stmt = null;
    ResultSet rs = null;

    ControllerLog log = new ControllerLog();
    public boolean checkLogin(String login, String senha) {

        boolean check = false;

        try {

            stmt = con.prepareStatement("SELECT * FROM usuario WHERE email = ? and senha = ?", PreparedStatement.RETURN_GENERATED_KEYS);

            stmt.setString(1, login);
            stmt.setString(2, senha);

            rs = stmt.executeQuery();

            if (rs.next()) {

                user.setId(rs.getInt("id"));
                user.setEmail(rs.getString("email"));
                user.setSenha(rs.getString("senha"));
                user.setCliente_id(rs.getInt("cliente_id"));
                log.printarLog(String.format("Usuário %s conectado com sucesso", login), "Utilização");
                verificarMaquina();

                check = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(TesteConnection.class.getName()).log(Level.SEVERE, null, ex);
            log.printarLog(String.format("Erro ao se conectar %s", ex), "Utilização");
        } finally {
            Connection.closeConnection(con, stmt, rs);
        }

        return check;

    }

    public void verificarMaquina() throws SQLException {

        stmt = con.prepareStatement("SELECT * FROM maquina WHERE usuario_id = ? and hostname = ?", PreparedStatement.RETURN_GENERATED_KEYS);

        stmt.setInt(1, user.getId());
        stmt.setString(2, hard.getUser());

        rs = stmt.executeQuery();

        if (!rs.next()) {
            salvaMaquina();
        } else {

            maq.setId(rs.getInt("id"));
            maq.setHostname(rs.getString("hostname"));
            maq.setUsuario_id(rs.getInt("usuario_id"));
            
            System.out.println(maq.getId());

        }

    }

    public void salvaMaquina() {

        try {

            stmt = con.prepareStatement("INSERT INTO maquina (hostname, usuario_id)VALUES(?,?)");
            stmt.setString(1, hard.getUser());
            stmt.setInt(2, user.getId());

            stmt.executeUpdate();

            System.out.println("Máquina cadastrada com sucesso!");
            
            verificarMaquina();
            

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            Connection.closeConnection(con, stmt);
        }

    }
    
    
    public void insereRegistro(){
        
        
           try {
        
               
               System.out.println("Começou");
            stmt = con.prepareStatement("INSERT INTO registro (componente, momento,componente_id,maquina_id,medida_id)VALUES(?,?,?,?,?)");
           
            stmt.executeUpdate();

            

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            Connection.closeConnection(con, stmt);
        }
        
    }

}
