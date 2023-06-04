/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fp3.haras.utils;

import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Table;
import java.awt.Component;
import java.awt.Desktop;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author 212118
 */
public class ReportGenerator {
    public void generateReport(Component parentScreen, String fileName, String title, JTable table) {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.showSaveDialog(parentScreen);
        
        if (chooser.getSelectedFile() != null) {
            String folder = chooser.getSelectedFile().getPath();
            String filePath = folder + "\\" + fileName + ".pdf";
            
            try {
                PdfWriter writer = new PdfWriter(filePath);
                PdfDocument pdf = new PdfDocument(writer);
                
                pdf.setTagged();
                pdf.setDefaultPageSize(PageSize.A4);
                
                Document doc = new Document(pdf);
                
                doc.setMargins(110, 36, 55, 36);
                
                Table tbl = new Table(table.getColumnCount()).useAllAvailableWidth();
                
                for (int i = 0; i < table.getColumnCount(); i++) {
                    tbl.addCell(table.getColumnName(i));
                }
                
                for (int i = 0; i < table.getRowCount(); i++) {
                    for (int c = 0; c < table.getColumnCount(); c++) {
                        tbl.addCell(table.getValueAt(i, c).toString());
                    }
                }
                
                doc.add(tbl);
                doc.close();
                
                File file = new File(filePath);
                Desktop.getDesktop().open(file);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(parentScreen, 
                        "Ocorreu um erro interno ao gerar o PDF. Caso o problema persista, contate o suporte.", 
                        "Erro ao gerar PDF", 
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
