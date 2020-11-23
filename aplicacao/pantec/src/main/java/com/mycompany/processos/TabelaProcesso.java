/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.processos;

import com.mycompany.log.ControllerLog;
import java.io.IOException;

/**
 *
 * @author sakurah
 */
public class TabelaProcesso {
    ControllerLog log = new ControllerLog();
      
    public void kill(String pid) throws IOException {
        String os = System.getProperty("os.name");

        if (os.contains(("Windows"))) {
            Runtime.getRuntime().exec("taskkill  /PID " + pid);
            log.printarLog("Sistema Windows conectado", "Instalação");
            
        } else {
            Runtime.getRuntime().exec("kill -9 " + pid);
            log.printarLog("Sistema Linux conectado", "Instalação");

        }
    }

    
}
