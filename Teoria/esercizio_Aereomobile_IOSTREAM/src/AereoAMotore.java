public class AereoAMotore extends Aeromobile{
    private final int numRotori;

    public AereoAMotore(String codice, int numRotori) {
        super(codice);
        this.numRotori = numRotori;
    }

    public int getNumRotori() {
        return numRotori;
    }

    @Override
    public String toString() {
        return super.toString() + "- Tipo = Aereo A Motore - Numero rotori = " + getNumRotori();
    }
}
