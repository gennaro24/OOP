package it.unisa.diem.oop.spazi;

import it.unisa.diem.oop.persone.Studente;

/*
2. Aula : la classe Aula modella lo spazio "Aula" che ha il seguente vincolo: gli studenti devono occupare i posti liberi partendo dal fondo,
di conseguenza il primo studente ad entrare sarà l'ultimo ad uscire.
La classe Aula ha come attributi almeno maxPosti che rappresenta il numero massimo di studenti ospitabili e studenti,
un array che contiene gli studenti presenti in aula.

La classe Aula dovrà prevedere un costruttore Aula(int maxPosti)  che ha come parametro  il numero massimo di studenti da ospitare ed i seguenti metodi:

-  ?? isFull() :  restituisce un booleano di valore vero se l'aula è piena

-  ?? isEmpty() : restituisce un booleano di valore vero se l'aula è vuota

- ?? entra( Studente s)  :  "aggiunge" uno studente ai presenti in aula

- Studente esce() :   "rimuove" uno studente dai presenti

- String getInfoAula() : restituisce una rappresentazione sotto forma di stringa dell'elenco degli studenti presenti in aula


 */
public class Aula {
    private int capienza;
    private int maxPosti;
    private Studente[] studenti;


    public Aula(int maxPosti){
        this.maxPosti = maxPosti;
        capienza = maxPosti;
        studenti = new Studente[maxPosti];
    }

    public boolean isEmpty(){
        return maxPosti == capienza;
    }
    public boolean isFull(){
        return capienza == 0;
    }
    public void entra(Studente s){
        if (!isFull()) {
            studenti[capienza-1] = s;
            capienza--;
            System.out.println("ENTRA:  \n" + s.getInfoStudente() + "\n\n");
            return;
        }
        System.out.println("AULA PIENA.\n");

    }
    public void esce(){
        if (isEmpty()) {
            System.out.println("aula vuota!");
            return;
        }
        studenti[capienza] = null;
        capienza++;
    }
    public String toString(){
        StringBuffer s = new StringBuffer("AULA: " + this.getClass().getSimpleName()  + "\n");
      for (int i = 0 ; i < maxPosti ; i++){
          if (studenti[i] != null )
              s.append("|" + "[posto " + i + "]" + studenti[i].getNome() + " " + studenti[i].getCognome() + " |");
          else
              s.append("|" + "[posto " + i + "]" + "|");
          if (i != maxPosti - 1)
              s.append("-----");
      }
        return s.toString();
    }

}


