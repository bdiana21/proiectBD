package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Medic {

    @FXML
    private Button inapoiButton;
    @FXML
    private Button BGRU;
    @FXML
    private Button BGRUDPM;
    @FXML
    private Button BGRUMDPM;
    @FXML
    private Button BGRUCM;
    @FXML
    private Button BOFC;
    @FXML
    private Button BOFCPPM;
    @FXML
    private Button BOFCPAPM;
    @FXML
    private Button BOFCSM;
    @FXML
    private Button BGAO;
    @FXML
    private Button BGAOVPM;
    @FXML
    private Button BGAOGRMM;
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

        BGRUDPM.setVisible(isBGRUPressed);
        BGRUMDPM.setVisible(isBGRUPressed);
        BGRUCM.setVisible(isBGRUPressed);
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

        BOFCPPM.setVisible(isBOFCPressed);
        BOFCPAPM.setVisible(isBOFCPressed);
        BOFCSM.setVisible(isBOFCPressed);
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

        BGAOVPM.setVisible(isBGAOPressed);
        BGAOGRMM.setVisible(isBGAOPressed);
        BGRU.setVisible(!isBGAOPressed);
        BOFC.setVisible(!isBGAOPressed);
    }
}
