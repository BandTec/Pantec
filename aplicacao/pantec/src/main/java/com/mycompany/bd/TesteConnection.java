/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bd;

import com.mycompany.api.MonitoramentoHardware;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author sakurah
 */
public class TesteConnection {

    private List<Map<String, Object>> resultado;
    MonitoramentoHardware hard = new MonitoramentoHardware();

    Connection config = new Connection();
    JdbcTemplate con = new JdbcTemplate(config.getDatasource());

    public Boolean verificarLogin(String login, String senha) {

        String selectUser = "select id from usuario where email='" + login + "' and senha='" + senha + "'";
        resultado = con.queryForList(selectUser);
          
        return resultado.isEmpty();
        
        
    }
 
    
    public void cadastrarMaquina(){
//        String insertMaquina = "insert into Maquina values (?,?);";
//        
//        
//         con.update(insertMaquina,hard.getUser(),id);

    
      
      

}

}
