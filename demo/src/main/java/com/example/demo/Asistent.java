package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

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

    public void inapoiButtonOnAction(ActionEvent e)
    {
        Stage stage= (Stage)inapoiButton.getScene().getWindow();
        stage.close();
    }

    public void initialize()
    {
        hideButtonBGRU();
        hideButtonOFC();
        hideButtonBGAO();
    }

    public void BGRUOnAction(ActionEvent e)
    {
        hideButtonBGRU();
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
    }

    private void hideButtonOFC()
    {
        boolean isBOFCPressed = BOFC.isArmed() || BOFC.isPressed();

        BOFCSA.setVisible(isBOFCPressed);
        BGRU.setVisible(!isBOFCPressed);
        BGAO.setVisible(!isBOFCPressed);
    }

    public void BGAOonAction(ActionEvent e)
    {
        hideButtonBGAO();
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