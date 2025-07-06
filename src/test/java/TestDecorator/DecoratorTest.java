package TestDecorator;

import org.example.Decorator.*;
import org.example.main.Libreria;
import org.example.main.Libro;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class DecoratorTest {

    private Libreria libreria;
    private File temp;

    private Component component;

    @BeforeEach
    public void setUp() throws IOException {
        component = new ConcreteComponent();

        String path = "C:\\Users\\marco\\Desktop\\libreria 1.json";
        Path originalPath = Path.of(path);
        Path tempPath = Files.createTempFile("testFile_", ".json");
        Files.copy(originalPath, tempPath, StandardCopyOption.REPLACE_EXISTING);
        temp = tempPath.toFile();

    }

    @Test
    @DisplayName("Test filtro per genere")
    public void testGenere() {
        String genere = "avventura";
        System.out.println("filtro genere: "+ genere);
        System.out.println("Libreria iniziale: "+libreria);

        BaseDecorator fs = new FiltraGenere(component, genere);
        System.out.println("Libreria finale"+fs.filtra(libreria));
    }

    @Test
    @DisplayName("Test filtro per genere")
    public void testStato() {
        String stato = "letto";
        System.out.println("filtro stato: "+ stato);
        System.out.println("Libreria iniziale: "+libreria);

        BaseDecorator fs = new FiltraStato(component, stato);
        System.out.println("Libreria finale"+fs.filtra(libreria));
    }

    @AfterEach
    public void cleanUp() throws IOException {
        if(temp != null && temp.exists()){
            temp.delete();
        }
    }
}
