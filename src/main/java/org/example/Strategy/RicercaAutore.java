package org.example.Strategy;
import org.example.main.Libreria;
import org.example.main.Libro;
import java.util.LinkedList;
import java.util.List;

public class RicercaAutore implements Ricerca {
    private String autore;
    List<Libro> listaLibri = new LinkedList<>();

    public RicercaAutore(String autore, Libreria libreria) {
        this.listaLibri =  libreria.getLibri();
        this.autore = autore;
    }

    @Override
    public LinkedList<Libro> cerca() {
        LinkedList<Libro> ret = new LinkedList<>();
        for (Libro libro : listaLibri) {
            if(libro.getAutore().equals(autore)){
                ret.add(libro);
            }
        }
        return ret;
    }
}
