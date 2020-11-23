/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import javax.swing.filechooser.FileSystemView;
/**
 *
 * @author sarah
 */
public class ControllerLog {


    private final String barra = System.getProperty("file.separator");
    private final File getCaminhoPasta
            = new File(FileSystemView.getFileSystemView().getDefaultDirectory() + barra + "Pantec" + barra);
    public File arquivo;

    public void printarLog(String textoLog, String tipoDeLog) {
        getCaminhoPasta.mkdir();

        try {
            Integer getDia = LocalDateTime.now().getDayOfMonth();
            Integer getMes = LocalDateTime.now().getMonthValue();
            Integer getAno = LocalDateTime.now().getYear();
            Integer getHora = LocalDateTime.now().getHour();
            Integer getMinuto = LocalDateTime.now().getMinute();
            Integer getSegundo = LocalDateTime.now().getSecond();
            
            StackTraceElement[] ultimoArquivo = new Throwable().getStackTrace();
            String getNomeClasse = ultimoArquivo[1].getClassName();

            String setNomeArquivo = String.format("Pantec_%d-%d-%d.txt", getDia, getMes, getAno);

            arquivo = new File(getCaminhoPasta + barra + setNomeArquivo);

            try (BufferedWriter setEncoding = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(arquivo, true), StandardCharsets.UTF_8))) {
                setEncoding.write(String.format(
                        "%d/%d/%d - %d:%d:%d Classe(%s) [%s] "
                        + "\n%s"
                        + "\n==========================================================\n",
                        getDia, getMes, getAno, getHora, getMinuto, getSegundo,
                        getNomeClasse, tipoDeLog, textoLog));
                setEncoding.newLine();
            }

        } catch (IOException e) {
        }
    }
}
