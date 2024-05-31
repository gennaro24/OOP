package EsempioEREDITARIETA_POLIMORFISMO;

public abstract class Figure2D implements InterfaceFigure2D {

    protected Posizione2D punto;
    public Figure2D(Posizione2D punto) {
        setPunto(punto);
    }
    public void setPunto(Posizione2D punto) {
        this.punto = punto;
    }

    public  abstract double calcolaArea();

    public String stampaInfo(){
        return "punto: " + punto;
     }
}
