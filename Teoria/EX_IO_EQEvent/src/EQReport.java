import java.io.*;
import java.util.*;

public class EQReport {
    private final ArrayList<EQEvent> report;
    private String nomereport;
    public EQReport(String nomereport){
        this.nomereport = nomereport;
        report = new ArrayList<>();
    }

    public String getNomereport() {
        return nomereport;
    }

    public void addEvent(EQEvent e){
         report.add(e);
     } //– per aggiungere un nuovo evento alla collezione;
     public void sort(){
         report.sort(new DefaultComparator());
     } //- per ordinare gli eventi secondo l’ordine dettato da EventID crescente
     public void sort(Comparator<EQEvent> c){
        report.sort(c);
     } //– per ordinare gli eventi secondo un ordine definito da un comparatore passato come parametro
    public static EQReport readFromTextFile(String filename) {
        EQReport report = new EQReport(filename);
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split("\\|");
                EQEvent event = new EQEvent(
                        fields[0],
                        fields[1],
                        fields[2],
                        fields[3],
                        Double.parseDouble(fields[4]),
                        fields[5],
                        fields[6],
                        fields[7],
                        fields[8],
                        fields[9],
                        Double.parseDouble(fields[10]),
                        fields[11],
                        fields[12]
                );
                report.addEvent(event);
            }
        } catch (IOException e) {e.printStackTrace();}
        return report;
    }//– per ottenereun report mediante lettura di un file di testo il cui nome è passato come parametro
     public static void printToTextFile(EQReport eqr, String filename){
        try{
            DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(filename)));
            int size = eqr.report.size();

            for (int i = 0 ; i < size ; i++){
                dos.writeUTF(eqr.report.get(i).getEventID() + "|" + eqr.report.get(i).getTime() + "|"+ eqr.report.get(i).getLatitude() + "|"+ eqr.report.get(i).getLongitude() + "|"+ eqr.report.get(i).getDepthKm() + "|"+ eqr.report.get(i).getAuthor() + "|"+ eqr.report.get(i).getCatalog() + "|"+ eqr.report.get(i).getContributor() + "|"+ eqr.report.get(i).getContributorID() + "|"+ eqr.report.get(i).getMagType() + "|"+ eqr.report.get(i).getMagnitude() + "|"+ eqr.report.get(i).getMagAuthor() + "|"+ eqr.report.get(i).getEventLocation());
                dos.writeUTF("\n");
            }
            dos.close();

        }catch (IOException exc){exc.printStackTrace();}
        }//-per scrivere un report passato come parametro su un file di testo il cui nome è passato come parametro

        public String toString(){
            StringBuilder sb = new StringBuilder();
            for (EQEvent event : report)
                sb.append(event + "\n");
            return sb.toString();
        }

     }


