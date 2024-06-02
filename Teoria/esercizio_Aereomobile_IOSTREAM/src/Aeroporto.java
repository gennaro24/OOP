import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Aeroporto {
    private final Map<String , Aeromobile> aeroporto;
    private  CodeChecker checker;
    private boolean hasChecker(){
        return checker!=null;
    }

    public Aeroporto( CodeChecker checker) {
        aeroporto = new HashMap<>();
        this.checker = checker;
    }
    public Aeroporto(){
        aeroporto = new HashMap<>();
        checker = null;
    }

    public void setChecker(CodeChecker checker) {
        this.checker = checker;
    }

    public boolean inserisci(Aeromobile a){
        if (hasChecker()){
            if (checker.check(a.getCodice())) {
                aeroporto.put(a.getCodice(), a);
                return true;
            }
        return false;
        }
        aeroporto.put(a.getCodice() , a);
        return true;
    }

    public Aeromobile cerca(String codice){
        return aeroporto.get(codice);
    }
    public Aeromobile rimuovi(String codice){
        return aeroporto.remove(codice);
    }
    public int elementi(){
        return aeroporto.size();
    }

    public String toString(){
        StringBuffer s = new StringBuffer("\n");
        Iterator<Aeromobile> it = aeroporto.values().iterator();
        while (it.hasNext())
            s.append(it.next() + "\n");
        return s.toString();
    }

    public void salvaDOS(String nomefile){
        Iterator<Aeromobile> it = aeroporto.values().iterator();
        try{
            DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(nomefile)));

            dos.writeBoolean(hasChecker());
            if (hasChecker()) {
                if (checker instanceof CodeCheckerEN)
                    dos.writeUTF("EN");
                else
                    dos.writeUTF("IT");
            }
            dos.writeInt(elementi());
            while (it.hasNext()){

                if (it.next() instanceof Aliante){
                    dos.writeUTF("Aliante");
                    dos.writeUTF(it.next().getCodice());
                    dos.writeDouble(((Aliante) it.next()).getEfficienza());
                }
                else{
                    dos.writeUTF("Aereo A Motore");
                    dos.writeUTF(it.next().getCodice());
                    dos.writeInt(((AereoAMotore)it.next()).getNumRotori());
                }

            }
            dos.close();
        }catch (IOException ie){ie.printStackTrace();}
    }
    public static Aeroporto leggiDIS(String nomefile){
        Aeroporto ae = new Aeroporto();

        try{
            DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(nomefile)));
            if (dis.readBoolean()) {
                if (dis.readUTF().matches("IT"))
                    ae.setChecker(new CodeCheckerIT());
                else
                    ae.setChecker(new CodeCheckerEN());
            }
                int k = dis.readInt();
            for (int i =0 ; i < k ; i++){
                if (dis.readUTF().matches("Aliante")){
                    ae.inserisci(new Aliante(dis.readUTF() , dis.readInt()));
                } else {
                    ae.inserisci(new AereoAMotore(dis.readUTF() , dis.readInt()));
                }
            }
            dis.close();
        }catch (IOException ie){ie.printStackTrace();}
        return ae;
    }

    public void salvaOBJ(String nomefile){
        try{
            ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream(nomefile));
            obj.writeObject(aeroporto);
            obj.flush();
            obj.close();
        }catch (IOException ie){ie.printStackTrace();}
    }
    public static Aeroporto leggiOBJ(String nomefile){
        Aeroporto a = new Aeroporto();
        try{
            ObjectInputStream obj = new ObjectInputStream(new FileInputStream(nomefile));
              a = (Aeroporto) obj.readObject();
              obj.close();
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
            a = null;
        }

        return a;
    }
}
