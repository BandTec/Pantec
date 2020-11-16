/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.api;

import java.io.File;
import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.util.Util;

/**
 *
 * @author sakurah
 */
public class Monitoramento {
    
    private Double porcMemRam = 0.0;
    private Double tamanhoDiscoUsado = 0.0;
    private Double espacoTotalDisco = 0.0;
    private Double porcCpu = 0.0;
    private Double ramDisponivel = 0.0;
    private Double ramTotal = 0.0;
    private Double tempCpu = 0.0;
    private final SystemInfo si = new SystemInfo();
    private final HardwareAbstractionLayer hardware = si.getHardware();

    public Monitoramento() {
        ramDisponivel = (double) hardware.getMemory().getAvailable();
        ramTotal = (double) hardware.getMemory().getTotal();
        porcMemRam = ((ramTotal - ramDisponivel) * 100) / ramTotal;

        File[] disco = File.listRoots();
        double espacoHD =  disco[0].getFreeSpace() / 1073741824;
       
        espacoTotalDisco = (double) disco[0].getTotalSpace() / 1073741824;
        tamanhoDiscoUsado = (double) Math.round(((espacoTotalDisco - espacoHD) / espacoTotalDisco) * 100);
  
        tempCpu = hardware.getSensors().getCpuTemperature();
        
       long[] armazena = hardware.getProcessor().getSystemCpuLoadTicks();
         Util.sleep(1000);
       porcCpu = (hardware.getProcessor().getSystemCpuLoadBetweenTicks(armazena)) * 100;

    }

    public Double getPorcMemRam() {
        return porcMemRam;
    }

    public Double getTamanhoDiscoUsado() {
        return tamanhoDiscoUsado;
    }

    public Double getPorcCpu() {
        return porcCpu;
    }

    public Double getRamDisponivel() {
        return ramDisponivel;
    }

    public Double getRamTotal() {
        return ramTotal;
    }

    public Double getTempCpu() {
        return tempCpu;
    }

 

    
}
