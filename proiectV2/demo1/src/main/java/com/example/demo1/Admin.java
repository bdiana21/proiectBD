package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Admin {

    @FXML
    private Button inapoiButton;
    @FXML
    private Button BDPADMIN;
    @FXML
    private Button BMDPADMIN;
    @FXML
    private Button BADSADMIN;
    @FXML
    private Button BMDSADMIN;
    @FXML
    private Button BSDSADMIN;
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
    public void inapoiMeniuButtonOnAction(ActionEvent e){
        initialize();
        inapoiButton.setVisible(true);
    }

    public void initialize()
    {
        hideButtonBDPADMIN();
        hideButtonBMDPADMIN();
        hideButtonBADSADMIN();
        hideButtonBMDSADMIN();
        hideButtonBSDSADMIN();
        inapoiMeniuButton.setVisible(false);
    }
    public void BDPADMINonAction(ActionEvent e)
    {
        hideButtonBDPADMIN();
        inapoiMeniuButton.setVisible(true);
        inapoiButton.setVisible(false);
    }

    private void hideButtonBDPADMIN()
    {
        boolean isBDPADMINoNPressed = BDPADMIN.isArmed() || BDPADMIN.isPressed();

        BMDPADMIN.setVisible(!isBDPADMINoNPressed);
        BADSADMIN.setVisible(!isBDPADMINoNPressed);
        BMDSADMIN.setVisible(!isBDPADMINoNPressed);
        BSDSADMIN.setVisible(!isBDPADMINoNPressed);
    }

    public void BMDPADMINonAction(ActionEvent e)
    {
        hideButtonBMDPADMIN();
        inapoiMeniuButton.setVisible(true);
        inapoiButton.setVisible(false);
    }

    private void hideButtonBMDPADMIN()
    {
        boolean isBMDPADMINPressed = BMDPADMIN.isArmed() || BMDPADMIN.isPressed();

        BDPADMIN.setVisible(!isBMDPADMINPressed);
        BADSADMIN.setVisible(!isBMDPADMINPressed);
        BMDSADMIN.setVisible(!isBMDPADMINPressed);
        BSDSADMIN.setVisible(!isBMDPADMINPressed);
    }

    public void BADSADMINonAction(ActionEvent e)
    {
        hideButtonBADSADMIN();
        inapoiMeniuButton.setVisible(true);
        inapoiButton.setVisible(false);
    }

    private void hideButtonBADSADMIN()
    {
        boolean isBADSADMINPressed = BADSADMIN.isArmed() || BADSADMIN.isPressed();

        BDPADMIN.setVisible(!isBADSADMINPressed);
        BMDPADMIN.setVisible(!isBADSADMINPressed);
        BMDSADMIN.setVisible(!isBADSADMINPressed);
        BSDSADMIN.setVisible(!isBADSADMINPressed);
    }

    public void BMDSADMINonAction(ActionEvent e)
    {
        hideButtonBMDSADMIN();
        inapoiMeniuButton.setVisible(true);
        inapoiButton.setVisible(false);
    }

    private void hideButtonBMDSADMIN()
    {
        boolean isBMDASADMINPressed = BMDSADMIN.isArmed() || BMDSADMIN.isPressed();

        BDPADMIN.setVisible(!isBMDASADMINPressed);
        BMDPADMIN.setVisible(!isBMDASADMINPressed);
        BADSADMIN.setVisible(!isBMDASADMINPressed);
        BSDSADMIN.setVisible(!isBMDASADMINPressed);
    }

    public void BSDSADMINonAction(ActionEvent e)
    {
        hideButtonBSDSADMIN();
        inapoiMeniuButton.setVisible(true);
        inapoiButton.setVisible(false);
    }

    private void hideButtonBSDSADMIN()
    {
        boolean isBSDSADMINPressed = BSDSADMIN.isArmed() || BSDSADMIN.isPressed();

        BDPADMIN.setVisible(!isBSDSADMINPressed);
        BMDPADMIN.setVisible(!isBSDSADMINPressed);
        BADSADMIN.setVisible(!isBSDSADMINPressed);
        BMDSADMIN.setVisible(!isBSDSADMINPressed);
    }

}
