public class EQRTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {


        EQReport eq = EQReport.readFromTextFile("src/query");

        System.out.println(eq);

        eq.sort(new MagnitudeComparator());
        System.out.println("LISTA ORDINATA PER MAGNITUDO: \n" + eq);

        EQReport.printToTextFile(eq, "sorted.txt");

        EQReport eq1  = EQReport.readFromTextFile("sorted.txt");
        System.out.println("TEST READ ORDINATA: \n");



        // TODO code application logic heres
    }

}