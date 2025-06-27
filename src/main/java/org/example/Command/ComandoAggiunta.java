package org.example.Command;

import org.example.main.Libreria;
import org.example.main.Libro;

public class ComandoAggiunta implements Command {

    private Libro libro;
    private Receiver receiver;

    public ComandoAggiunta(Libro libro, Receiver receiver){
        this.libro = libro;
        this.receiver = receiver;
    }

    @Override
    public void esegui() {
        receiver.aggiungiLibro(libro);
    }
}
