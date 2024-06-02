import java.io.Serializable;

public class Persona implements Serializable {
    private int anni;
    private String codiceFiscale;
    private String cognome;
    private String nome;

    public Persona(int anni, String codiceFiscale, String cognome, String nome) {
        this.anni = anni;
        this.codiceFiscale = codiceFiscale;
        this.cognome = cognome;
        this.nome = nome;
    }

    public int getAnni() {
        return anni;
    }

    public void setAnni(int anni) {
        this.anni = anni;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
