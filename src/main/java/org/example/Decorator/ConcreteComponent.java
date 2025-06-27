package org.example.Decorator;

import org.example.main.Libreria;
import org.example.main.Libro;

import java.util.LinkedList;

public class ConcreteComponent implements Component{


    @Override
    public LinkedList<Libro> filtra(Libreria libreria) {
        return libreria.getLibri();
    }
}
