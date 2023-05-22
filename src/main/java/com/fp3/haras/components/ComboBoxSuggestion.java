package com.fp3.haras.components;

import javax.swing.JComboBox;

public class ComboBoxSuggestion<E> extends JComboBox<E>{

    public ComboBoxSuggestion() {
        setUI(new ComboSuggestionUI());
    }

}
