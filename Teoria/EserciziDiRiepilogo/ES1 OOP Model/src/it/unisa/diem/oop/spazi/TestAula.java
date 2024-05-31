package it.unisa.diem.oop.spazi;

import it.unisa.diem.oop.persone.Studente;

public class TestAula{
    public static void main(String[] args){
        Aula a = new Aula(6);
        a.entra(new Studente("Peppe" , "Brescia" , "M09832"));
        a.entra(new Studente("Paolo" , "Cannone" , "M094383"));
        a.entra(new Studente("Aleksandra" , "Mach" , "M08236"));
        a.esce();
        a.esce();
        a.entra(new Studente("Gennaro" , "Foschillo" , "M92012"));
        a.esce();

        System.out.println(a);
    }
}


