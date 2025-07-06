package TestStrategy;

import org.example.Strategy.Context;
import org.example.Strategy.Ricerca;
import org.example.Strategy.RicercaAutore;
import org.example.Strategy.RicercaTitolo;
import org.example.Template.LetturaJSON;
import org.example.main.Libreria;
import org.example.main.Libro;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.LinkedList;

import org.junit.jupiter.api.*;

public class StrategyTest {

    private Context context;
    private Libreria libreria;
    private File temp;

    @BeforeEach
    public void setup() throws IOException {

        String path = "C:\\Users\\marco\\Desktop\\libreria 1.json";

        Path originalPath = Path.of(path);
        Path tempPath = Files.createTempFile("testFile_", ".json");
        Files.copy(originalPath, tempPath, StandardCopyOption.REPLACE_EXISTING);
        temp = tempPath.toFile();

        LetturaJSON letturaJSON = new LetturaJSON(temp.getPath());
        libreria = letturaJSON.leggi();

        context = new Context();
    }

    @Test
    @DisplayName("Test ricerca autore")
    public void testAutore() {
        String autore = "J:London";
        Ricerca ricerca = new RicercaAutore(autore, libreria);

        System.out.println("ricerca autore: "+autore);
        System.out.println("Libreria iniziale: "+libreria);

        LinkedList<Libro> list = ricerca.cerca();

        System.out.println("Lista finale: "+list);

    }

    @Test
    @DisplayName("Test ricerca autore")
    public void testTitolo() {
        String titolo = "J:London";
        Ricerca ricerca = new RicercaTitolo(titolo, libreria);

        System.out.println("ricerca titolo: "+titolo);
        System.out.println("Libreria iniziale: "+libreria);

        LinkedList<Libro> list = ricerca.cerca();

        System.out.println("Lista finale: "+list);
    }

    @AfterEach
    public void cleanUp() throws IOException {
        if(temp != null && temp.exists()){
            temp.delete();
        }
    }
}
