package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Asistent {

    @FXML
    private Button inapoiButton;

    @FXML
    private Button BGRU;
    @FXML
    private Button BGRUDPA;
    @FXML
    private Button BGRUMDPA;
    @FXML
    private Button BGRUCA;
    @FXML
    private Button BOFC;
    @FXML
    private Button BOFCSA;
    @FXML
    private Button BGAO;
    @FXML
    private Button BGAOVPA;
    @FXML
    private Button BGAOCRA;
    @FXML
    private Button inapoiMeniuButton;
    @FXML
    public Label numeLabel;

    public void setUserData(ResultSet result) throws SQLException {
        String userNume = result.getString("Nume");
        String userPrenume = result.getString("Prenume");
        numeLabel.setText("User: " +userNume+" "+userPrenume);
    }

    public void inapoiButtonOnAction(ActionEvent e)
    {
        Stage stage= (Stage)inapoiButton.getScene().getWindow();
        stage.close();
    }

    public void inapoiMeniuButtonOnAction(ActionEvent e) throws InstantiationException, IllegalAccessException {
        initialize();
        inapoiButton.setVisible(true);
    }

    public void initialize() throws InstantiationException, IllegalAccessException {
        hideButtonBGRU();
        hideButtonOFC();
        hideButtonBGAO();
        inapoiMeniuButton.setVisible(false);

    }

    public void BGRUonAction(ActionEvent e)
    {
        hideButtonBGRU();
        inapoiMeniuButton.setVisible(true);
        inapoiButton.setVisible(false);
    }

    private void hideButtonBGRU()
    {
        boolean isBGRUPressed = BGRU.isArmed() || BGRU.isPressed();

        BGRUDPA.setVisible(isBGRUPressed);
        BGRUMDPA.setVisible(isBGRUPressed);
        BGRUCA.setVisible(isBGRUPressed);
        BGAO.setVisible(!isBGRUPressed);
        BOFC.setVisible(!isBGRUPressed);

    }

    public void BOFConAction(ActionEvent e)
    {
        hideButtonOFC();
        inapoiMeniuButton.setVisible(true);
        inapoiButton.setVisible(false);
    }

    private void hideButtonOFC()
    {
        boolean isBOFCPressed = BOFC.isArmed() || BOFC.isPressed();

        BOFCSA.setVisible(isBOFCPressed);
        BGRU.setVisible(!isBOFCPressed);
        BGAO.setVisible(!isBOFCPressed);
    }

    public void BGAonAction(ActionEvent e)
    {
        hideButtonBGAO();
        inapoiMeniuButton.setVisible(true);
        inapoiButton.setVisible(false);
    }

    private void hideButtonBGAO()
    {
        boolean isBGAOPressed = BGAO.isArmed() || BGAO.isPressed();

        BGAOVPA.setVisible(isBGAOPressed);
        BGAOCRA.setVisible(isBGAOPressed);
        BGRU.setVisible(!isBGAOPressed);
        BOFC.setVisible(!isBGAOPressed);
    }
}

