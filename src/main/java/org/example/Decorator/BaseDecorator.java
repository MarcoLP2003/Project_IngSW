package org.example.Decorator;

import org.example.main.Libreria;
import org.example.main.Libro;

import java.util.LinkedList;

public abstract class BaseDecorator implements Component {

    private Component wrap;
    private String filtro;

    public BaseDecorator(Component c,  String f) {
        this.wrap = c;
        this.filtro = f;
    }

    @Override
    public LinkedList<Libro> filtra(Libreria libreria) {
        return wrap.filtra(libreria);
    }
}
