/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.processo.pantec;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import oshi.SystemInfo;
import oshi.software.os.OSProcess;

/**
 *
 * @author Aluno
 */
public class ProcessosModelo extends AbstractTableModel{
   SystemInfo si = new SystemInfo();
    private List<OSProcess> dados = si.getOperatingSystem().getProcesses();
    private String [] colunas = {"Selecionar", "Status", "ProcessoID", "Nome do Processo"};

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
    
    @Override
    public String getColumnName(int column) {
     return colunas[column];
    }
    
    @Override
    public int getRowCount() {
     return dados.size();
    }

    @Override
    public int getColumnCount() {
    return colunas.length;
    }
    

    
    @Override
    public Object getValueAt(int linha, int coluna) {
      
        switch(coluna){
            case 0:
               return false;
               
            case 1:
                return "Em andamento";
            case 2:
                return dados.get(linha).getProcessID();
            case 3:
                return dados.get(linha).getName();
                        
            
        }
        return null;
        
    }


   
}
