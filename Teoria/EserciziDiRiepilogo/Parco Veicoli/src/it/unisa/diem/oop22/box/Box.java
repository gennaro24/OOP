package it.unisa.diem.oop22.box;

import it.unisa.diem.oop22.exceptions.AutorimessaPienaException;
import it.unisa.diem.oop22.exceptions.AutorimessaVuotaException;
import it.unisa.diem.oop22.exceptions.TargaNonValidaException;
import it.unisa.diem.oop22.veicoli.Veicolo;

public abstract class Box {
    public int maxPosti;
    private String nome;

    public Box(int maxPosti, String nome) throws IllegalArgumentException {
        if (maxPosti < 0)
            throw new IllegalArgumentException("ERRORE: POSTI NEGATIVI.");
        if (maxPosti == 0)
            throw new IllegalArgumentException("ERRORE: HAI INSERITO POSTI NULLI. IL GARAGE E' INUTILIZZABILE");
        this.maxPosti = maxPosti;
        this.nome = nome;
    }

    public int getMaxPosti() {
        return maxPosti;
    }

    abstract void entra(Veicolo v) throws AutorimessaPienaException , TargaNonValidaException;
    abstract Veicolo esce() throws AutorimessaVuotaException;

    @Override
    public String toString() {
        return "Box= " + nome + ", Capienza= " + maxPosti + " posti. \n";
    }
}
