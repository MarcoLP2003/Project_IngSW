package org.example.Decorator;

import org.example.main.Libreria;
import org.example.main.Libro;

import java.util.LinkedList;

public class FiltraGenere extends BaseDecorator {
    private Component component;
    private String filtro;

    public FiltraGenere(Component component, String genere) {
        super(component, genere);
        this.filtro = genere;
        this.component = component;
    }

    @Override
    public LinkedList<Libro> filtra(Libreria libreria) {
        LinkedList<Libro> libri = new LinkedList<>();
        for (Libro libro : libreria.getLibri()) {
            if(libro.getGenere().equalsIgnoreCase(filtro)){
                libri.add(libro);
            }
        }
        System.out.println("Filtro per genere: "+ filtro);
        return libri;
    }
}
