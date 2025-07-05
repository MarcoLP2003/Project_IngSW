package org.example.Template;

import org.example.main.Libreria;
import org.example.main.Libro;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class LetturaCSV extends AbstractTemplate{

    private String path;

    public LetturaCSV(String path) {
        super(path);
        this.path = path;
    }

    @Override
    public Libreria leggi() {
        LinkedList<Libro> libri = new LinkedList<Libro>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            while (true) {
                String linea = br.readLine();
                if(linea == null){
                    break;
                }
                StringTokenizer st = new StringTokenizer(linea, ",[]\n");
                System.out.println("leggo libro da csv");
                String titolo = st.nextToken();
                System.out.println("titolo"+titolo);
                String autore = st.nextToken();
                System.out.println("autore"+autore);
                String isbn = st.nextToken();
                System.out.println("isbn"+isbn);
                String genere = st.nextToken();
                System.out.println("genere"+genere);
                int valutazione = Integer.parseInt(st.nextToken());
                System.out.println("valutazione"+valutazione);
                String stato = st.nextToken();
                System.out.println("stato"+stato);
                Libro l = new Libro(titolo, autore, isbn, genere, valutazione, stato);
                libri.add(l);
            }

            System.out.println("Fine lettura da CSV");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Libreria lib = new Libreria(libri, path, "CSV");
        return lib;
    }

    @Override
    public void scrivi(Libro libro, Libreria libreria) {
        System.out.println("Classe sbagliata per scrivere");
    }
}
