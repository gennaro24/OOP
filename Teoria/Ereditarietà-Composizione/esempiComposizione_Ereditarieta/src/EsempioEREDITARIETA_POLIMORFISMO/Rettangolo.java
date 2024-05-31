package EsempioEREDITARIETA_POLIMORFISMO;

public class Rettangolo extends Figure2D{
    private double base;
    private double altezza;
    public Rettangolo(double base, double altezza , Posizione2D pos ){
        super(pos);
        this.base = base;
        this.altezza = altezza;

    }
    @Override
    public double calcolaArea(){
        return base*altezza;
    }

    @Override
    public String stampaInfo() {
        return "Figura: Rettangolo , posizione nel " + super.stampaInfo()+ "AREA: " + calcolaArea();
    }
}
