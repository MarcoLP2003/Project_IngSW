package org.example.Decorator;

import org.example.main.Libreria;
import org.example.main.Libro;

import java.util.LinkedList;

public class FiltraStato extends BaseDecorator {

    private Component wrap;
    private String filtro;

    public FiltraStato(Component c, String filtro) {
        super(c, filtro);
        this.wrap = c;
        this.filtro = filtro;
    }

    @Override
    public LinkedList<Libro> filtra(Libreria libreria) {
        if(!(filtro.equals("da leggere")||filtro.equals("letto")||filtro.equals("in lettura"))){
            throw new RuntimeException("Stato non valido");
        }
        LinkedList<Libro> libri = new LinkedList<>();
        for (Libro libro : libreria.getLibri()) {
            if(libro.getStato().toLowerCase().equals(filtro.toLowerCase())){
                libri.add(libro);
            }
        }
        System.out.println("Filtro per stato: "+filtro);
        return libri;
    }
}
