/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pantec;

import java.util.List;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.GlobalMemory;
import oshi.hardware.GraphicsCard;
import oshi.hardware.HWDiskStore;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OSProcess;
import oshi.software.os.OperatingSystem;

/**
 *
 * @author sarah
 */
public class tentativa {
    public static void main(String[] args) {
        SystemInfo si = new SystemInfo();
        HardwareAbstractionLayer hal;
        OperatingSystem os = si.getOperatingSystem();
        hal = si.getHardware();
        String modelo= hal.getComputerSystem().getModel();
        GlobalMemory memoria= si.getHardware().getMemory();
        List<HWDiskStore> HD=hal.getDiskStores();
        List<GraphicsCard> gpu=si.getHardware().getGraphicsCards();
        CentralProcessor cpu=si.getHardware().getProcessor();
        double temperatura= si.getHardware().getSensors().getCpuTemperature();
        List<OSProcess> proc=si.getOperatingSystem().getProcesses(10, OperatingSystem.ProcessSort.CPU);
        System.out.println("modelo: "+modelo);
        System.out.println("hd: "+HD);
        System.out.println("memoria "+memoria);
        System.out.println("dados gpu: "+gpu);
        System.out.println("cpu "+cpu);
        System.out.println("temperatura: "+temperatura);
        System.out.println("processos "+proc);
    }
}
