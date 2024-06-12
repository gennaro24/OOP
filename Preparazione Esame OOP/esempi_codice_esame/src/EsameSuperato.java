import java.time.*;
public class EsameSuperato implements Comparable<EsameSuperato>{
    private String matricolaStudente;
    private LocalDate dataSuperamento;
    private String nomeInsegnamento;
    private int voto;

    public EsameSuperato(String matricolaStudente , LocalDate dataSuperamento , String nomeInsegnamento , int voto) {
        this.matricolaStudente = matricolaStudente;
        this.dataSuperamento = dataSuperamento;
        this.nomeInsegnamento = nomeInsegnamento;
        this.voto = voto;
    }

    public String getMatricolaStudente(){
        return matricolaStudente;
    }

    public LocalDate getDataSuperamento(){
        return dataSuperamento;
    }

    public String getnomeInsegnamento(){
        return nomeInsegnamento;
    }

    public int getVoto(){
        return voto;
    }

    @Override
    public int hashCode() {
        return matricolaStudente==null ? 0 : 31*17 + matricolaStudente.hashCode();
    }
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof EsameSuperato){

            String matricolaObj = ((EsameSuperato)obj).getMatricolaStudente();
            String nomeInsegnamentoObj = ((EsameSuperato)obj).getnomeInsegnamento();
            Boolean isMatricola = this.getMatricolaStudente().equals(matricolaObj);
            Boolean isNomeInsegnamento = this.getnomeInsegnamento().equals(nomeInsegnamentoObj);

            return isNomeInsegnamento && isMatricola;
        }
        return false;

    }

    @Override
    public String toString() {
        return getMatricolaStudente() + ";" + getDataSuperamento() + ";" + getnomeInsegnamento() + ";" + getVoto();
    }
    @Override
    public int compareTo(EsameSuperato s) {
            if (this.getMatricolaStudente().equals(s.getMatricolaStudente()))
                return this.getnomeInsegnamento().compareTo(s.getnomeInsegnamento());
            return this.getMatricolaStudente().compareTo(s.getMatricolaStudente());

    }
}
