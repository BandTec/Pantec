/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.processos;

import java.io.IOException;

/**
 *
 * @author sakurah
 */
public class TabelaProcesso {
    
      
    public void kill(String pid) throws IOException {
        String os = System.getProperty("os.name");

        if (os.contains(("Windows"))) {
            Runtime.getRuntime().exec("taskkill  /PID " + pid);

        } else {
            Runtime.getRuntime().exec("kill -9 " + pid);

        }
    }

    
}
