package forca;

import static forca.funcoes.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Random;
import java.util.Scanner;

public class Forca {

    public static void main(String[] args) {
        String palavrasLinha = "";

        try (Scanner in = new Scanner(new FileReader("src/forca/palavras-aleatorias.txt"))) {
            while (in.hasNextLine()) {
                String line = in.nextLine();
                palavrasLinha += line + ";";
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        String[] palavras = palavrasLinha.split(";", 0);
        
        Random random = new Random();
        
        int index = random.nextInt(0, palavras.length);
        
        String[] palavraArray = palavras[index].split("");
        
        String boneco[] = new String[7];
        
        preencherArray(boneco);
        
        jogar(boneco, palavraArray);
    }
    
}
