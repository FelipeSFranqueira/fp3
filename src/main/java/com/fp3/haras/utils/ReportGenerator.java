package com.fp3.haras.utils;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.events.Event;
import com.itextpdf.kernel.events.IEventHandler;
import com.itextpdf.kernel.events.PdfDocumentEvent;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.layout.Canvas;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.property.TextAlignment;
import java.awt.Component;
import java.awt.Desktop;
import java.io.File;
import java.net.URL;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;

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
                
                doc.setMargins(155, 20, 55, 20);
                Header header = new Header(title);
                pdf.addEventHandler(PdfDocumentEvent.START_PAGE, header);
                
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
    
    class Header implements IEventHandler {
        private String title;
        
        public Header(String title) {
            this.title = title;
        }

        @Override
        public void handleEvent(Event event) {
            try {
                PdfDocumentEvent docEvent = (PdfDocumentEvent) event;
                PdfDocument pdf = docEvent.getDocument();
                PdfPage page = docEvent.getPage();
                Rectangle pageSize = page.getPageSize();
                Canvas canvas = new Canvas(new PdfCanvas(page), pageSize);
                
                canvas.setFontSize(18);
                
                URL urlToImage = this.getClass().getResource("/images/logo.png");
                ImageData data = ImageDataFactory.create(urlToImage.getPath());
                Image img = new Image(data);
                
                img.setWidth(90);
                img.setBorder(new SolidBorder(Color.convertRgbToCmyk(new DeviceRgb(255, 255, 255)), 20, 0));
                canvas.add(img);
                canvas.showTextAligned(title, 
                        pageSize.getWidth() / 2, 
                        pageSize.getTop() - 60, 
                        TextAlignment.CENTER);
                canvas.setUnderline();
                canvas.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, 
                        "Ocorreu um erro interno ao gerar o PDF. Caso o problema persista, contate o suporte.", 
                        "Erro ao gerar PDF", 
                        JOptionPane.ERROR_MESSAGE);
            }
        }

    }
}

