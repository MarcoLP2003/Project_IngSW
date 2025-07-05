package org.example.Template;

import org.example.main.Libreria;
import org.example.main.Libro;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ScritturaJSON extends AbstractTemplate{

    private String path;

    public ScritturaJSON(String path) {
        super(path);
        this.path = path;
    }

    @Override
    public Libreria leggi() {
        System.out.println("Classe sbagliata per leggere");
        return null;
    }

    @Override
    public void scrivi(Libro libro, Libreria libreria) {
        JSONArray jsonArray = new JSONArray();

        for(Libro l : libreria.getLibri()){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("titolo",  l.getTitolo());
            jsonObject.put("autore",  l.getAutore());
            jsonObject.put("isbn",  l.getIsbn());
            jsonObject.put("genere",  l.getGenere());
            jsonObject.put("valutazione",  l.getValutazione());
            jsonObject.put("stato",  l.getStato());

            jsonArray.add(jsonObject);
        }

        try(PrintWriter out = new PrintWriter(new FileWriter(this.path, false))) {
            out.write(jsonArray.toJSONString());
            out.flush();
        }catch(IOException e){
            throw new RuntimeException("Errore in scrittura su JSON",e);
        }
    }
}
