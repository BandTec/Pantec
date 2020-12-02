/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bd;


import com.mycompany.log.ControllerLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import static org.apache.poi.ss.usermodel.FillPatternType.SOLID_FOREGROUND;
import org.apache.poi.ss.usermodel.HorizontalAlignment;


/**
 *
 * @author sakurah
 */
public class Relatorio {
    
       
    public void gerarRelatorio(Integer maquina) throws SQLException, IOException {
        java.sql.Connection con = ConnectionAzure.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ControllerLog log= new ControllerLog();
        stmt = con.prepareStatement("select*from registro as r, componente as c where r.componente = c.id and r.maquina_id= ?", PreparedStatement.RETURN_GENERATED_KEYS);
        stmt.setInt(1, maquina);
        rs = stmt.executeQuery();

        //create blank workbook
        HSSFWorkbook workbook = new HSSFWorkbook();
        //Create a blank sheet
        HSSFSheet sheet = workbook.createSheet("PantecDados");
        sheet.setColumnWidth((short) (0), (short) (10 * 400));
        sheet.setColumnWidth((short) (1), (short) (10 * 400));
        sheet.setColumnWidth((short) (2), (short) (10 * 600));

        ArrayList<Object[]> data = new ArrayList<Object[]>();
        data.add(new String[]{"Componente", "Uso", "Horário"});

        while (rs.next()) {

            String comp = rs.getString("nome");
            Double medida = rs.getDouble("uso");
            String momento = rs.getString("momento");

            data.add(new Object[]{comp, medida, momento});
        }

        //Iterate over data and write to sheet
        int rownum = 0;
        for (Object[] countries : data) {
            Row row = sheet.createRow(rownum++);

            int cellnum = 0;
            for (Object obj : countries) {
                Cell cell = row.createCell(cellnum++);
                if (obj instanceof String) {
                    cell.setCellValue((String) obj);
                } else if (obj instanceof Double) {
                    cell.setCellValue((Double) obj);
                } else if (obj instanceof Integer) {
                    cell.setCellValue((Integer) obj);
                }

                // Setting style only for header
                if (rownum == 1) {
                    CellStyle style = null;
                    // Creating a font
                    HSSFFont font = workbook.createFont();
                    font.setFontHeightInPoints((short) 10);
                    font.setFontName("Arial");
                    font.setColor(IndexedColors.WHITE.getIndex());
                    font.setBold(true);
                    font.setItalic(false);

                    style = workbook.createCellStyle();
                    style.setFillPattern(SOLID_FOREGROUND);
                    style.setAlignment(HorizontalAlignment.CENTER);
                    // Setting font to style
                    style.setFont(font);

                    // Setting cell style
                    cell.setCellStyle(style);
                }
            }

        }

        try {
            try ( //Write the workbook to the file system
                    FileOutputStream out = new FileOutputStream(new File("PantecDados.xls"))) {
                workbook.write(out);
                
            }
            log.printarLog("Relatório gerado com sucesso", "Informação");
             JOptionPane.showMessageDialog(null, "Relatório gerado com sucesso!");
         
        } catch (IOException e) {
            System.out.println("Arquivo já foi criado");
            log.printarLog("Arquivo já foi criado", "Erro");
        } finally {
            workbook.close();
        }
    }
    

  

}
