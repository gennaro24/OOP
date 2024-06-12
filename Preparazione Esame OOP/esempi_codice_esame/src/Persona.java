import java.time.LocalDate;
import java.util.Objects;

public class Persona {
    
    private String nome;
    private LocalDate dataNascita;
    private String codiceFiscale;

    public Persona(String nome, LocalDate dataNascita, String codiceFiscale) {
        this.nome = nome;
        this.dataNascita = dataNascita;
        this.codiceFiscale = codiceFiscale;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascita() {
        return dataNascita;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }
    @Override
    public int hashCode() {
        return (codiceFiscale == null ) ? 0 : 17*31 + codiceFiscale.hashCode();

    }
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Persona)
            return ((Persona)obj).getCodiceFiscale().equals(getCodiceFiscale());
        return false;
    }

    @Override
    public String toString() {
        return "Nome=" + nome + ", Data di nascita=" + dataNascita + ", Codice fiscale=" +
                codiceFiscale;
    }

}