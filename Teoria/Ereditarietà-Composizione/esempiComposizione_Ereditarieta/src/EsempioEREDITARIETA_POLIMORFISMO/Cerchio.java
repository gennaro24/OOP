package EsempioEREDITARIETA_POLIMORFISMO;

public class Cerchio extends Figure2D{
    private double raggio;
    public Cerchio(double raggio , Posizione2D pos){
        super(pos);
        this.raggio = raggio;
    }
    @Override
    public double calcolaArea(){

        return  3.14*Math.pow(2 , raggio) ;
    }

    @Override
    public String stampaInfo() {
        return  "Figura: Cerchio , Posizione nel  " +   super.stampaInfo() + "AREA: " + calcolaArea();
    }
}
