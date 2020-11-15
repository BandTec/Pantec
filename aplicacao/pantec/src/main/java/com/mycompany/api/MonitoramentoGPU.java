/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.api;

import com.profesorfalken.jsensors.JSensors;
import com.profesorfalken.jsensors.model.components.Gpu;
import java.util.List;
import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OperatingSystem;

/**
 *
 * @author sakurah
 */
public class MonitoramentoGPU {
    
    
    private final Boolean possivelMedir;
    private Integer gpuSize;
    private Double temperaturaGPU;
    private final SystemInfo si = new SystemInfo();
    private final OperatingSystem so = si.getOperatingSystem();

    private final HardwareAbstractionLayer hard = si.getHardware();

    public MonitoramentoGPU() {

        if (so.getFamily().contains("Windows")) {
            
            List<Gpu>  gpus = JSensors.get.components().gpus;
         
       if (!gpus.isEmpty()) {
            possivelMedir = true;
            gpuSize = gpus.get(0).sensors.temperatures.size();
            temperaturaGPU = gpus.get(0).sensors.temperatures.get(gpuSize - 1).value;

        } else {
           
            //Placa dedicada
            possivelMedir = false;
        }
        }else{
             possivelMedir = false;
        }

    }

    public Integer getGpuSize() {
        return gpuSize;
    }

    public Double getTemperaturaGPU() {
        return temperaturaGPU;
    }

    public Boolean getPossivelMedir() {
        return possivelMedir;
    }
    
}
