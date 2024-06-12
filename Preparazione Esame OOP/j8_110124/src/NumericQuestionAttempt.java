
/*Un tentativo di risposta alla domanda da parte dell’utente `e rappresentato dalla classe
NumericQuestionAttempt che ha come attributi question di tipo NumericQuestion e
givenAnswer - la risposta numerica formulata dall’utente come esatta. Scegliere i tipi di dato opportuni.
 Oltre ai metodi getter di utilit`a per la visualizzazione, la classe NumericQuestionAttempt
dovr`a prevedere almeno il metodo boolean isCorrect() - che verifica se la risposta data corrisponde a quella esatta -
e il metodo String getResult() - che restituisce la stringa ”Corretto”
o ”Sbagliato” sulla base della correttezza della risposta fornita.*/

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class NumericQuestionAttempt {
    private final NumericQuestion question;
    private final int givenAnswer;
    private final boolean correct;


    NumericQuestionAttempt(int givenAnswer , NumericQuestion question){
        this.question = question;
        this.givenAnswer = givenAnswer;
        correct = givenAnswer == question.getResult();
    }

    public int getGivenAnswer() {
        return givenAnswer;
    }

    public boolean isCorrect() {
        return correct;
    }

    public StringProperty answerProperty (){
        return new SimpleStringProperty(question.toString() + " = " + givenAnswer);
    }
    public StringProperty esitoProperty(){
        return new SimpleStringProperty(toString());
    }

    @Override
    public String toString() {
        return isCorrect() ? "corretto" : "sbagliato";
    }
}
