/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pantec;

import com.mycompany.api.Monitoramento;
import com.mycompany.bd.Select;
import java.util.Scanner;

/**
 *
 * @author sakurah
 */
public class Teste {
    public static void main(String[] args) {
    Select con = new Select();
    Integer idmaquina = 0;
    Scanner leitura=new Scanner(System.in);
    System.out.println("Insira seu login: ");
    String login;
    login=leitura.next();
    System.out.println("Insira sua senha: ");
    String senha;
    senha=leitura.next();
    if (con.checkLogin(login, senha)) {
        Integer maquina=con.getMaquina();
        idmaquina=maquina;
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("erro: "+e);;
            }
            //bot.chat("Iniciou o monitoramento");
            Monitoramento inicio = new Monitoramento();
            System.out.println(inicio.getTempCpu().intValue());
            System.out.println(String.format("%.1f °C", inicio.getTempCpu()));

            System.out.println(inicio.getTamanhoDiscoUsado().intValue());
            System.out.println(inicio.getPorcMemRam().intValue());
            System.out.println(inicio.getPorcCpu().intValue());

            con.insereRegistro(idmaquina, inicio.getPorcCpu(), inicio.getPorcMemRam(), inicio.getTamanhoDiscoUsado(), inicio.getTempCpu());

        }
    }
    }
}
