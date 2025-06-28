package org.example;

import javax.swing.SwingUtilities;
import org.example.gui.LibreriaGUI;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LibreriaGUI());

        //FUNZIONA
    }
}
