package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Receptioner {

    @FXML
    private Button inapoiButton;
    @FXML
    private Button BGRU;
    @FXML
    private Button BGRUDPR;
    @FXML
    private Button BGRUMDPR;
    @FXML
    private Button BGRUCR;
    @FXML
    private Button BOFC;
    @FXML
    private Button BOFCVSR;
    @FXML
    private Button BGAO;
    @FXML
    private Button BGAOCPR;
    @FXML
    private Button BGAOEBFR;
    @FXML
    private Button inapoiMeniuButton;
    @FXML
    public Label numeLabel;

    public void setUserData(ResultSet result) throws SQLException {
        String userNume = result.getString("Nume");
        String userPrenume = result.getString("Prenume");
        numeLabel.setText("User: " +userNume+" "+userPrenume);
    }

    public void inapoiButtonOnAction(ActionEvent e){
        Stage stage= (Stage)inapoiButton.getScene().getWindow();
        stage.close();
    }

    public void inapoiMeniuButtonOnAction(ActionEvent e){
        initialize();
        inapoiButton.setVisible(true);
    }

    public void initialize()
    {
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

        BGRUDPR.setVisible(isBGRUPressed);
        BGRUMDPR.setVisible(isBGRUPressed);
        BGRUCR.setVisible(isBGRUPressed);
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

        BOFCVSR.setVisible(isBOFCPressed);
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

        BGAOCPR.setVisible(isBGAOPressed);
        BGAOEBFR.setVisible(isBGAOPressed);
        BGRU.setVisible(!isBGAOPressed);
        BOFC.setVisible(!isBGAOPressed);
    }
}
