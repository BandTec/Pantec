/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.processos;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import oshi.SystemInfo;
import oshi.software.os.OSProcess;

/**
 *
 * @author sakurah
 */
public class DadosdoProcesso {
    
    SystemInfo si = new SystemInfo();
    List<OSProcess> processosList;
    DefaultTableModel modelo;

    public DadosdoProcesso() {
        OrganizarTabela();
    }

    private void OrganizarTabela() {

        modelo = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int column) {

                return column == 0;
            }

            public Class<?> getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return Boolean.class;
                    case 1:
                        return String.class;
                    case 2:
                        return String.class;
                    case 3:
                        return String.class;

                    default:
                        return String.class;
                }
            }
        };

        modelo.addColumn("Selecionar");
        modelo.addColumn("Status");
        modelo.addColumn("ProcessoID");
        modelo.addColumn("Nome do Processo");

       atualizarValores();

    }

    
    
    private void atualizarValores() {
      
        processosList = si.getOperatingSystem().getProcesses();
        if (processosList.isEmpty()) {
            modelo.addRow(new Object[]{false, "sem informações", "sem informações", "sem informações"});
        } else {
            for (int i = 0; i < processosList.size(); i++) {

                modelo.addRow(new Object[0]);
                modelo.setValueAt(false, i, 0);
                modelo.setValueAt("Em andamento", i, 1);
                modelo.setValueAt(processosList.get(i).getProcessID(), i, 2);
                modelo.setValueAt(processosList.get(i).getName(), i, 3);

            }
        }
    
    }
    
    
    public DefaultTableModel getModelo() {
        return modelo;
    }

}
