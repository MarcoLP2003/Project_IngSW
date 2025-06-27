package org.example.Strategy;
import org.example.main.Libreria;
import org.example.main.Libro;
import java.util.LinkedList;
import java.util.List;

public class RicercaTitolo implements Ricerca {
    private String titolo;
    List<Libro> listaLibri = new LinkedList<>();

    public RicercaTitolo(String titolo, Libreria libreria) {
        this.listaLibri = libreria.getLibri();
        this.titolo = titolo;
    }

    @Override
    public LinkedList<Libro> cerca() {
        LinkedList<Libro> ret = new LinkedList<>();
        for (Libro libro : listaLibri) {
            if(libro.getTitolo().equals(titolo)){
                ret.add(libro);
            }
        }
        return ret;
    }
}
