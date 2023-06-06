package com.fp3.haras.view.container;

import com.fp3.haras.utils.GenericObserver;
import java.awt.CardLayout;

import com.fp3.haras.utils.Screens;
import com.fp3.haras.view.screens.animals.AnimalsContainer;
import com.fp3.haras.view.screens.client.ClientContainer;
import com.fp3.haras.view.screens.home.HomeScreen;
import com.fp3.haras.view.screens.client.ClientScreen;
import com.fp3.haras.view.screens.products.ProductsContainer;
import com.fp3.haras.view.screens.products.ProductsScreen;
import com.fp3.haras.view.screens.stable.StableContainer;

public class FeatureWrapper extends javax.swing.JPanel implements GenericObserver<Screens> {
    private CardLayout cardLayout;
    private HomeScreen homePanel;
    private StableContainer stablePanel;
    private ClientContainer customersPanel;
    private AnimalsContainer animalsPanel;
    private ProductsContainer productsPanel;
    
    public FeatureWrapper() {
        initComponents();
    }
    
    private void initComponents() {
        this.cardLayout = new CardLayout();
        this.setLayout(this.cardLayout);
        
        /* Declare here the screens */
        this.homePanel = new HomeScreen();
        this.stablePanel = new StableContainer();
        this.customersPanel = new ClientContainer();
        this.animalsPanel = new AnimalsContainer();
        this.productsPanel = new ProductsContainer();
                
        /* Add here the external classes to the layout */
        this.add(homePanel, Screens.HOME.toString());
        this.add(stablePanel, Screens.STABLE.toString());
        this.add(customersPanel, Screens.CUSTOMERS.toString());
        this.add(animalsPanel, Screens.ANIMALS.toString());
        this.add(productsPanel, Screens.PRODUCTS.toString());
        
        this.toggleScreen(Screens.HOME);
    }
    
    public void toggleScreen(Screens screen) {
        this.cardLayout.show(this, screen.toString());
    }

    @Override
    public void update(Screens featureName) {
        switch(featureName) {
            case HOME:
                toggleScreen(Screens.HOME);
                break;
            case STABLE:
                toggleScreen(Screens.STABLE);
                break;
            case CUSTOMERS:
                toggleScreen(Screens.CUSTOMERS);
                break;
            case ANIMALS:
                toggleScreen(Screens.ANIMALS);
                break;
            case PRODUCTS:
                toggleScreen(Screens.PRODUCTS);
                break;
            default:
                break;
        }
    }
}
