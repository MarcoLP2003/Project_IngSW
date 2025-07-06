package TestTemplate;

import org.example.Command.ComandoAggiunta;
import org.example.Command.Receiver;
import org.example.Strategy.Context;
import org.example.Template.LetturaJSON;
import org.example.Template.ScritturaJSON;
import org.example.main.Libreria;
import org.example.main.Libro;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import org.junit.jupiter.api.*;

public class TemplateTest {

    private Libreria libreria;
    private Libro libro;
    private File temp;

    @BeforeEach
    public void setup() throws IOException {

        String path = "C:\\Users\\marco\\Desktop\\libreria 1.json";
        libro = new Libro( "Zanna Bianca", "J.London", "007", "avventura", 5, "letto");

        //Test intrinseco di lettura, basta cambiare json e csv nelle stringhe per provarli entrambi

        Path originalPath = Path.of(path);
        Path tempPath = Files.createTempFile("testFile_", ".json");
        Files.copy(originalPath, tempPath, StandardCopyOption.REPLACE_EXISTING);
        temp = tempPath.toFile();

        LetturaJSON letturaJSON = new LetturaJSON(temp.getPath());
        libreria = letturaJSON.leggi();
    }

    @Test
    @DisplayName("Test scrittura")
    public void testScrittura() throws IOException {
        ScritturaJSON scr = new ScritturaJSON(temp.getAbsolutePath());

        System.out.println("scrittura su file");
        System.out.println("Libreria iniziale: "+libreria);

        scr.scrivi(libro, libreria);
        libreria = new Libreria( temp.getAbsolutePath().toString(), "json");

        System.out.println("Libreria finale: "+libreria);

    }

    @AfterEach
    public void cleanUp() throws IOException {
        if(temp != null && temp.exists()){
            temp.delete();
        }
    }
}
