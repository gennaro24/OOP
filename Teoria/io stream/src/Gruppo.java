import java.io.*;
import java.util.TreeMap;

public class Gruppo {
    private String nomeGruppo;
    private TreeMap<String , Persona> gruppo;

    Gruppo(String nomeGruppo){
        this.nomeGruppo = nomeGruppo;
        gruppo = new TreeMap<>();
    }

    public void inserisci(Persona p){
        gruppo.put(p.getCodiceFiscale() , p);
    }
    public Persona preleva(String codiceFiscale){
        return gruppo.remove(codiceFiscale);
    }

    public void salvaOBJ(String nomefile) throws IOException {
        try(ObjectOutputStream obj = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(nomefile)))){
            obj.writeObject(this);
        }
    }
    public Gruppo leggiOBJ(String nomefile) throws IOException , ClassNotFoundException {
        try(ObjectInputStream obj = new ObjectInputStream(new BufferedInputStream(new FileInputStream(nomefile)))){
            return (Gruppo) obj.readObject();
        }
    }
}
