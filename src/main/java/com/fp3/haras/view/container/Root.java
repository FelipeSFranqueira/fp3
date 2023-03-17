package view.container;

import javax.swing.JPanel;

public class Root extends javax.swing.JFrame {
    private JPanel header;
    private JPanel sidenav;
    private JPanel mainContainer;
    
    public Root() {
        initComponents();
    }
    
    private void initComponents() {
        header = new Header();
        sidenav = new Sidenav();
        mainContainer = new MainContainer();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        getContentPane().add(header, java.awt.BorderLayout.PAGE_START);
        getContentPane().add(sidenav, java.awt.BorderLayout.LINE_START);
        getContentPane().add(mainContainer, java.awt.BorderLayout.CENTER);
        
        pack();
    }
}
