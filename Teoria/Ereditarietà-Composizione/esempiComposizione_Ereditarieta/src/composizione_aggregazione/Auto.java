package composizione_aggregazione;



public class Auto{
    String nome;
    Motore m;
    public Auto (Motore m , String nome){
        this.m = m;
        this.nome = nome;
    }
    @Override
    public String toString(){
        return "composizione_aggregazione.Auto: " + " " +nome + " " +  "composizione_aggregazione.Motore: " + m.toString();
    }
}