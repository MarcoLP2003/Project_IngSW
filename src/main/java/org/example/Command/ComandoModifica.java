package org.example.Command;

import org.example.main.Libro;

public class ComandoModifica implements Command {

    private Libro libro;
    private Receiver receiver;

    public ComandoModifica(Libro libro, Receiver receiver){
        this.libro = libro;
        this.receiver = receiver;
    }

    @Override
    public void esegui() {
        receiver.modificaLibro(libro);
    }
}
