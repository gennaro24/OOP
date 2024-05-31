package it.unisa.diem.oop.persone;
/*
Studente : è una classe pubblica che modella l'entità studente con gli attributi nome,
cognome e matricola. Scegliere per gli attributi un tipo di dato che si ritiene opportuno.
Definire per tutti gli attributi i metodi getter e setter.
Definire inoltre un metodo getInfoStudente() che restituisca una rappresentazione come stringa dello studente secondo il seguente formato:

***Studente****

Nome: Mario

Cognome: Rossi

Matricola : 0612710099
*/
public class Studente {
    private String nome;
    private String cognome;
    private String matricola;

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getMatricola() {
        return matricola;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setMatricola(String matricola) {
        this.matricola = matricola;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Studente(String nome, String cognome, String matricola) {
        this.nome = nome;
        this.cognome = cognome;
        this.matricola = matricola;
    }

    public String getInfoStudente(){
        return "***Studente*** \n\n" +

                    "Nome: " + getNome()+"\n" +
                    "Cognome: " + getCognome() + "\n\n" +
                    "Matricola: " + getMatricola() + "\n";
    }
}
