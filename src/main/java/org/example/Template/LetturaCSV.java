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
            String linea = br.readLine();
            while (linea != null) {
                StringTokenizer st = new StringTokenizer(linea, ", []\n");
                String titolo = st.nextToken();
                String autore = st.nextToken();
                String isbn = st.nextToken();
                String genere = st.nextToken();
                int valutazione = Integer.parseInt(st.nextToken());
                String stato = st.nextToken();
                Libro l = new Libro(titolo, autore, isbn, genere, valutazione, stato);
                libri.add(l);
            }

            System.out.println("Fine lettura da CSV");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Libreria lib = new Libreria(libri);
        return lib;
    }
}
