package EsempioEREDITARIETA_POLIMORFISMO;

public class Posizione2D{
    private int  x;
    private int y;
    Posizione2D(int x , int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    @Override
    public String toString(){
        return "  x: " + getX() + "\n" +
                " y: " + getY() + "\n";
    }
}