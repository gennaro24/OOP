import java.io.*;
import java.util.Scanner;

public class CopyLines {
   public static BufferedReader  reader = null;
   public static BufferedWriter writer = null;
   public static DataInputStream dis = null;
   public static DataOutputStream dos = null;

    public static void write (String s){
        try{
            writer = new BufferedWriter(new FileWriter("xanadu.txt" , true )) ;//true abilita l'append nel file e non sovrascrive ciò che è stato inserito prima.
            writer.write(s);
            writer.append("  ");

            writer.close(); // è importante chiudere il file in quanto esso se rimane aperto potrebbe essere non disponibile per essere utilizzato altrove. Inoltre, con close si forza il buffer allo svuotamento, in modo che tutte le risorse siano scritte su file.
        }catch(FileNotFoundException fnf){fnf.printStackTrace();}
          catch (IOException ioe){ioe.printStackTrace();}
    }

    public static String read(){
        StringBuffer s = new StringBuffer();
        try{
            reader = new BufferedReader(new FileReader("xanadu.txt" ));
            String l;
            while ((l = reader.readLine()) != null)
                s.append(l + "\n");
            reader.close();
        }catch(IOException IOE){IOE.printStackTrace();}

        return s.toString();
    }

    public static String readWithScanner(){
        StringBuffer stb = new StringBuffer();
        try{
            reader = new BufferedReader(new FileReader("xanadu.txt" ));
            Scanner s = new Scanner(reader);
            s.useDelimiter("\n");
            while(s.hasNext())
                stb.append(s.next() + "\n");
            s.close();
        }catch(IOException ioe){ioe.printStackTrace();}

        return stb.toString();
    }

    public void salvaOBJ(){

    }
}
