/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pantec;

import com.mycompany.api.Conversao;
import com.mycompany.api.Monitoramento;
import com.mycompany.api.MonitoramentoGPU;
import com.mycompany.api.MonitoramentoHardware;
import java.awt.Color;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
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
 * @author Aluno
 */
public class Graficos extends javax.swing.JFrame {
     MonitoramentoHardware hardware = new MonitoramentoHardware();


    /**
     * Creates new form Graficos
     */
    tentativa monitorar= new tentativa();
    public Graficos() {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Graficos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Graficos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Graficos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Graficos.class.getName()).log(Level.SEVERE, null, ex);
        }
        initComponents();
        
        
        lblInfoCPU.setText(hardware.getInfoCpu());
        lblInfoDisco.setText(hardware.getInfoDisco() + ")");
        lblInfoMemoria.setText(hardware.getInfoMemoria());
        lblInfoGPU.setText(hardware.getInfoGpu() + "]]");
        lblSO.setText("Sistema Operacional: " + hardware.getInfoSO());
        lblModelo.setText("Modelo: " + hardware.getModelo());
        lblFabricante.setText("Fabricante: " + hardware.getFabricante());
        MonitoramentoGPU gpu = new MonitoramentoGPU();
        pgbGpuTemperatura.setVisible(gpu.getPossivelMedir());
        lblPlacaDeVideo.setVisible(gpu.getPossivelMedir());
        lblInfoGPU.setVisible(gpu.getPossivelMedir());

        Thread threadDataHora = new Thread(this::atualizarHora);
        threadDataHora.start();

        Thread threadBarra = new Thread(this::atualizarBarraProgreco);
        threadBarra.start();

        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pgbCpuTemperatura = new javax.swing.JProgressBar();
        btnProcessos = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        btnModoClaro = new javax.swing.JButton();
        lblCpu = new javax.swing.JLabel();
        pgbCpu = new javax.swing.JProgressBar();
        pgbDisco = new javax.swing.JProgressBar();
        pgbGpuTemperatura = new javax.swing.JProgressBar();
        lblDisco = new javax.swing.JLabel();
        lblMemoria = new javax.swing.JLabel();
        lblPlacaDeVideo = new javax.swing.JLabel();
        pgbMemoria = new javax.swing.JProgressBar();
        lblTemperaturaCpu = new javax.swing.JLabel();
        lblFabricante = new javax.swing.JLabel();
        lblSO = new javax.swing.JLabel();
        lblModelo = new javax.swing.JLabel();
        lblData = new javax.swing.JLabel();
        lblHora = new javax.swing.JLabel();
        lblInfoCPU = new javax.swing.JLabel();
        lblInfoDisco = new javax.swing.JLabel();
        lblInfoMemoria = new javax.swing.JLabel();
        lblInfoGPU = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 17, 60));

        jPanel1.setBackground(new java.awt.Color(0, 17, 60));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pgbCpuTemperatura.setForeground(new java.awt.Color(109, 144, 174));
        pgbCpuTemperatura.setString("0°C");
        pgbCpuTemperatura.setStringPainted(true);
        jPanel1.add(pgbCpuTemperatura, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 690, 25));

        btnProcessos.setBackground(new java.awt.Color(109, 144, 174));
        btnProcessos.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnProcessos.setText("PROCESSOS");
        btnProcessos.setBorderPainted(false);
        btnProcessos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcessosActionPerformed(evt);
            }
        });
        jPanel1.add(btnProcessos, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 480, 160, 50));

        btnExit.setBackground(new java.awt.Color(109, 144, 174));
        btnExit.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnExit.setText("SAIR");
        btnExit.setBorderPainted(false);
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        jPanel1.add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 480, 160, 50));

        btnModoClaro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/escuro.PNG"))); // NOI18N
        btnModoClaro.setBorderPainted(false);
        btnModoClaro.setContentAreaFilled(false);
        btnModoClaro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModoClaroActionPerformed(evt);
            }
        });
        jPanel1.add(btnModoClaro, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 70, 40));

        lblCpu.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        lblCpu.setForeground(new java.awt.Color(255, 255, 255));
        lblCpu.setText("CPU:");
        jPanel1.add(lblCpu, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 60, -1));

        pgbCpu.setForeground(new java.awt.Color(109, 144, 174));
        pgbCpu.setToolTipText("");
        pgbCpu.setStringPainted(true);
        jPanel1.add(pgbCpu, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 690, 25));

        pgbDisco.setForeground(new java.awt.Color(109, 144, 174));
        pgbDisco.setStringPainted(true);
        jPanel1.add(pgbDisco, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 690, 25));

        pgbGpuTemperatura.setForeground(new java.awt.Color(109, 144, 174));
        pgbGpuTemperatura.setString("0°C");
        pgbGpuTemperatura.setStringPainted(true);
        jPanel1.add(pgbGpuTemperatura, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 690, 25));

        lblDisco.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        lblDisco.setForeground(new java.awt.Color(255, 255, 255));
        lblDisco.setText("Disco:");
        jPanel1.add(lblDisco, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, -1, -1));

        lblMemoria.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        lblMemoria.setForeground(new java.awt.Color(255, 255, 255));
        lblMemoria.setText("Memória:");
        jPanel1.add(lblMemoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, -1));

        lblPlacaDeVideo.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        lblPlacaDeVideo.setForeground(new java.awt.Color(255, 255, 255));
        lblPlacaDeVideo.setText("Temperatura da GPU:");
        jPanel1.add(lblPlacaDeVideo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 270, -1));

        pgbMemoria.setForeground(new java.awt.Color(109, 144, 174));
        pgbMemoria.setStringPainted(true);
        jPanel1.add(pgbMemoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 690, 25));

        lblTemperaturaCpu.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        lblTemperaturaCpu.setForeground(new java.awt.Color(255, 255, 255));
        lblTemperaturaCpu.setText("Temperatura da CPU:");
        jPanel1.add(lblTemperaturaCpu, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 270, -1));

        lblFabricante.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblFabricante.setForeground(new java.awt.Color(255, 255, 255));
        lblFabricante.setText("Fabricante:");
        jPanel1.add(lblFabricante, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, 430, -1));

        lblSO.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblSO.setForeground(new java.awt.Color(255, 255, 255));
        lblSO.setText("Sistema Operacional:");
        jPanel1.add(lblSO, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 430, -1));

        lblModelo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblModelo.setForeground(new java.awt.Color(255, 255, 255));
        lblModelo.setText("Modelo:");
        jPanel1.add(lblModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, 430, -1));

        lblData.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblData.setForeground(new java.awt.Color(255, 255, 255));
        lblData.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel1.add(lblData, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 20, 80, 20));

        lblHora.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblHora.setForeground(new java.awt.Color(255, 255, 255));
        lblHora.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel1.add(lblHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 20, 50, 20));

        lblInfoCPU.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblInfoCPU.setForeground(new java.awt.Color(255, 255, 255));
        lblInfoCPU.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel1.add(lblInfoCPU, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 80, 270, 10));

        lblInfoDisco.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblInfoDisco.setForeground(new java.awt.Color(255, 255, 255));
        lblInfoDisco.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel1.add(lblInfoDisco, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 140, 430, 20));

        lblInfoMemoria.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblInfoMemoria.setForeground(new java.awt.Color(255, 255, 255));
        lblInfoMemoria.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel1.add(lblInfoMemoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 200, 250, 10));

        lblInfoGPU.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblInfoGPU.setForeground(new java.awt.Color(255, 255, 255));
        lblInfoGPU.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel1.add(lblInfoGPU, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 320, 410, 10));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 781, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private Integer contador = 0;
    private void changeTheme(Integer tema) {
          if (tema == 0) {
            jPanel1.setBackground(Color.white);
            lblCpu.setForeground(Color.black);
            lblTemperaturaCpu.setForeground(Color.black);
            lblDisco.setForeground(Color.black);
            lblMemoria.setForeground(Color.black);
            lblPlacaDeVideo.setForeground(Color.black);
            lblInfoCPU.setForeground(Color.black);
            lblInfoDisco.setForeground(Color.black);
            lblInfoGPU.setForeground(Color.black);
            lblInfoMemoria.setForeground(Color.black);
            lblSO.setForeground(Color.black);
            lblFabricante.setForeground(Color.black);
            lblModelo.setForeground(Color.black);
            Color cor = new Color(0, 128, 128);
            btnExit.setBackground(cor);
            btnProcessos.setBackground(cor);
            pgbCpuTemperatura.setForeground(cor);
            pgbGpuTemperatura.setForeground(cor);
            pgbMemoria.setForeground(cor);
            btnModoClaro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/modoclaro.PNG")));
        } else {
            lblInfoCPU.setForeground(Color.white);
            lblInfoDisco.setForeground(Color.white);
            lblInfoGPU.setForeground(Color.white);
            lblInfoMemoria.setForeground(Color.white);
            jPanel1.setBackground(Color.decode("#00113C"));
            lblCpu.setForeground(Color.white);
            lblTemperaturaCpu.setForeground(Color.white);
            lblDisco.setForeground(Color.white);
            lblMemoria.setForeground(Color.white);
            lblPlacaDeVideo.setForeground(Color.white);
            lblSO.setForeground(Color.white);
            lblFabricante.setForeground(Color.white);
            lblModelo.setForeground(Color.white);
            btnExit.setBackground(Color.decode("#6D90AE"));
            btnProcessos.setBackground(Color.decode("#6D90AE"));
            pgbCpuTemperatura.setForeground(Color.decode("#6D90AE"));
            pgbGpuTemperatura.setForeground(Color.decode("#6D90AE"));
            pgbMemoria.setForeground(Color.decode("#6D90AE"));
            btnModoClaro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/escuro.PNG")));
        
        }
    }
    private void btnProcessosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcessosActionPerformed
        new Processos().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnProcessosActionPerformed

    private void btnModoClaroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModoClaroActionPerformed
        // TODO add your handling code here:
        if(contador == 0){
            changeTheme(contador);
            ++contador;
        }else{
            changeTheme(contador);
            --contador;
        }
        
    }//GEN-LAST:event_btnModoClaroActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        new Login().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    
    private void atualizarHora() {
        while (true) {
            List<String> dataHora = Conversao.dataHora(LocalDateTime.now().toString());
            lblData.setText(dataHora.get(0));
            lblHora.setText(dataHora.get(1));
        }
    }

    private void atualizarBarraProgreco() {
        while (true) {
              try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }

            Monitoramento inicio = new Monitoramento();
            pgbCpuTemperatura.setValue(inicio.getTempCpu().intValue());
            pgbCpuTemperatura.setString(String.format("%.1f °C", inicio.getTempCpu()));
            pgbDisco.setValue(inicio.getTamanhoDiscoUsado().intValue());
            pgbMemoria.setValue(inicio.getPorcMemRam().intValue());
            pgbCpu.setValue(inicio.getPorcCpu().intValue());

            MonitoramentoHardware hardwareMemoria = new MonitoramentoHardware();
            lblInfoMemoria.setText(hardwareMemoria.getInfoMemoria());

            MonitoramentoGPU gpu = new MonitoramentoGPU();
            if(gpu.getPossivelMedir()){
                     pgbGpuTemperatura.setValue(gpu.getTemperaturaGPU().intValue());
            }
       

          
        }

    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Graficos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Graficos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Graficos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Graficos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Graficos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnModoClaro;
    private javax.swing.JButton btnProcessos;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCpu;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblDisco;
    private javax.swing.JLabel lblFabricante;
    private javax.swing.JLabel lblHora;
    private javax.swing.JLabel lblInfoCPU;
    private javax.swing.JLabel lblInfoDisco;
    private javax.swing.JLabel lblInfoGPU;
    private javax.swing.JLabel lblInfoMemoria;
    private javax.swing.JLabel lblMemoria;
    private javax.swing.JLabel lblModelo;
    private javax.swing.JLabel lblPlacaDeVideo;
    private javax.swing.JLabel lblSO;
    private javax.swing.JLabel lblTemperaturaCpu;
    private javax.swing.JProgressBar pgbCpu;
    private javax.swing.JProgressBar pgbCpuTemperatura;
    private javax.swing.JProgressBar pgbDisco;
    private javax.swing.JProgressBar pgbGpuTemperatura;
    private javax.swing.JProgressBar pgbMemoria;
    // End of variables declaration//GEN-END:variables
}
