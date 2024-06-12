package foschillogennaro.esame_110124;

import java.util.Random;

/*Una domanda numerica `e rappresentata dalla classe NumericQuestion che deve presentare almeno gli attributi
num1, num2 - gli operandi interi - e operator - un carattere che rappresenta
l’operatore (+ o -). Scegliere per essi un tipo di dato che si ritiene opportuno, prevedendo accesso
privato. Prevedere getter per tutti gli attributi. Prevedere inoltre un metodo randomInit() che
consente di inizializzare gli operandi e l’operatore in maniera randomica (in modo da generare
una domanda random). Pu`o essere utile predisporre un metodo getResult() che restituisce il
risultato dell’operazione. Ridefinire in maniera conveniente il metodo toString().
*/
public class NumericQuestion {
    private int num1;
    private int num2;
    private String operator;
    private int result;

    public NumericQuestion(){
        Random r1 = new Random();
        Random r2 = new Random();
        Random r3 = new Random();

        num1 = r1.nextInt(0,50);
        num2 = r2.nextInt(0,50);
        if (r3.nextBoolean()){
            operator = "+";
            result = num1 + num2;
        }
        else {
            operator = "-";
            result = num1 - num2;
        }
    }

    public int getNum1() {
        return num1;
    }

    public int getNum2() {
        return num2;
    }

    public String getOperator() {
        return operator;
    }

    public int getResult() {
        return result;
    }

    @Override
    public String toString() {
        return num1 + " " + operator + " " +num2;
    }
}
