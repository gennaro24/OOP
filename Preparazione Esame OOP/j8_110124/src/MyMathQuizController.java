

import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.control.cell.TextFieldTreeTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MyMathQuizController implements Initializable {
    /*===================SCHERMATA ACCOUNTING===================*/
    @FXML
    AnchorPane schermataAccounting;
    @FXML
    TextField nome;
    @FXML
    TextField cognome;
    @FXML
    TextField numeroDomande;
    @FXML
    Button inizia;
    /*===================SCHERMATA DOMANDE===================*/
    @FXML
    AnchorPane schermataDomande;
    @FXML
    Label domanda;
    @FXML
    TextField risposta;
    @FXML
    Label numeroDomanda;
    @FXML
    Button fatto;
    /*===================SCHERMATA RIEPILOGO===================*/
    @FXML
    VBox schermataRiepilogo;
    @FXML
    TableView<NumericQuestionAttempt> riepilogo;
    @FXML
    TableColumn<NumericQuestionAttempt , String> colonnaRisposta;
    @FXML
    TableColumn<NumericQuestionAttempt , String> colonnaSoluzione;
    @FXML
    Label riepilogoTesto;
    @FXML
    Button esporta;


    /*=========LOGICA DOMANDE=========*/
    private ArrayList<NumericQuestion> listadomande;
    private ArrayList<NumericQuestionAttempt> listaRisposte;
    private int numero;
    private int indice = 0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        schermataAccounting.setVisible(true);
        schermataDomande.setVisible(false);
        schermataRiepilogo.setVisible(false);

        BooleanBinding bottoneInizia = Bindings.createBooleanBinding(() -> nome.getText().isEmpty() || cognome.getText().isEmpty() || numeroDomande.getText().isEmpty() , nome.textProperty() , cognome.textProperty() , numeroDomande.textProperty()) ;
        BooleanBinding bottoneFatto = Bindings.createBooleanBinding(() -> risposta.getText().isEmpty() , risposta.textProperty());

        inizia.disableProperty().bind(bottoneInizia);
        fatto.disableProperty().bind(bottoneFatto);

        /*========================================INIZIALIZZA LA TABELLA==========================================*/

        colonnaSoluzione.setCellValueFactory(cellData -> cellData.getValue().answerProperty());
        colonnaRisposta.setCellValueFactory(cellData -> cellData.getValue().esitoProperty());

        colonnaRisposta.setCellFactory(TextFieldTableCell.forTableColumn());
        colonnaSoluzione.setCellFactory(TextFieldTableCell.forTableColumn());


        ObservableList<NumericQuestionAttempt> listAttempt = FXCollections.observableArrayList();
        riepilogo.setItems(listAttempt);




    }
    @FXML
    public void iniziaButton(){
        schermataAccounting.setVisible(false);
        schermataDomande.setVisible(true);
        numero = Integer.parseInt(numeroDomande.getText());

        listadomande = new ArrayList<>();
        for (int i = 0; i < numero; i++) {
            listadomande.add(new NumericQuestion());
        }
        listaRisposte = new ArrayList<>();

        if ( Integer.parseInt(numeroDomande.getText().toString()) <= 0 ){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("errore");
            a.setHeaderText("errore");
            a.setContentText("NUMERO DOMANDE NON VALIDO!");
            a.showAndWait();
            numeroDomande.clear();
        }

        else {
            domanda.setText(listadomande.get(indice).toString() + " = ?");
            numeroDomanda.setText("1/" + numeroDomande);
        }
    }
    @FXML
    public void cliccaFatto(){
        if (indice < numero) {
            domanda.setText(listadomande.get(indice).toString() + " = ?");
            numeroDomanda.setText((indice + 1) + "/" + numeroDomande);
            listaRisposte.add(new NumericQuestionAttempt(Integer.parseInt(risposta.getText()), listadomande.get(indice)));
            riepilogo.getItems().add(listaRisposte.get(indice));
            indice++;
        } else{

            schermataRiepilogo.setVisible(true);
            schermataDomande.setVisible(false);
        }
    }
    @FXML
    public void mostraRiepilogo(){
        riepilogoTesto.setText("Gentile" + nome.getText() + " " + cognome.getText() + " , Grazie per aver completato il quiz. Esporta le domande su file.");
        schermataRiepilogo.setVisible(true);
        schermataDomande.setVisible(false);
    }
}
