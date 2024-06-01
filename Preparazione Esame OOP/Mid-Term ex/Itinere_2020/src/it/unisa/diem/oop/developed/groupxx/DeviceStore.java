package it.unisa.diem.oop.developed.groupxx;
import it.unisa.diem.oop.provided.*;
import java.util.*;

public class DeviceStore implements Filterable {
    private String name;
    private Set<Device> store;

    public DeviceStore(String name) {
        this.name = name;
        store = new TreeSet<>();
    }
    public DeviceStore(String name , Comparator<Device> c){
        this.name = name;
        store = new TreeSet<>(c);
    }

    /*– consente di aggiungere un dispositivo allo store. Nel caso in
    cui il dispositivo sia già presente, solleva un’eccezione non controllata di tipo
    DeviceInsertionException.*/
    public void addDevice(Device d ) throws DeviceInsertionException{
        if (store.contains(d))
            throw new DeviceInsertionException("ELEMENTO GIA' PRESENTE.");
        store.add(d);
    }


    /* consente di ottenere
    un nuovo store costituito da un sottoinsieme degli elementi presenti nello store di partenza,
    selezionati in accordo al filtro specificato dal parametro d e con una relazione d’ordine imposta dal
    comparatore c. Nel caso in cui c==null viene preservata la relazione d’ordine naturale degli elementi.*/
    @Override
    public DeviceStore filter(DeviceFilter d, Comparator<Device> c) {
        DeviceStore dvst = new DeviceStore(this.name , c);
        Iterator<Device> iteratore = store.iterator();
        while (iteratore.hasNext()){
            if (d.checkDevice(iteratore.next()))
                dvst.addDevice(iteratore.next());
        }
        return dvst;
    }

    @Override
    public String toString(){
        StringBuffer st = new StringBuffer(this.getClass().getName() + "contains: " + store.size() + " elements. \n");
        Iterator<Device> iterator = store.iterator();

        while (iterator.hasNext())
            st.append(iterator.next() + "\n");
        return st.toString();

    }
}
