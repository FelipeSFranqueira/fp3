package com.fp3.haras.components;

import java.util.List;
import javax.swing.JComboBox;

public class ComboBoxSuggestion<E> extends JComboBox<E>{

    public ComboBoxSuggestion() {
        setUI(new ComboSuggestionUI());
    }

    public void setModel(List<String> lista) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
