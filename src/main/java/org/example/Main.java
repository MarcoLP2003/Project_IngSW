package org.example;

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
import org.example.Template.LetturaCSV;
import org.example.Template.LetturaJSON;
import org.example.main.Libreria;
import org.example.main.Libro;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //TODO
        /*
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




        /*
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


        /*
        //TEST LETTURA DA FILE

        LetturaJSON lett = new LetturaJSON("C:\\Users\\marco\\Desktop\\Ingegneria del software\\libreria.JSON");
        System.out.println("Leggo JSON");
        //LetturaCSV lett = new LetturaCSV("C:\\Users\\marco\\Desktop\\Ingegneria del software\\libreria.CSV");
        //System.out.println("Leggo CSV");
        Libreria lib = lett.leggi();

        System.out.println(lib);

        //TEST SCRITTURA SU FILE

        Scanner in = new Scanner(System.in);
        System.out.println("Aggiungiamo un libro");

        String titolo = "";
        System.out.print("Titolo: ");
        titolo = in.nextLine();

        String autore = "";
        System.out.print("Autore: ");
        autore = in.nextLine();

        String isbn = "";
        System.out.print("isbn: ");
        isbn = in.nextLine();

        String genere = "";
        System.out.print("Genere: ");
        genere = in.nextLine();

        String val = "";
        int valutazione = 0;
        System.out.print("Valutazione(tra 0 e 5): ");
        val = in.nextLine();
        valutazione = Integer.parseInt(val);

        String stato = "";
        System.out.print("Stato: ");
        stato = in.nextLine();

        in.close();

        Libro libro = new Libro(titolo, autore, isbn, genere, valutazione, stato);
        System.out.println("libro ricevuto: ");
        System.out.println(libro);
        System.out.println("Provo ad aggiungerlo");
        lib.aggiungiLibro(libro);


         */

    }
}