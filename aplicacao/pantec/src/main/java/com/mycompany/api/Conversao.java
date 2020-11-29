/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.api;

import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author sakurah
 */
public class Conversao {
    
 
        
     public static List<String> dataHora(String dataHora) {

        List<String> dataHoraConvertida = new ArrayList();
        String data = dataHora.split("T")[0];
        String hora = dataHora.split("T")[1];
        String datas[] = data.split("-");
        String dataConvertida = String.format("%s/%s/%s", datas[2], datas[1], datas[0]);
        dataHoraConvertida.add(dataConvertida);
        String horas[] = hora.split(":");
        String horaConvertida = String.format("%s:%s", horas[0], horas[1]);
        dataHoraConvertida.add(horaConvertida);
        return dataHoraConvertida;
    }
    
}
