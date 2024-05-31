package foschillogennaro.datastructures;

public class Studente {
    private String matricola;
    private String nome;
    private double votoMedio;

    public String getMatricola() {
        return matricola;
    }

    public String getNome() {
        return nome;
    }

    public double getVotoMedio() {
        return votoMedio;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setVotoMedio(double votoMedio) {
        this.votoMedio = votoMedio;
    }

    public Studente(String matricola, String nome, double votoMedio) {
        this.matricola = matricola;
        this.nome = nome;
        this.votoMedio = votoMedio;
    }

    @Override
    public String toString() {
        return String.format("Nome: %s - Matricola: %s - Voto medio: %.2f" , nome , matricola , votoMedio);
    }
}
