/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bd;

import com.mycompany.api.Monitoramento;
import com.mycompany.api.MonitoramentoHardware;
import com.mycompany.log.ControllerLog;
import com.mycompany.processos.DadosdoProcesso;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import oshi.SystemInfo;
import oshi.software.os.OSProcess;

/**
 *
 * @author sakurah
 */
public class Select {
    java.sql.Connection con = ConnectionAzure.getConnection();
    Usuario user = new Usuario();
    Maquina maq = new Maquina();
    MonitoramentoHardware hard = new MonitoramentoHardware();
    Monitoramento monitoramento = new Monitoramento();
    PreparedStatement stmt = null;
    ResultSet rs = null;
    Integer maquina = 0;
    SystemInfo si=new SystemInfo();
    List<OSProcess> process= si.getOperatingSystem().getProcesses();
    Integer proc=process.size();
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
            Logger.getLogger(Relatorio.class.getName()).log(Level.SEVERE, null, ex);
            log.printarLog(String.format("Erro ao se conectar %s", ex), "Utilização");
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
            
           maquina = maq.getId();

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
        }

    }
    
     public void insereGpu(Integer id, Double gpu){
        
        
           try {
        
               
            stmt = con.prepareStatement("INSERT INTO registro (componente,uso, momento,maquina_id, processos)VALUES(?,?,GETDATE(),?,?)");
            stmt.setInt(1, 4);
            stmt.setDouble(2, gpu);
            stmt.setInt(3, id);
            stmt.setInt(4, proc);

            stmt.executeUpdate();
     
    

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public void insereRegistro(Integer id, Double cpu, Double mem, Double disco, Double tempCpu){
        
        
           try {
               
            stmt = con.prepareStatement("INSERT INTO registro (componente,uso, momento,maquina_id, processos)VALUES(?,?,GETDATE(),?,?)");
            stmt.setInt(1, 1);
            stmt.setDouble(2, cpu);
            stmt.setInt(3, id);
            stmt.setInt(4, proc);

            stmt.executeUpdate();
            
                      
            stmt = con.prepareStatement("INSERT INTO registro (componente,uso, momento,maquina_id, processos)VALUES(?,?,GETDATE(),?,?)");
            stmt.setInt(1, 2);
            stmt.setDouble(2, disco);
            stmt.setInt(3, id);
            stmt.setInt(4, proc);


            stmt.executeUpdate();
            
                     
            stmt = con.prepareStatement("INSERT INTO registro (componente,uso, momento,maquina_id, processos)VALUES(?,?,GETDATE(),?,?)");
            stmt.setInt(1, 3);
            stmt.setDouble(2, mem);
            stmt.setInt(3, id);
            stmt.setInt(4, proc);


            stmt.executeUpdate();
            
            
            
            stmt = con.prepareStatement("INSERT INTO registro (componente,uso, momento,maquina_id, processos)VALUES(?,?,GETDATE(),?,?)");
            stmt.setInt(1, 5);
            stmt.setDouble(2, tempCpu);
            stmt.setInt(3, id);
            stmt.setInt(4, proc);


            stmt.executeUpdate();
            
            

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public Integer getMaquina() {
        return maquina;
    }
    
    
    

}
