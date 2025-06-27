package org.example.main;

public class Libro {
    private String titolo;
    private String autore;
    private String isbn;
    private String genere;

    private int valutazione;
    private String stato;

    public Libro(String titolo, String autore, String isbn, String genere, int valutazione, String stato) {
        this.titolo = titolo;
        this.autore = autore;
        this.isbn = isbn;
        this.genere = genere;

        if(valutazione < 0 || valutazione > 5){
            throw new IllegalArgumentException("valutazione invalido");
        }
        if(stato == null || ( !stato.toLowerCase().equals("letto") && !stato.toLowerCase().equals("in lettura") && !stato.toLowerCase().equals("da leggere"))){
            throw new IllegalArgumentException("stato invalido");
        }
        this.valutazione = valutazione;
        this.stato = stato;
    }

    public String getGenere() {
        return genere;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getAutore() {
        return autore;
    }

    public String getTitolo() {
        return titolo;
    }

    public int getValutazione() {
        return valutazione;
    }

    public void setValutazione(int valutazione) {
        this.valutazione = valutazione;
    }

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

    @Override
    public String toString() {
        return titolo+" ["+autore+", "+isbn+", "+genere+", "+valutazione+", "+stato+"]";

    }

    @Override
    public boolean equals(Object obj) {
        Libro compare = (Libro) obj;
        return this.isbn.equals(compare.getIsbn());
    }
}
