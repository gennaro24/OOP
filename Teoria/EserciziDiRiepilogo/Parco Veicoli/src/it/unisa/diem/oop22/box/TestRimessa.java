package it.unisa.diem.oop22.box;
import it.unisa.diem.oop22.exceptions.AutorimessaPienaException;
import it.unisa.diem.oop22.exceptions.AutorimessaVuotaException;
import it.unisa.diem.oop22.exceptions.TargaNonValidaException;
import it.unisa.diem.oop22.veicoli.*;
public class TestRimessa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Autorimessa a = new Autorimessa(5, "Parcheggio E1");
        try {

            a.entra(new Camion("sdf244", "Fiat CX45", "Gasolio", "TT656671", 4));
           // a.entra(new Camion("spl265", "Volvo PTG", "Gasolio", "YH96671", 6));
            a.entra(new Autovettura("mk23t", "Fiat Punto", "Metano", "EA566FM", 5));
            //a.entra(new Autovettura("cgt612", "Fiat Idea", "Gasolio", "AQ9Y7UUU", 5));
            a.entra(new Moto("das7896", "Honda Hornet", "Benzina", "AT51233", false));
           // a.entra(new Moto("gdt7896", "Suzuki Bandit", "Benzina", "AT5123N", false));
            a.esce();
            // a.entra(new Moto("gdt7896", "Suzuki Bandit", "Benzina", "AT5123N", false));
        } catch (IllegalArgumentException ie) {
            ie.printStackTrace();
        } catch (AutorimessaVuotaException ae) {
            ae.printStackTrace();
        } catch (AutorimessaPienaException ap) {
            ap.printStackTrace();
        } catch (TargaNonValidaException tnv) {
            tnv.printStackTrace();
        }

        finally {
            System.out.println(a);
        }
    }
}



