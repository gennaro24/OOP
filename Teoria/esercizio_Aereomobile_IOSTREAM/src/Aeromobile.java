public abstract class Aeromobile {
    private final String codice;
    private final int numeroSequenziale;
    private static int UltimonumeroSequenziale = 0;

    public Aeromobile(String codice) {
        this.codice = codice;
        this.numeroSequenziale = ++UltimonumeroSequenziale;
    }

    public int getNumeroSequenziale() {
        return numeroSequenziale;
    }

    public String getCodice() {
        return codice;
    }

    @Override
    public String toString() {
        return "Aeromobile n. " + getNumeroSequenziale() + "- Codice = " + getCodice() ;
    }
}
