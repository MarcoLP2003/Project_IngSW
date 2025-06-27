import org.example.Command.ComandoAggiunta;
import org.example.Command.ComandoRimuovi;
import org.example.Command.Receiver;
import org.example.Decorator.Component;
import org.example.Decorator.ConcreteComponent;
import org.example.Decorator.FiltraGenere;
import org.example.Strategy.Context;
import org.example.Strategy.Ricerca;
import org.example.Strategy.RicercaAutore;
import org.example.Strategy.RicercaTitolo;
import org.example.main.Libreria;
import org.example.main.Libro;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        //TODO
        /*
        gestione memorizzazione su file (estrazione e salvataggio)
        TESTARE PACKAGE TEMPLATE
        GUI
         */



        /*
        TEST STRATEGY
        LinkedList<Libro> listaLibri = new LinkedList<>();
        Context c = new Context();
        for(int i = 0; i < 10; i++){
            if(i == 5){
                Libro l = new Libro("a", "pippo", "x", "d", 1, "letto");
                listaLibri.add(l);
                continue;
            }
            Libro l = new Libro("a", "b", "x", "d", 1, "letto");
            listaLibri.add(l);
        }
        Ricerca r = new RicercaTitolo("a", listaLibri);
        c.scegliRicerca(r);
        */





        //TEST COMMAND
        Libreria libreria = new Libreria();
        Receiver r = new Receiver(libreria);

        Libro a = null;
        for(int i = 0; i < 10; i++){
            Libro l = new Libro(""+i, "pippo", "isbn"+i, "d", 1, "letto");
            ComandoAggiunta comando = new ComandoAggiunta(l, r);
            comando.esegui();
            a = l;
        }
        /*
        LinkedList<Libro> libri = libreria.getLibri();
        System.out.println("LIBRERIA DOPO AGGIUNTE");
        for(Libro lib : libri){
            System.out.println(lib);
        }

        ComandoRimuovi comm =  new ComandoRimuovi(a, r);
        comm.esegui();
        System.out.println("LIBRERIA DOPO RIMOZIONE");
        LinkedList<Libro> aaaa = libreria.getLibri();
        for(Libro lib : aaaa){
            System.out.println(lib);
        }
        */

        /*
        //TEST DECORATOR
        Component comp = new ConcreteComponent();
        Component b = new FiltraGenere(comp, "d");
        System.out.println(b.filtra(libreria));
        */

    }
}