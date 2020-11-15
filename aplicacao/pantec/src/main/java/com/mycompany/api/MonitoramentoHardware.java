/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.api;

import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OperatingSystem;

/**
 *
 * @author sakurah
 */
public class MonitoramentoHardware {
    
    
    private final String infoMemoria;
    private final String infoCpu;
    private final String infoGpu;
    private final String infoDisco;
    private final String infoSO;
    private final String user;
    private final String fabricante;
    private final String modelo;
    private final SystemInfo si = new SystemInfo();
    private final HardwareAbstractionLayer hard = si.getHardware();
    private final OperatingSystem so = si.getOperatingSystem();

    public MonitoramentoHardware() {
        infoMemoria = hard.getMemory().toString();
        infoCpu = hard.getProcessor().toString().split("\n")[0];
        infoGpu = hard.getGraphicsCards().toString().split(",")[0];
        infoDisco = si.getHardware().getDiskStores().toString().replace("[\\\\.\\PHYSICALDRIVE0:", "").split("-")[0];
        infoSO = so.getFamily();
        user = so.getNetworkParams().getHostName();
        fabricante = hard.getComputerSystem().getManufacturer();
        modelo = hard.getComputerSystem().getModel();

    }

    public String getInfoMemoria() {
        return infoMemoria;
    }

    public String getInfoCpu() {
        return infoCpu;
    }

    public String getInfoGpu() {
        return infoGpu;
    }

    public String getInfoDisco() {
        return infoDisco;
    }

    public String getInfoSO() {
        return infoSO;
    }

    public String getUser() {
        return user;
    }

    public String getFabricante() {
        return fabricante;
    }

    public String getModelo() {
        return modelo;
    }

    
}
