package composizione_aggregazione;

public class Motore {
    int cilindrata;
    int cavalli;
    public Motore(int cilindrata, int cavalli){
        this.cilindrata = cilindrata;
        this.cavalli = cavalli;
    }
    public String toString(){
        return "cilindrata = " + cilindrata + " " + "cavalli = " + cavalli;
    }

}