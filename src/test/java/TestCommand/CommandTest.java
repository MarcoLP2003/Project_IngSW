package TestCommand;

import org.example.Command.ComandoAggiunta;
import org.example.Command.ComandoModifica;
import org.example.Command.ComandoRimuovi;
import org.example.Command.Receiver;
import org.example.Template.LetturaJSON;
import org.example.main.Libreria;
import org.example.main.Libro;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.LinkedList;

import static org.junit.Assert.*;
import org.junit.jupiter.api.*;

public class CommandTest {

    private Libreria libreria;
    private Libro libro;
    private File temp;

    @BeforeEach
    public void setUp() throws IOException {
        String path = "C:\\Users\\marco\\Desktop\\libreria 1.json";
        libro = new Libro( "Zanna Bianca", "J.London", "007", "avventura", 5, "letto");

        Path originalPath = Path.of(path);
        Path tempPath = Files.createTempFile("testFile_", ".json");
        Files.copy(originalPath, tempPath, StandardCopyOption.REPLACE_EXISTING);
        temp = tempPath.toFile();

        LetturaJSON letturaJSON = new LetturaJSON(temp.getPath());
        libreria = letturaJSON.leggi();
    }

    @Test
    @DisplayName("Test aggiunta libro")
    public void testAggiunta(){
        System.out.println("aggiunta libro");
        System.out.println("Libreria iniziale: "+libreria);

        Receiver r = new Receiver(libreria);
        ComandoAggiunta ca = new ComandoAggiunta(libro, r);
        ca.esegui();

        System.out.println("Libreria finale: "+libreria);
    }

    @Test
    @DisplayName("Test rimozione libro")
    public void testRimozione(){
        Libro l = new Libro("1984", "George Orwell", "9788806237651","Narrativa", 3, "in lettura");

        System.out.println("rimozione libro");
        System.out.println("Libreria iniziale: "+libreria);

        Receiver r = new Receiver(libreria);
        ComandoRimuovi cr =  new ComandoRimuovi(l, r);
        cr.esegui();

        System.out.println("Libreria finale: "+libreria);
    }

    @Test
    @DisplayName("Test modifica libro")
    public void testModifica(){
        Libro l = new Libro("1984", "George Orwell", "9788806237651","Narrativa", 3, "in lettura");

        System.out.println("modifica libro");
        System.out.println("Libreria iniziale: "+libreria);
        Receiver r = new Receiver(libreria);
        Libro mod = l;
        mod.setStato("da leggere");
        mod.setValutazione(1);
        ComandoModifica cm = new ComandoModifica(mod, r);
        cm.esegui();
        System.out.println("Libreria finale: "+libreria);
    }

    @AfterEach
    public void cleanUp() throws IOException {
        if(temp != null && temp.exists()){
            temp.delete();
        }
    }
}
