/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pantec;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author alexander
 */
public class TrocarTemas {
    private ImageIcon troca, logo;
    
    public void changeTheme(Integer tema){
        if(tema == 0){
            troca = new javax.swing.ImageIcon(getClass().getResource("/modoclaro.PNG"));
            logo = new javax.swing.ImageIcon(getClass().getResource("/logoclara.PNG"));
            
        }else{
            troca = new javax.swing.ImageIcon(getClass().getResource("/escuro.PNG"));
            logo = new javax.swing.ImageIcon(getClass().getResource("/logo.PNG"));
        }
    }    

    public Object getTroca() {
        return troca;
    }

    public Object getLogo() {
        return logo;
    }
  
 
}
