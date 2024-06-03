import java.util.Comparator;

public class DefaultComparator implements Comparator<EQEvent> {
    @Override
    public int compare(EQEvent o1, EQEvent o2) {
        return Integer.compare( Integer.parseInt (o1.getEventID()), Integer.parseInt (o2.getEventID()));
    }
}
