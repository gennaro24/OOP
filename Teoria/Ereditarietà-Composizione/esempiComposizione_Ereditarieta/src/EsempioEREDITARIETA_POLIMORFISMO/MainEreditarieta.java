package EsempioEREDITARIETA_POLIMORFISMO;

public class MainEreditarieta {
    public static void main (String[] args) {
        Figure2D[] array = new Figure2D[5];
        array[0] = new Cerchio(2 , new Posizione2D(1 , 2));
        array[1] = new Quadrato(3 , new Posizione2D(3 , 4));
        array[4] = new Rettangolo(3 , 4 , new Posizione2D(5 , 5));
        //upcasting: sempre lecito, possono essere chiamati solo i metodi presenti nella classe padre e non quelli nuovi della classe figlio.
        Cerchio c = new Cerchio(2.2 , new Posizione2D(2 , 4));



       for(Figure2D f : array){
           if (f != null)
           System.out.println(f.stampaInfo() + "\n");
       }
    }
}
