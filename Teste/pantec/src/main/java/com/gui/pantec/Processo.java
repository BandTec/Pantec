/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gui.pantec;

import com.processo.pantec.ProcessosModelo;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Aluno
 */
public class Processo extends javax.swing.JFrame {

    /**
     * Creates new form Processo
     */
 
    
    public Processo() {
        initComponents();
          ProcessosModelo tableModelo = new ProcessosModelo() {

       
            public boolean isCellEditable(int row, int column) {

                return column == 0;
            }

            
        };
        jTProcessos.setModel(tableModelo);
   
        jTProcessos.setAutoCreateRowSorter(true);
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTProcessos = new javax.swing.JTable();
        btnVoltar = new javax.swing.JButton();
        btnMatarProcessos = new javax.swing.JButton();
        txtBusca = new javax.swing.JTextField();
        btnFiltrar = new javax.swing.JButton();
        lblNome = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 17, 60));
        jPanel2.setRequestFocusEnabled(false);
        jPanel2.setVerifyInputWhenFocusTarget(false);

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("PROCESSOS ATIVOS");

        jTProcessos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTProcessos);

        btnVoltar.setBackground(new java.awt.Color(101, 134, 205));
        btnVoltar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnVoltar.setForeground(new java.awt.Color(255, 255, 255));
        btnVoltar.setText("Voltar");
        btnVoltar.setBorderPainted(false);
        btnVoltar.setContentAreaFilled(false);
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        btnMatarProcessos.setBackground(new java.awt.Color(255, 51, 51));
        btnMatarProcessos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnMatarProcessos.setForeground(new java.awt.Color(255, 255, 255));
        btnMatarProcessos.setText("Matar Processos");
        btnMatarProcessos.setBorderPainted(false);
        btnMatarProcessos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMatarProcessosActionPerformed(evt);
            }
        });

        btnFiltrar.setBackground(new java.awt.Color(255, 255, 255));
        btnFiltrar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnFiltrar.setText("Filtrar");
        btnFiltrar.setBorderPainted(false);
        btnFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarActionPerformed(evt);
            }
        });

        lblNome.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblNome.setForeground(new java.awt.Color(255, 255, 255));
        lblNome.setText("Nome:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(286, 286, 286)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnMatarProcessos, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(btnVoltar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTitulo)
                .addGap(203, 203, 203))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)
                        .addGap(67, 67, 67))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNome)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnFiltrar)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(lblTitulo)
                .addGap(18, 18, 18)
                .addComponent(lblNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(txtBusca))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnMatarProcessos, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 60, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 35, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarActionPerformed
        // TODO add your handling code here:
        
        TableRowSorter sorter = null;
      
        sorter = new TableRowSorter<>(jTProcessos.getModel());
        jTProcessos.setRowSorter(sorter);
        String text = txtBusca.getText();
        if (text.length() == 0) {
            sorter.setRowFilter(null);
        } else {
            sorter.setRowFilter(RowFilter.regexFilter(text));
        }

  
    }//GEN-LAST:event_btnFiltrarActionPerformed

    private void btnMatarProcessosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMatarProcessosActionPerformed
        // TODO add your handling code here:
           ArrayList<String> processos = new ArrayList();
        for (int i = 0; i < jTProcessos.getRowCount(); i++) {
            Boolean checked = Boolean.valueOf(jTProcessos.getValueAt(i, 0).toString());
            String id = jTProcessos.getValueAt(i, 2).toString();
            String nome_processor = jTProcessos.getValueAt(i, 3).toString();

            //DISPLAY
            if (checked) {

                try {
                    kill(id);
                    jTProcessos.setValueAt("Encerrado", i, 1);
                    processos.add(nome_processor);
                } catch (IOException ex) {
                   
                }

            }

        }

        String mensagem = "Processo " + processos + " interrompido com sucesso";

        JOptionPane.showMessageDialog(null, mensagem);

    }//GEN-LAST:event_btnMatarProcessosActionPerformed

        public static void kill(String pid) throws IOException {
        String os = System.getProperty("os.name");

        if (os.contains(("Windows"))) {
            Runtime.getRuntime().exec("taskkill  /PID " + pid + "  /F");

        } else {
            Runtime.getRuntime().exec("kill -9 " + pid);

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
            java.util.logging.Logger.getLogger(Processo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Processo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Processo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Processo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Processo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JButton btnMatarProcessos;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTProcessos;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtBusca;
    // End of variables declaration//GEN-END:variables
}