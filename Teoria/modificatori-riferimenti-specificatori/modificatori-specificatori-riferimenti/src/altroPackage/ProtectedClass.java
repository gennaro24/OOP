package altroPackage;
// classe con attributi e metodi statici
public class ProtectedClass {
    private static int staticAttributo;
    static{
        staticAttributo = 0;
        System.out.println("caricamento in memoria DELLA CLASSE ProtectedClass che parte dal numero: " + staticAttributo);
    }
    protected static void PrivateClassSOMMA(String stringa1 , String stringa2){
        System.out.println("METODO SOMMA STRINGHE: "  +  stringa1 + " "+ stringa2 + "\n");
    }
    protected static void PrivateClassSOMMA(int numero1 , int numero2){
        System.out.println("METODO SOMMA NUMERI: "  +  (numero1+numero2));
    }
}
