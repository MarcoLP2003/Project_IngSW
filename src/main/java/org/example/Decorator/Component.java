package org.example.Decorator;

import org.example.main.Libreria;
import org.example.main.Libro;

import java.util.LinkedList;

public interface Component {

    public LinkedList<Libro> filtra(Libreria libreria);
}
