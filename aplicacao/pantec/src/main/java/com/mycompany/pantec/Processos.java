/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pantec;

import com.mycompany.log.ControllerLog;
import com.mycompany.processos.DadosdoProcesso;
import com.mycompany.processos.TabelaProcesso;
import java.awt.Color;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Aluno
 */
public class Processos extends javax.swing.JFrame {
    ControllerLog log = new ControllerLog();
    TabelaProcesso tabela = new TabelaProcesso();
    DadosdoProcesso dados = new DadosdoProcesso();
    Integer idmaquina;
    Integer contador;

    /**
     * Creates new form Processos
     * @param id
     * @param cont
     */
    public Processos(Integer id, Integer cont) {
        initComponents();
        Thread threadDados = new Thread(this::atualizarDados);
        threadDados.start();
       idmaquina =id;
       contador = cont;
         if (contador == 0) {
            changeTheme(contador);
            ++contador;
        } else {
            changeTheme(contador);
            --contador;
        }
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
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnMatar = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableProcessos = new javax.swing.JTable();
        lblNome = new javax.swing.JLabel();
        btnFiltrar = new javax.swing.JButton();
        txtFiltro = new javax.swing.JTextField();
        btnSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 17, 60));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/escuro.PNG"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 70, 40));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(594, 170, 10, -1));

        btnMatar.setBackground(new java.awt.Color(223, 1, 28));
        btnMatar.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnMatar.setForeground(new java.awt.Color(255, 255, 255));
        btnMatar.setText("MATAR PROCESSOS"); // NOI18N
        btnMatar.setBorder(null);
        btnMatar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMatar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMatarActionPerformed(evt);
            }
        });
        jPanel1.add(btnMatar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 410, 160, 50));

        lblTitulo.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("PROCESSOS ATIVOS");
        jPanel1.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 590, 50));

        jTableProcessos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTableProcessos);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 590, 250));

        lblNome.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblNome.setForeground(new java.awt.Color(255, 255, 255));
        lblNome.setText("Nome:");
        jPanel1.add(lblNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 60, 20));

        btnFiltrar.setText("Filtrar");
        btnFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnFiltrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 120, 70, 20));
        jPanel1.add(txtFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 160, -1));

        btnSair.setBackground(new java.awt.Color(101, 134, 205));
        btnSair.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnSair.setForeground(new java.awt.Color(255, 255, 255));
        btnSair.setText("Voltar");
        btnSair.setBorder(null);
        btnSair.setContentAreaFilled(false);
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });
        jPanel1.add(btnSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 470, 160, 10));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 835, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 519, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 private void atualizarDados() {
        jTableProcessos.setModel(dados.getModelo());

    }

    private void btnMatarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMatarActionPerformed
        // TODO add your handling code here:
        matarProcessos();
    }//GEN-LAST:event_btnMatarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (contador == 0) {
            changeTheme(contador);
            ++contador;
        } else {
            changeTheme(contador);
            --contador;
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarActionPerformed
        // TODO add your handling code here:
        filtrar();
    }//GEN-LAST:event_btnFiltrarActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        // TODO add your handling code here:
        new Graficos(idmaquina, contador).setVisible(true);
        dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void matarProcessos() {
        Boolean checked;
        String id;
        Integer contadorProcesso = 0;

        for (int i = 0; i < jTableProcessos.getRowCount(); i++) {
            checked = Boolean.valueOf(jTableProcessos.getValueAt(i, 0).toString());
            id = jTableProcessos.getValueAt(i, 2).toString();

            //DISPLAY
            if (checked) {

                try {
                 
                    tabela.kill(id);
                    jTableProcessos.setValueAt("Encerrado", i, 1);
                    contadorProcesso++;
                } catch (IOException ex) {
                    Logger.getLogger(Processos.class.getName()).log(Level.SEVERE, null, ex);
                    log.printarLog("Erro: "+ex, Level.SEVERE.toString());
                }

            }

        }

        switch (contadorProcesso) {
            case 0:
                JOptionPane.showMessageDialog(null, "Escolha os processos para serem encerrados!");
                break;
            case 1:
                JOptionPane.showMessageDialog(null, "Processo encerrado com sucesso!");
                break;
            default:
                JOptionPane.showMessageDialog(null, contadorProcesso + " processos encerrados com sucesso!");
                break;
        }
        DadosdoProcesso dados = new DadosdoProcesso();
        jTableProcessos.setModel(dados.getModelo());
        
        filtrar();
    }

    private void filtrar() {
        TableRowSorter sorter = null;
        DefaultTableModel model = (DefaultTableModel) jTableProcessos.getModel();
        sorter = new TableRowSorter<TableModel>(model);
        jTableProcessos.setRowSorter(sorter);
        String text = txtFiltro.getText();
        if (text.length() == 0) {
            sorter.setRowFilter(null);
        } else {
            sorter.setRowFilter(RowFilter.regexFilter(text));
        }

    }


    private void changeTheme(Integer tema) {
        if (tema == 0) {
            jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/modoclaro.PNG")));
            jPanel1.setBackground(Color.white);
            lblTitulo.setForeground(Color.black);
            lblNome.setForeground(Color.black);
            btnSair.setForeground(Color.black);
        } else {
            jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/escuro.PNG")));
            jPanel1.setBackground(Color.decode("#00113C"));
            lblTitulo.setForeground(Color.white);
            lblNome.setForeground(Color.white);
            btnSair.setForeground(Color.white);
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
            java.util.logging.Logger.getLogger(Processos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Processos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Processos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Processos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JButton btnMatar;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableProcessos;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtFiltro;
    // End of variables declaration//GEN-END:variables
}
