package org.example.gui;

import org.example.Command.ComandoAggiunta;
import org.example.Command.ComandoModifica;
import org.example.Command.Receiver;
import org.example.Decorator.ConcreteComponent;
import org.example.Decorator.FiltraGenere;
import org.example.Decorator.FiltraStato;
import org.example.main.Libro;
import org.example.main.Libreria;
import org.example.Strategy.RicercaAutore;
import org.example.Strategy.RicercaTitolo;
import org.example.Template.LetturaJSON;
import org.example.Template.LetturaCSV;
import org.example.Template.ScritturaCSV;
import org.example.Template.ScritturaJSON;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.File;
import java.util.List;
import java.util.Scanner;

public class LibreriaGUI extends JFrame {
    private Libreria libreria;
    private JTable table;
    private DefaultTableModel tableModel;
    private JTextField searchTitleField;
    private JTextField searchAuthorField;

    public LibreriaGUI() {
        System.out.println("Inserisci path libreria e tipo:");
        Scanner sc = new Scanner(System.in);
        String path = sc.nextLine();
        String tipo = sc.nextLine();
        libreria = new Libreria(path, tipo);
        org.example.Decorator.Component c = new ConcreteComponent();
        setTitle("Gestione Libreria");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 600);
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new FlowLayout());

        JButton openButton = new JButton("Apri Libreria");
        JButton saveButton = new JButton("Salva Libreria");
        JButton addButton = new JButton("Aggiungi Libro");
        JButton filterGenreButton = new JButton("Filtra Genere");
        JButton filterStatusButton = new JButton("Filtra Stato");

        searchTitleField = new JTextField(10);
        searchAuthorField = new JTextField(10);
        JButton searchButton = new JButton("Cerca");

        topPanel.add(openButton);
        topPanel.add(saveButton);
        topPanel.add(addButton);
        topPanel.add(filterGenreButton);
        topPanel.add(filterStatusButton);
        topPanel.add(new JLabel("Titolo:"));
        topPanel.add(searchTitleField);
        topPanel.add(new JLabel("Autore:"));
        topPanel.add(searchAuthorField);
        topPanel.add(searchButton);

        add(topPanel, BorderLayout.NORTH);

        String[] columns = {"Titolo", "Autore", "Genere", "Valutazione", "Stato", "Azione"};
        tableModel = new DefaultTableModel(columns, 0) {
            public boolean isCellEditable(int row, int column) {
                return column == 5;
            }
        };
        table = new JTable(tableModel);
        table.getColumn("Azione").setCellRenderer(new ButtonRenderer());
        table.getColumn("Azione").setCellEditor(new ButtonEditor(new JCheckBox(), this));
        add(new JScrollPane(table), BorderLayout.CENTER);

        // Action Listeners
        addButton.addActionListener(e -> aggiungiLibroPopup());

        searchButton.addActionListener(e -> {
            String titolo = searchTitleField.getText();
            String autore = searchAuthorField.getText();
            List<Libro> risultati = libreria.getLibri();
            if (!titolo.isEmpty())
                risultati = new RicercaTitolo(titolo, libreria).cerca();
            if (!autore.isEmpty())
                risultati = new RicercaAutore(autore, libreria).cerca();
            aggiornaTabella(risultati);
        });

        filterGenreButton.addActionListener(e -> {
            String genere = JOptionPane.showInputDialog(this, "Inserisci genere:");
            if (genere != null)

                aggiornaTabella(new FiltraGenere(c, genere).filtra(libreria));
        });

        filterStatusButton.addActionListener(e -> {
            String stato = JOptionPane.showInputDialog(this, "Inserisci stato:");
            if (stato != null)
                aggiornaTabella(new FiltraStato(c, stato).filtra(libreria));
        });

        openButton.addActionListener(e -> {
            JFileChooser chooser = new JFileChooser();
            if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                File file = chooser.getSelectedFile();
                try {
                    if (file.getName().endsWith(".json")) {
                        libreria = new LetturaJSON(file.getAbsolutePath()).leggi();
                    } else if (file.getName().endsWith(".csv")) {
                        libreria = new LetturaCSV(file.getAbsolutePath()).leggi();
                    }
                    aggiornaTabella(libreria.getLibri());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Errore lettura file");
                }
            }
        });

        saveButton.addActionListener(e -> {
            JFileChooser chooser = new JFileChooser();
            if (chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                File file = chooser.getSelectedFile();
                try {
                    if (file.getName().endsWith(".json")) {
                        ScritturaJSON writer = new ScritturaJSON(file.getAbsolutePath());
                        for (Libro libro : libreria.getLibri()) {
                            writer.scrivi(libro, libreria);
                        }
                    } else if (file.getName().endsWith(".csv")) {
                        ScritturaCSV writer = new ScritturaCSV(file.getAbsolutePath());
                        for (Libro libro : libreria.getLibri()) {
                            writer.scrivi(libro, libreria);
                        }
                    }
                    else {
                        JOptionPane.showMessageDialog(this, "File deve essere .json o .csv");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Errore salvataggio file");
                }
            }
        });

        setVisible(true);
    }

    public void aggiornaTabella(List<Libro> libri) {
        tableModel.setRowCount(0);
        for (Libro l : libri) {
            tableModel.addRow(new Object[]{l.getTitolo(), l.getAutore(), l.getGenere(), l.getValutazione(), l.getStato(), "Modifica"});
        }
    }

    private void aggiungiLibroPopup() {
        JTextField titolo = new JTextField();
        JTextField autore = new JTextField();
        JTextField isbn = new JTextField();
        JTextField genere = new JTextField();
        JTextField valutazione = new JTextField();
        JTextField stato = new JTextField();

        Object[] message = {
                "Titolo:", titolo,
                "Autore:", autore,
                "isbn:", isbn,
                "Genere:", genere,
                "Valutazione:", valutazione,
                "Stato:", stato
        };

        int option = JOptionPane.showConfirmDialog(this, message, "Aggiungi Libro", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            Libro libro = new Libro(titolo.getText(), autore.getText(), isbn.getText(), genere.getText(),
                    Integer.parseInt(valutazione.getText()), stato.getText());
            Receiver r = new Receiver(libreria);
            new ComandoAggiunta(libro, r).esegui();
            aggiornaTabella(libreria.getLibri());
        }
    }

    public void modificaLibro(int row) {
        if (row < 0 || row >= libreria.getLibri().size()) return;
        Libro l = libreria.getLibri().get(row);

        JTextField valutazione = new JTextField(String.valueOf(l.getValutazione()));
        JTextField stato = new JTextField(l.getStato());

        Object[] message = {
                "Valutazione:", valutazione,
                "Stato:", stato
        };

        int option = JOptionPane.showConfirmDialog(this, message, "Modifica Libro", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            Receiver r = new Receiver(libreria);
            new ComandoModifica(l, r).esegui();
            aggiornaTabella(libreria.getLibri());
        }
    }
}
