package com.example.mid_term2324_otp_service;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.Serializable;
import java.util.Objects;

/**
* la classe contact concretizza un contatto da aggiungere nella rubrica.
* Implementa un metodo equals che verifica quando due contatti sono uguali
* @author Foschillo Gennaro
*/
public class Contact implements Serializable {
    private String nome;
    private String cognome;
    private String numero;


    public Contact(){}
    public Contact(String nome, String cognome, String numero) {
        this.nome = nome;
        this.cognome = cognome;
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getNumero() {
        return numero;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public StringProperty nomeProperty() {
        return new SimpleStringProperty(nome);
    }

    public StringProperty cognomeProperty() {
        return new SimpleStringProperty(cognome);
    }

    public StringProperty numeroProperty() {
        return new SimpleStringProperty(numero);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Contact other) {
            return Objects.equals(nome, other.nome) &&
                    Objects.equals(cognome, other.cognome) &&
                    Objects.equals(numero, other.numero);
        }
        return false;
    }

    public String toString() {
        return getNome() +";"+ getCognome() +";"+ getNumero();
    }
}
