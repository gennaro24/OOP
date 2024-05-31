package foschillogennaro;

import foschillogennaro.datastructures.StackStudente;
import foschillogennaro.datastructures.Studente;
import foschillogennaro.exceptions.EmptyStackException;
import foschillogennaro.exceptions.FullStackException;
import foschillogennaro.exceptions.StackException;

public class TestStudente {
    public static void main(String args[]) {
        try {
            StackStudente s = new StackStudente();
            try {
                s.push(new Studente("M9283", "Giovanni Rana", 23.3423));
                s.toString();
                s.pop();
            } catch (EmptyStackException es) {
                es.printStackTrace();
            } catch (FullStackException fs) {
                fs.printStackTrace();
            } catch (StackException se) {
                se.printStackTrace();
            }
        } catch (IllegalArgumentException iae) {
            iae.printStackTrace();
        }
    }
}
