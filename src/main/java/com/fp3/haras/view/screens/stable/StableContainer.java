package com.fp3.haras.view.screens.stable;

import java.awt.GridBagLayout;
import javax.swing.JPanel;

public class StableContainer extends JPanel{
    private StableScreen screen;
    private StableCreate creationModal;
    private StableEdit editionModal;
    
    public StableContainer() {
        initComponents();
    }
    
    public void initComponents() {
        this.setLayout(new GridBagLayout());
        this.creationModal = new StableCreate();
        this.editionModal = new StableEdit();
        this.screen = new StableScreen(creationModal, editionModal);
        
        this.creationModal.addObserver(screen);
        this.editionModal.addObserver(screen);
        
        this.add(screen);
    }
}
