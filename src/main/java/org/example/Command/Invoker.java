package org.example.Command;

public class Invoker {
    private Command command;

    public void scegliOperazione(Command c){
        this.command = c;
    }

    public void eseguiOperazione(){
        command.esegui();
    }

}
