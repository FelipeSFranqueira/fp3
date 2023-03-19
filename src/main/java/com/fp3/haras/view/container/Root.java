package com.fp3.haras.view.container;

import java.awt.*;
import javax.swing.*;

import com.formdev.flatlaf.FlatLightLaf;

public class Root extends javax.swing.JFrame {
    
    static {
        try {
            UIManager.setLookAndFeel( new FlatLightLaf() );
        } catch( UnsupportedLookAndFeelException e ) {
            System.err.println( "Failed to initialize Flat LaF" );
            e.printStackTrace();
        }
    }
    
    private Sidenav sidenav;
    private MainContainer mainContainer;
    
    public Root() {
        initComponents();
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(screenSize.width - 100, screenSize.height - 100);
        this.setLocationRelativeTo(null);
    }
    
    private void initComponents() {
        sidenav = new Sidenav();
        mainContainer = new MainContainer();

        sidenav.addObserver(mainContainer.getFeatureWrapper());
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        getContentPane().add(sidenav, BorderLayout.LINE_START);
        getContentPane().add(mainContainer, BorderLayout.CENTER);
        
        pack();
    }
}
