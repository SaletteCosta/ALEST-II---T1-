import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class App {
    private Scanner entrada;
    public App() {
            try {
                BufferedReader streamEntrada = new BufferedReader(new FileReader("casof30"));
                entrada = new Scanner(streamEntrada);
            } catch (FileNotFoundException e) {
               e.printStackTrace();
            }
    }
}
