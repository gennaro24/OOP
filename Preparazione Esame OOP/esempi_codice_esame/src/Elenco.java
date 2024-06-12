import java.util.*;
import java.io.*;

public class Elenco {
    HashMap<String , Persona> elenco;
    TreeSet<Persona> elenco1;
    BufferedWriter w = null;
    public Elenco(){
        elenco = new HashMap<>();
        elenco1 = new TreeSet<>();

    }
    public void aggiungi(Persona p) {
        elenco.put(p.getCodiceFiscale() , p);
    }
    public Persona cerca(String codFiscale) {
        return elenco.get(codFiscale);
    }
    public void stampaSuFile(String nomeFile) {
        Iterator<Persona> iterator = elenco.values().iterator();
        try{
            w = new BufferedWriter(new FileWriter(nomeFile));
            while (iterator.hasNext()){
                Persona p = iterator.next();
                w.write(p.getNome() + ";" + p.getCodiceFiscale() + ";" + p.getDataNascita());
                w.newLine();
            }
            w.flush();
            w.close();
        }catch(IOException ioe){ioe.printStackTrace();}

    }
    @Override
    public String toString() {
        StringBuffer st = new StringBuffer();
        Iterator<Persona> it = elenco.values().iterator();
        while (it.hasNext()){
            st.append(it.next());
        }
        return st.toString();
    }

}
