package org.example.Command;

import org.example.main.Libro;

public class ComandoRimuovi implements Command {

    private Libro libro;
    private Receiver receiver;

    public ComandoRimuovi(Libro libro, Receiver receiver){
        this.libro = libro;
        this.receiver = receiver;
    }

    @Override
    public void esegui() {
        receiver.rimuoviLibro(libro);
    }
}
