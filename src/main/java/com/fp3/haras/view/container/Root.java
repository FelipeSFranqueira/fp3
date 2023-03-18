package com.fp3.haras.view.container;

import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

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
    
    private JPanel sidenav;
    private JPanel mainContainer;
    
    public Root() {
        initComponents();
    }
    
    private void initComponents() {
        sidenav = new Sidenav();
        mainContainer = new MainContainer();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        getContentPane().add(sidenav, java.awt.BorderLayout.LINE_START);
        getContentPane().add(mainContainer, java.awt.BorderLayout.CENTER);
        
        pack();
    }
}
