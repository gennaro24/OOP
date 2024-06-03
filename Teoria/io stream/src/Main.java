import java.io.IOException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Gruppo g = new Gruppo("GRUPPO23");
        g.inserisci(new Persona(12 , "03ddkwmnd2n" , "olos" , "meme"));
        g.inserisci(new Persona(233 , "KDM3XP" , "A" , "B" ));
        g.inserisci(new Persona(23 , "doem2oms" , "SLSL" , "S2OKW"));
        Gruppo gCOPIA = new Gruppo("GRUPPO23");
        try{
            g.salvaOBJ("ciao.txt");
            gCOPIA = g.leggiOBJ("ciao.txt");
        }catch (IOException | ClassNotFoundException IOE ){IOE.printStackTrace();}

        System.out.println(g);
        System.out.println(gCOPIA);
    }
}