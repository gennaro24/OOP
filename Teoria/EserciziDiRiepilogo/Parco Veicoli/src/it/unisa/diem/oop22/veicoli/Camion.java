package it.unisa.diem.oop22.veicoli;

public class Camion extends Veicolo{
    private int numAssi;

    public Camion(String numTelaio, String modello, String alimentazione, String targa, int numAssi) {
        super(numTelaio, modello, alimentazione, targa);
        this.numAssi = numAssi;
    }

    public int getNumAssi() {
        return numAssi;
    }

    @Override
    public boolean controllaTarga() {
        if (getTarga().length() != 8)
            return false;
        return getTarga().matches("^[A-Za-z]{2}[0-9]{6}$");
    }

    @Override
    public String toString() {
        return super.toString() + "Numero assi= " + getNumAssi();
    }
}
