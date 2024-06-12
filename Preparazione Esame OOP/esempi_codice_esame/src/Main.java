/******************************************************************************

 ESERCIZIO n°1

 si chiede di completare le sezioni contrassegnate tenendo conto che:
 - due persone si assumono uguali se hanno lo stesso codiceFiscale
 - la classe Elenco deve incapsulare un'opportuna collezione di Persone e consentire in maniera efficiente la ricerca
 per codiceFiscale
 - l'elenco di persone deve essere scritto su file di testo CSV con campi delimitati da ";" ciascuna linea avente
 formato -> nome;codFiscale;dataDiNascita

 *******************************************************************************/




import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Elenco e = new Elenco();
        for (int i = 0 ; i<3 ; i++) {
            e.aggiungi(creaPersonaCasuale());
        }
        System.out.println(e);
        String cfTest = "7c699d14f3144";
        Persona p = e.cerca(cfTest);
        if( p == null) {
            System.out.println("Non esiste una persona con CF " + cfTest);
        } else {
            System.out.println(p);
        }
        e.stampaSuFile("output.csv");
    }

    private static Persona creaPersonaCasuale(){
        Random r = new Random();
        String[] nomi = {"Nicola", "Pasquale", "Marta", "Luisa", "Teresa", "Luca", "Daniela",
                "Gennaro", "Domenico", "Margherita", "Luigi"};
        return new Persona( nomi[r.nextInt(nomi.length)] , LocalDate.of(1900+r.nextInt(121),
                1+r.nextInt(12), 1+r.nextInt(27) ), UUID.randomUUID().toString().replace("-", "").substring(0, 13));
    }
}
