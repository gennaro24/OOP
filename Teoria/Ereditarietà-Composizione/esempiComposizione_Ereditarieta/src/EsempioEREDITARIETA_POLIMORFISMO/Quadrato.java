package EsempioEREDITARIETA_POLIMORFISMO;

public class Quadrato  extends Figure2D{
    private double lato;
    public Quadrato(double lato , Posizione2D pos){
        super(pos);
        this.lato = lato;
    }
    @Override
    public double calcolaArea(){
        return Math.pow(2 , lato);
    }

    @Override
    public String stampaInfo() {
        return "Figura: Quadrato , posizione nel  " +  super.stampaInfo()+ "AREA: " + calcolaArea();
    }
}
