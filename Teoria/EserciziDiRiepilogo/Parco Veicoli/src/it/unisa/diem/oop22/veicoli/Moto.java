package it.unisa.diem.oop22.veicoli;

public class Moto extends Veicolo{
    private boolean guidaLibera;

    public Moto(String numTelaio, String modello, String alimentazione, String targa, boolean guidaLibera) {
        super(numTelaio, modello, alimentazione, targa);
        this.guidaLibera = guidaLibera;
    }
    public boolean isGuidaLibera(){
        return guidaLibera;
    }

    @Override
    public boolean controllaTarga() {
        if (getTarga().length() != 7)
        return false;

     return getTarga().matches("^[A-Za-z]{2}[0-9]{5}$");
    }

    @Override
    public String toString() {
        return super.toString() + "guida Libera= " + guidaLibera;
    }
}
