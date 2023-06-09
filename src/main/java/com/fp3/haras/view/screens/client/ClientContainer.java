package com.fp3.haras.view.screens.client;

import java.awt.GridBagLayout;
import javax.swing.JPanel;

public class ClientContainer extends JPanel {
    private ClientScreen screen;
    private ClientCreate creationModal;
    private ClientEdit editionModal;
    
    public ClientContainer() {
        initComponents();
    }
    
    private void initComponents() {
        this.setLayout(new GridBagLayout());
        
        this.creationModal = new ClientCreate();
        this.editionModal = new ClientEdit();
        this.screen = new ClientScreen(creationModal, editionModal);
        
        this.creationModal.addObserver(screen);
        this.editionModal.addObserver(screen);
        
        this.add(screen);
    }
}
