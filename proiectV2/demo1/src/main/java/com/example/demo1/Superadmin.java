package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Superadmin
{
    @FXML
    private Button inapoiButton;
    @FXML
    private Button BDPSUPADMIN;
    @FXML
    private Button BMDPSUPADMIN;
    @FXML
    private Button BADSSUPADMIN;
    @FXML
    private Button BMDSSUPADMIN;
    @FXML
    private Button BSDSSUPADMIN;
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
        hideButtonBDPSUPADMIN();
        hideButtonBMDPSUPADMIN();
        hideButtonBADSSUPADMIN();
        hideButtonBMDSSUPADMIN();
        hideButtonBSDSSUPADMIN();
        inapoiMeniuButton.setVisible(false);
    }
    public void BDPSUPADMINonAction(ActionEvent e)
    {
        hideButtonBDPSUPADMIN();
        inapoiMeniuButton.setVisible(true);
        inapoiButton.setVisible(false);
    }

    private void hideButtonBDPSUPADMIN()
    {
        boolean isBDPSUPADMINoNPressed = BDPSUPADMIN.isArmed() || BDPSUPADMIN.isPressed();

        BMDPSUPADMIN.setVisible(!isBDPSUPADMINoNPressed);
        BADSSUPADMIN.setVisible(!isBDPSUPADMINoNPressed);
        BMDSSUPADMIN.setVisible(!isBDPSUPADMINoNPressed);
        BSDSSUPADMIN.setVisible(!isBDPSUPADMINoNPressed);
    }

    public void BMDPSUPADMINonAction(ActionEvent e)
    {
        hideButtonBMDPSUPADMIN();
        inapoiMeniuButton.setVisible(true);
        inapoiButton.setVisible(false);
    }

    private void hideButtonBMDPSUPADMIN()
    {
        boolean isBMDPSUPADMINPressed = BMDPSUPADMIN.isArmed() || BMDPSUPADMIN.isPressed();

        BDPSUPADMIN.setVisible(!isBMDPSUPADMINPressed);
        BADSSUPADMIN.setVisible(!isBMDPSUPADMINPressed);
        BMDSSUPADMIN.setVisible(!isBMDPSUPADMINPressed);
        BSDSSUPADMIN.setVisible(!isBMDPSUPADMINPressed);
    }

    public void BADSSUPADMINonAction(ActionEvent e)
    {
        hideButtonBADSSUPADMIN();
        inapoiMeniuButton.setVisible(true);
        inapoiButton.setVisible(false);
    }

    private void hideButtonBADSSUPADMIN()
    {
        boolean isBADSSUPADMINPressed = BADSSUPADMIN.isArmed() || BADSSUPADMIN.isPressed();

        BDPSUPADMIN.setVisible(!isBADSSUPADMINPressed);
        BMDPSUPADMIN.setVisible(!isBADSSUPADMINPressed);
        BMDSSUPADMIN.setVisible(!isBADSSUPADMINPressed);
        BSDSSUPADMIN.setVisible(!isBADSSUPADMINPressed);
    }

    public void BMDSSUPADMINonAction(ActionEvent e)
    {
        hideButtonBMDSSUPADMIN();
        inapoiMeniuButton.setVisible(true);
        inapoiButton.setVisible(false);
    }

    private void hideButtonBMDSSUPADMIN()
    {
        boolean isBMDSSUPADMINPressed = BMDSSUPADMIN.isArmed() || BMDSSUPADMIN.isPressed();

        BDPSUPADMIN.setVisible(!isBMDSSUPADMINPressed);
        BMDPSUPADMIN.setVisible(!isBMDSSUPADMINPressed);
        BADSSUPADMIN.setVisible(!isBMDSSUPADMINPressed);
        BSDSSUPADMIN.setVisible(!isBMDSSUPADMINPressed);
    }

    public void BSDSSUPADMINonAction(ActionEvent e)
    {
        hideButtonBSDSSUPADMIN();
        inapoiMeniuButton.setVisible(true);
        inapoiButton.setVisible(false);
    }

    private void hideButtonBSDSSUPADMIN()
    {
        boolean isBSDSSUPADMINPressed = BSDSSUPADMIN.isArmed() || BSDSSUPADMIN.isPressed();

        BDPSUPADMIN.setVisible(!isBSDSSUPADMINPressed);
        BMDPSUPADMIN.setVisible(!isBSDSSUPADMINPressed);
        BADSSUPADMIN.setVisible(!isBSDSSUPADMINPressed);
        BMDSSUPADMIN.setVisible(!isBSDSSUPADMINPressed);
    }
}