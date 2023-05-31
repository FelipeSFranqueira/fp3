
package com.fp3.haras.view.screens.products;

import java.awt.GridBagLayout;
import javax.swing.JPanel;

public class ProductsContainer extends JPanel{
    private ProductsScreen screen;
    private ProductsCreate creationModal;
    private ProductsEdit editionModal;
    
    public ProductsContainer(){
        initComponents();
    }
    
    public void initComponents(){
        this.setLayout(new GridBagLayout());
        this.creationModal = new ProductsCreate();
        this.editionModal = new ProductsEdit();
        this.screen = new ProductsScreen(creationModal, editionModal);
        
        this.creationModal.addObserver(screen);
        this.editionModal.addObserver(screen);
        
        this.add(screen);
    }
}
