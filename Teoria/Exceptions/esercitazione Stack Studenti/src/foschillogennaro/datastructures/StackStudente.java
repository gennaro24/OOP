package foschillogennaro.datastructures;

import foschillogennaro.exceptions.EmptyStackException;
import foschillogennaro.exceptions.FullStackException;

import java.util.Stack;

public class StackStudente {
    private Stack<Studente> st;
    private int capienza;

    public StackStudente(int capienza) throws IllegalArgumentException{
        if (capienza < 0)
            throw new IllegalArgumentException("VALORE MINORE DI 0");
        this.capienza = capienza;
        st = new Stack<>();
    }
    public StackStudente(){
        this.capienza = 50;
        st = new Stack<>();
    }


    public boolean isEmpty(){
        return (st.isEmpty());
    }
    public void push(Studente s) throws FullStackException {
        if (st.capacity() == capienza)
            throw new FullStackException("ERRORE: STACK PIENO");
        st.push(s);
    }
    public Studente pop() throws EmptyStackException {
        if (st.isEmpty())
            throw new EmptyStackException("ERRORE: STACK VUOTO");
        return st.pop();
    }
}
