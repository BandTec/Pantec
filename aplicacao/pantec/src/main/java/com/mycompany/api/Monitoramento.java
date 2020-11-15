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
    
    private Double porcentagemMemoriaRam = 0.0;
    private Double tamanhoDiscoUsado = 0.0;
    private Double espacoTotalDisco = 0.0;
    private Double porcentagemCpu = 0.0;
    private Double ramDisponivel = 0.0;
    private Double ramTotal = 0.0;
    private Double temperaturaCpu = 0.0;
    private final SystemInfo si = new SystemInfo();
    private final HardwareAbstractionLayer hard = si.getHardware();

    public Monitoramento() {
        ramDisponivel = (double) hard.getMemory().getAvailable();
        ramTotal = (double) hard.getMemory().getTotal();
        porcentagemMemoriaRam = ((ramTotal - ramDisponivel) * 100) / ramTotal;

        File[] disco = File.listRoots();
        double espacoHD =  disco[0].getFreeSpace() / 1073741824;
       
        espacoTotalDisco = (double) disco[0].getTotalSpace() / 1073741824;
        tamanhoDiscoUsado = (double) Math.round(((espacoTotalDisco - espacoHD) / espacoTotalDisco) * 100);
  
        temperaturaCpu = hard.getSensors().getCpuTemperature();
        
       long[] armazena = hard.getProcessor().getSystemCpuLoadTicks();
         Util.sleep(1000);
       porcentagemCpu = (hard.getProcessor().getSystemCpuLoadBetweenTicks(armazena)) * 100;

    }

    public Double getPorcentagemMemoriaRam() {
        return porcentagemMemoriaRam;
    }

    public Double getTamanhoDisco() {
        return tamanhoDiscoUsado;
    }

    public Double getPorcentagemCpu() {
        return porcentagemCpu;
    }

    public Double getRamDisponivel() {
        return ramDisponivel;
    }

    public Double getRamTotal() {
        return ramTotal;
    }

    public Double getTemperaturaCpu() {
        return temperaturaCpu;
    }

    
}
