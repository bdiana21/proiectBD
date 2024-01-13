package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Hr {

    @FXML
    private Button inapoiButton;
    @FXML
    private Button BGRU;
    @FXML
    private Button BGRUDPHR;
    @FXML
    private Button BGRUMDHR1;
    @FXML
    private Button BGRUDAHR;
    @FXML
    private Button BOFC;
    @FXML
    private Button BOFCSHR;
    @FXML
    private Button BOFCSAHR;
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

        BGRUDPHR.setVisible(isBGRUPressed);
        BGRUMDHR1.setVisible(isBGRUPressed);
        BGRUDAHR.setVisible(isBGRUPressed);
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

        BOFCSHR.setVisible(isBOFCPressed);
        BOFCSAHR.setVisible(isBOFCPressed);
        BGRU.setVisible(!isBOFCPressed);
    }
}
