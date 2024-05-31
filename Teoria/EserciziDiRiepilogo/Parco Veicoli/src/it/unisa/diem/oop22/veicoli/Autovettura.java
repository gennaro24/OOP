package it.unisa.diem.oop22.veicoli;

public class Autovettura extends Veicolo{
    private int numPosti;

    public Autovettura(String numTelaio, String modello, String alimentazione, String targa, int numPosti) {
        super(numTelaio, modello, alimentazione, targa);
        this.numPosti = numPosti;
    }

    public int getNumPosti() {
        return numPosti;
    }

    @Override
    public boolean controllaTarga() {
        if (getTarga().length() != 7)
            return false;
        return getTarga().matches("^[A-Za-z]{2}[0-9]{3}[A-Za-z]{2}$");
    }

    @Override
    public String toString() {
        return super.toString() + "numero Posti= " + getNumPosti();
    }
}
