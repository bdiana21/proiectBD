package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Pacient {

    @FXML
    private Button inapoiButton;
    private Button BMDP;
    @FXML
    private Button BDPP;
    @FXML
    private Button BPP;
    @FXML
    private Button BRMP;
    @FXML
    private Button inapoiMeniuButton;
    @FXML
    public Label numeLabel;
    private int id;

    public void setId(int id) {
        this.id = id;
    }

    public void setUserData(ResultSet result) throws SQLException {
        String userNume = result.getString("Nume");
        String userPrenume = result.getString("Prenume");
        numeLabel.setText("User: " +userNume+" "+userPrenume);
        setId(result.getInt("ID_Utilizator"));
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
        hideButtonBMDP();
        hideButtonBDPP();
        hideButtonBPP();
        hideButtonBRMP();
        inapoiMeniuButton.setVisible(false);
    }
    public void BMDPonAction(ActionEvent e)
    {
        hideButtonBMDP();
        inapoiMeniuButton.setVisible(true);
        inapoiButton.setVisible(false);
    }

    private void hideButtonBMDP()
    {
        boolean isBMDPressed = BMDP.isArmed() || BMDP.isPressed();

        BMDP.setVisible(!isBMDPressed);
        BPP.setVisible(!isBMDPressed);
        BRMP.setVisible(!isBMDPressed);
    }
    public void BDPPonAction(ActionEvent e)
    {
        hideButtonBMDP();
        inapoiMeniuButton.setVisible(true);
        inapoiButton.setVisible(false);
        fereastraDatePersonale(id);
    }

    private void hideButtonBDPP()
    {
        boolean isBDPPressed = BDPP.isArmed() || BDPP.isPressed();

        BDPP.setVisible(!isBDPPressed);
        BPP.setVisible(!isBDPPressed);
        BRMP.setVisible(!isBDPPressed);
    }

    public void BPPonAction(ActionEvent e)
    {
        hideButtonBPP();
        inapoiMeniuButton.setVisible(true);
        inapoiButton.setVisible(false);
    }

    private void hideButtonBPP()
    {
        boolean isBPPPressed = BPP.isArmed() || BPP.isPressed();

        BMDP.setVisible(!isBPPPressed);
        BDPP.setVisible(!isBPPPressed);
        BRMP.setVisible(!isBPPPressed);
    }


    public void BRMPonAction(ActionEvent e)
    {
        hideButtonBRMP();
        inapoiMeniuButton.setVisible(true);
        inapoiButton.setVisible(false);
    }

    private void hideButtonBRMP()
    {
        boolean isBRMPPressed = BRMP.isArmed() || BRMP.isPressed();

        BMDP.setVisible(!isBRMPPressed);
        BDPP.setVisible(!isBRMPPressed);
        BPP.setVisible(!isBRMPPressed);
    }

    public void fereastraDatePersonale(int id){
        try{
            FXMLLoader date = new FXMLLoader(com.example.demo1.HelloApplication.class.getResource("datePersonale.fxml"));
            Scene scene = new Scene(date.load(), 1150, 148);
            DatePersonale d = date.getController();
            d.setID(id);
            Stage stageDate= new Stage();
            stageDate.setTitle("Date Personale");
            stageDate.setScene(scene);

            stageDate.show();

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
}
