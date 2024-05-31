package it.unisa.diem.oop22.box;

import it.unisa.diem.oop22.exceptions.AutorimessaPienaException;
import it.unisa.diem.oop22.exceptions.AutorimessaVuotaException;
import it.unisa.diem.oop22.exceptions.TargaNonValidaException;
import it.unisa.diem.oop22.veicoli.Veicolo;

public class Autorimessa extends Box{
    private Veicolo[] veicoli;
    private int testa;
    private int coda;
    private int riemp;

    public Autorimessa(int maxPosti, String nome) {
        super(maxPosti, nome);
        veicoli = new Veicolo[maxPosti];
        testa = 0;
        coda = 0;
        riemp = 0;
    }
    public void entra(Veicolo v) throws AutorimessaPienaException , TargaNonValidaException {
        if (riemp == getMaxPosti())
            throw new AutorimessaPienaException("AUTORIMESSA PIENA!");
        if (!v.controllaTarga())
            throw new TargaNonValidaException("TARGA NON VALIDA, INGRESSO VIETATO AL VEICOLO: \n " + v);
        veicoli[coda] = v;
        coda = (coda + 1)%getMaxPosti();
        riemp++;
    }

    public Veicolo esce() throws AutorimessaVuotaException{
        if (veicoli.length == 0)
            throw new AutorimessaVuotaException("AUTORIMESSA VUOTA!");
        Veicolo v = veicoli[testa];
        testa = (testa+1)%getMaxPosti();
        riemp--;
        return  v;
    }

    public String toString(){
        StringBuffer s = new StringBuffer(super.toString() + "\n Veicoli Presenti: " );
        for (Veicolo v : veicoli) {
            if (v != null)
                s.append(v.toString() + "\n");
        }
        return s.toString();
    }
}
