package org.example.Template;

import org.example.main.Libreria;
import org.example.main.Libro;

public abstract class AbstractTemplate {

    private String path;

    public AbstractTemplate(String path) {
        this.path = path;
    }

    public Libreria templateMethod(){
        Libreria lib = leggi();
        return lib;
    }

    public abstract Libreria leggi();
    public abstract void scrivi(Libro libro, Libreria libreria);
}
