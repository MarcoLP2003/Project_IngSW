package org.example.Template;

import org.example.Command.ComandoAggiunta;
import org.example.Command.Receiver;
import org.example.main.Libreria;
import org.example.main.Libro;

import java.util.LinkedList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class LetturaJSON extends AbstractTemplate{

    private String path;

    public LetturaJSON(String path) {
        super(path);
        this.path = path;
    }

    @Override
    public Libreria leggi() {
        Libreria libreria = new Libreria();
        Receiver r = new Receiver(libreria);

        JSONParser parser = new JSONParser();
        File file = new File(path);
        try (FileReader fr = new FileReader(file)) {
            Object obj = parser.parse(fr);
            JSONArray array = (JSONArray) obj;

            for (Object o : array) {
                JSONObject jsonObj = (JSONObject) o;

                String titolo =(String) jsonObj.get("titolo");
                String autore =(String) jsonObj.get("titolo");
                String isbn =(String) jsonObj.get("titolo");
                String genere =(String) jsonObj.get("titolo");
                int valutazione =Integer.parseInt((String) jsonObj.get("valutazione"));
                String stato =(String) jsonObj.get("titolo");
                Libro l = new Libro(titolo,autore,isbn,genere,valutazione,stato);

                ComandoAggiunta comando = new ComandoAggiunta(l, r);
                comando.esegui();
            }
            System.out.println("Fine lettura da json");
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }



        return null;
    }
}
