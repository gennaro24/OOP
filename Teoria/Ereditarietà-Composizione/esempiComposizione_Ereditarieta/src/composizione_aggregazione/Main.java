package composizione_aggregazione;



// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Motore m3 = new Motore(3000 , 300);
        Auto BMW_M3 = new Auto(m3 , "M3");
        System.out.println(BMW_M3);

    }
}