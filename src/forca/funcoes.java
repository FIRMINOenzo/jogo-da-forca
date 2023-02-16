package forca;

import java.util.Arrays;
import java.util.Scanner;

public class funcoes {
        
    public static void preencherArray (String m[]) {
        for (byte i = 0; i < m.length; i++) {
                m[i] = " ";
            }
        }
    
    public static boolean entradaCorreta (String l){
        boolean possivel = false;
  
        l = l.toUpperCase();
        
        if (l.length() == 1 && l.matches("[A-Z]*")){
            possivel = true;
        }
        
        return possivel;
    }

    public static void exibirBoneco(String m[]) {
        System.out.println("+------+");
        System.out.println("|      |");
        System.out.println("|      " + m[0]);
        System.out.println("|     " + m[1] + m[2] + m[3]);
        System.out.println("|      " + m[4]);
        System.out.println("|     " + m[5] + " " + m[6]);
    }
    
    public static void partesBoneco(String m[], byte erros){
        String[] partesCorpo = new String[7];
        
        partesCorpo[0] = "O";
        partesCorpo[1] = "/";
        partesCorpo[2] = "|";
        partesCorpo[3] = "\\";
        partesCorpo[4] = "|";
        partesCorpo[5] = "/";
        partesCorpo[6] = "\\";
        
        m[(erros)] = partesCorpo[(erros)];
    }
    
    public static boolean vitoria(String p[], String[] pj){
        boolean ganhou = false;
        
        String palavraString = Arrays.toString(p);
        palavraString = palavraString.replace("[", "");
        palavraString = palavraString.replace("]", "");
        palavraString = palavraString.replace(",", "");
        palavraString = palavraString.replace(" ", "");
                
        String palavraStringJogador = Arrays.toString(pj);
        palavraStringJogador = palavraStringJogador.replace("[", "");
        palavraStringJogador = palavraStringJogador.replace("]", "");
        palavraStringJogador = palavraStringJogador.replace(",", "");
        palavraStringJogador = palavraStringJogador.replace(" ", "");
                
        if (palavraString.equals(palavraStringJogador)){
            ganhou = true;
        }
        
        return ganhou;
    }
    
    public static void jogar(String m[], String p[]){
        Scanner entrada =  new Scanner(System.in);
        
        String letras = "";
        
        String palavraString = Arrays.toString(p);
        palavraString = palavraString.replace("[", "");
        palavraString = palavraString.replace("]", "");
        palavraString = palavraString.replace(",", "");
        palavraString = palavraString.replace(" ", "");
                
        String palavraJogador[] = new String[p.length];
        String letraJogada;
        byte erros = -1;
        boolean ganhou;
        
        for (byte i = 0; i < palavraJogador.length; i++) {
            palavraJogador[i] = "_ ";
        }
        
        while (true){
            
            if (erros == 6){
                System.out.println("FORCA!!!! VOCÊ PERDEU");
                partesBoneco(m, erros);
                exibirBoneco(m);
                System.out.println("A palavra correta era: " + palavraString.toUpperCase());
                break;
            }
            ganhou = vitoria(p, palavraJogador);
            
            if(ganhou){
                System.out.println("Você Acertou a Palavra!!!");
                System.out.println("A Palavra era: " + palavraString.toUpperCase());
                break;      
            }
            
            System.out.println("JOGO DA FORCA");

            exibirBoneco(m);

            System.out.println("----------------------------------------");

            for (byte i = 0; i < palavraJogador.length; i++) {
                System.out.print(palavraJogador[i]);
            }
        
            System.out.println("\nDIGITE UMA LETRA: ");
        
            letraJogada = entrada.nextLine();

            if(entradaCorreta(letraJogada)){                
                boolean temLetra = false;
                
                if (letras.toUpperCase().contains(letraJogada.toUpperCase())){
                    System.out.println("Você já digitou essa letra!");
                }
                else {
                    letras += letraJogada + " ";
                    
                    for (byte i = 0; i < p.length; i++) {
                        if (letraJogada.equals(p[i])){         
                            palavraJogador[i] = letraJogada + " ";
                            temLetra = true;
                        }
                    }

                    if (!temLetra) {
                        System.out.println("A palavra não tem essa letra");
                        erros++;
                        partesBoneco(m, erros);
                    }
                }
            }
            else{
                System.out.println("DIGITE UMA LETRA VÁLIDA");
            }
        }
        entrada.close();
    }
}