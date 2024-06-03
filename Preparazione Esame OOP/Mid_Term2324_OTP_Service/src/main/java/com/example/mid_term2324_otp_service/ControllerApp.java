package com.example.mid_term2324_otp_service;

import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ControllerApp implements Initializable {
    //VARIABILI FXML
    /*============================schermata 1====================================*/
    @FXML  AnchorPane schermata_otp;
    @FXML  TextField  otpInserito;
    @FXML  Label      otpGenerato;
    @FXML  Button     sblocca;
    /*============================schermata 2====================================*/
    @FXML  HBox       schermata_2;
    @FXML  TableView<Contact>            tabella;
    @FXML  TableColumn<Contact , String> colonnaNome;
    @FXML  TableColumn<Contact , String> colonnaCognome;
    @FXML  TableColumn<Contact , String> colonnaNumero;
    @FXML TextField inserisciNome;
    @FXML TextField inserisciCognome;
    @FXML TextField inserisciNumero;
    @FXML Button    aggiungiContatto;

    //VARIABILI SERVICE
    SimpleStringProperty stringOTP = new SimpleStringProperty();
    OTPService serviceOTP = new OTPService(stringOTP);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //inizializza l'applicazione rendendo visibile solo la schermata dell'otp
        schermata_otp.setVisible(true);
        schermata_2.setVisible(false);
        serviceOTP.start();

        otpGenerato.textProperty().bind(stringOTP); // permette di aggiornare il campo OTP legando il suo valore a quello passato al service
        BooleanBinding sbloccoAttivo = Bindings.createBooleanBinding(() -> !otpInserito.getText().equals(otpGenerato.getText()) , otpGenerato.textProperty() , otpInserito.textProperty()  );
        sblocca.disableProperty().bind(sbloccoAttivo); //abilita il bottone solo se viene verificato il binding "sbloccoattivo"

        // rende le celle modificabili con doppio click
        colonnaNome.setCellFactory(TextFieldTableCell.forTableColumn());
        colonnaCognome.setCellFactory(TextFieldTableCell.forTableColumn());
        colonnaNumero.setCellFactory(TextFieldTableCell.forTableColumn());
        colonnaNumero.setCellValueFactory(cellData -> cellData.getValue().numeroProperty());
        colonnaCognome.setCellValueFactory(cellData -> cellData.getValue().cognomeProperty());
        colonnaNome.setCellValueFactory(cellData -> cellData.getValue().nomeProperty());

        colonnaNome.setVisible(true);
        colonnaCognome.setVisible(true);
        colonnaNumero.setVisible(true);

        //imposta una lista di Contact all'interno della tabella rendendola modificabile.
        ObservableList<Contact> lista = FXCollections.observableArrayList();
        tabella.setItems(lista);
        tabella.setEditable(true);
        tabella.setVisible(true);

        /*       ================BINDING PER L'AGGIUNTA DI CONTATTI========================   */
        /*
        * l'oggetto unlockAggiungiContatto crea un binding che ritorna un tipo booleano, verificato se uno dei 3 campi è vuoto.
        * */
        BooleanBinding unlockAggiungiContatto = Bindings.createBooleanBinding(() ->
                inserisciNome.getText().isEmpty() || inserisciCognome.getText().isEmpty() || inserisciNumero.getText().isEmpty() , inserisciCognome.textProperty() , inserisciCognome.textProperty() , inserisciNumero.textProperty());
        aggiungiContatto.disableProperty().bind(unlockAggiungiContatto);

    }

    /*=====================================abilitazione applicazione: metodo per lo sblocco=====================================*/

    @FXML
    public void sbloccaApp(){
        schermata_otp.setVisible(false);
        schermata_2.setVisible(true);
        serviceOTP.cancel();
    }
/*=====================================================PRESSIONE BOTTONE AGGIUNGI CONTATTO=====================================*/
    @FXML
    public void aggiungiContatto(){
        boolean is = false;
        Contact c = new Contact(inserisciNome.getText() , inserisciCognome.getText() , inserisciNumero.getText());
        if (!tabella.getItems().isEmpty()) {
            for (Contact cont : tabella.getItems()) {
                if (cont.equals(c)) {
                    setAllert(Alert.AlertType.ERROR, "ERRORE", "ERRORE", "contatto esistente!");
                    inserisciCognome.clear();
                    inserisciNome.clear();
                    inserisciNumero.clear();
                    is = true;
                    break;
                }

            }
            if (!is ){
                tabella.getItems().add(c);
            }

        }  else
            tabella.getItems().add(c);

        inserisciCognome.clear();
        inserisciNome.clear();
        inserisciNumero.clear();



    }
    @FXML
    public void salvaListaContatti(){
        writeContactList("lista.txt");
    }
    @FXML
    public void copiaContatto(){
        Contact c = tabella.getSelectionModel().getSelectedItem();
        Clipboard clipboard = Clipboard.getSystemClipboard();
        ClipboardContent  content = new ClipboardContent();
        content.putString(c.toString());
        clipboard.setContent(content);
    }
    @FXML
    public void esci(){
        Platform.exit();
    }
    @FXML
    public void eliminaContatto() {
        Contact c = tabella.getSelectionModel().getSelectedItem();
        tabella.getItems().remove(c);
    }






    /*================================UTILITIES===========================*/
    public void writeContactList(String filename){
        try{
            ObjectOutputStream obj = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(filename)));
            ArrayList<Contact> list = new ArrayList<>(tabella.getItems());
            obj.writeObject(list);
        }catch (IOException ex){setAllert(Alert.AlertType.ERROR , "ERRORE" , "ERRORE" , "Impossibile salvare il file!");}
    }

    public ArrayList<Contact> readContactList(String filename){
        ArrayList<Contact> lista = new ArrayList<>() ;
        try{
            ObjectInputStream obj = new ObjectInputStream(new BufferedInputStream(new FileInputStream(filename)));
            lista = new ArrayList<>((ArrayList<Contact>)obj.readObject());
        }catch (IOException | ClassNotFoundException E){setAllert(Alert.AlertType.ERROR , "ERRORE" , "ERRORE" , "Impossibile caricare i dati!");}
        return lista;
    }

    public void setAllert(Alert.AlertType type , String title , String header , String content){
        Alert a = new Alert(type);
        a.setTitle(title);
        a.setHeaderText(header);
        a.setContentText(content);
        a.showAndWait();
    }
}