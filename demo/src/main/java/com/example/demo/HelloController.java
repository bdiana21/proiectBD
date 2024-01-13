package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class HelloController {
    @FXML
    private Button cancelButton;

    @FXML
    private Label loginMessageLabel;
    @FXML
    private TextField cnpTextField;
    @FXML
    private PasswordField parolaPasswordField;
    
    public void loginButtonOnAction(ActionEvent e){
        if(cnpTextField.getText().isBlank()==false && parolaPasswordField.getText().isBlank()==false){
           // loginMessageLabel.setText("Ai incercat sa te conectezi");
            validateLogin();
        }
        else{
            loginMessageLabel.setText("Completati username ul si parola");
        }
    }
    public void cancelButtonOnAction(ActionEvent e){
        Stage stage= (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void validateLogin(){
        DatabaseConnection connectNow =new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String verifyLogin = "select rol_user from utilizatori where CNP='"+cnpTextField.getText() + "' and parola='" + parolaPasswordField.getText()+ "'";
        try{
            Statement statement =connectDB.createStatement();
            ResultSet result = statement.executeQuery(verifyLogin);

            while(result.next()){
                String userRol=result.getString("rol_user");
                if(userRol.equals("asistent")){
                   // loginMessageLabel.setText("asistent");
                    fereastraAsistent();
                }
                else if(userRol.equals("medic")){
                    fereastraMedic();
                    //loginMessageLabel.setText("medic");
                }
                else if(userRol.equals("hr")){
                   // loginMessageLabel.setText("hr");
                    fereastraHr();
                }
                else if(userRol.equals("receptioner")){
                  //  loginMessageLabel.setText("receptioner");
                    fereastraReceptioner();
                }
                else if(userRol.equals("admin")){
                  //  loginMessageLabel.setText("admin");
                    fereastraAdmin();
                }
                else if(userRol.equals("superadmin")){
                    //loginMessageLabel.setText("superadmin");
                    fereastraSuperadmin();
                }
                else if(userRol.equals("economic")){
                   // loginMessageLabel.setText("economic");
                    fereastraEconomic();
                }
                else if(userRol.equals("pacient")){
                  //  loginMessageLabel.setText("pacient");
                    fereastraPacient();
                }
                else{
                    loginMessageLabel.setText("autentificare nereusita");
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void fereastraAsistent(){
        try{
            FXMLLoader asistent = new FXMLLoader(HelloApplication.class.getResource("asistent.fxml"));
            Scene scene = new Scene(asistent.load(), 600, 400);
            Stage stageAsistent=new Stage();
            stageAsistent.setTitle("Asistent");
            stageAsistent.setScene(scene);
            stageAsistent.show();

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
    public void fereastraMedic(){
        try{
            FXMLLoader medic = new FXMLLoader(HelloApplication.class.getResource("medic.fxml"));
            Scene scene = new Scene(medic.load(), 600, 400);
            Stage stageMedic=new Stage();
            stageMedic.setTitle("Medic");
            stageMedic.setScene(scene);
            stageMedic.show();

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
    public void fereastraPacient(){
        try{
            FXMLLoader pacient = new FXMLLoader(HelloApplication.class.getResource("pacient.fxml"));
            Scene scene = new Scene(pacient.load(), 600, 400);
            Stage stagePacient=new Stage();

            stagePacient.setTitle("Pacient");
            stagePacient.setScene(scene);
            stagePacient.show();

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
    public void fereastraHr(){
        try{
            FXMLLoader hr = new FXMLLoader(HelloApplication.class.getResource("hr.fxml"));
            Scene scene = new Scene(hr.load(), 600, 400);
            Stage stageHr=new Stage();

            stageHr.setTitle("HR");
            stageHr.setScene(scene);
            stageHr.show();

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
    public void fereastraReceptioner(){
        try{
            FXMLLoader receptioner = new FXMLLoader(HelloApplication.class.getResource("receptioner.fxml"));
            Scene scene = new Scene(receptioner.load(), 600, 400);
            Stage stagereceptioner=new Stage();

            stagereceptioner.setTitle("Receptioner");
            stagereceptioner.setScene(scene);
            stagereceptioner.show();

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
    public void fereastraEconomic(){
        try{
            FXMLLoader economic = new FXMLLoader(HelloApplication.class.getResource("economic.fxml"));
            Scene scene = new Scene(economic.load(), 600, 400);
            Stage stageeconomic=new Stage();

            stageeconomic.setTitle("Econimic");
            stageeconomic.setScene(scene);
            stageeconomic.show();

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
    public void fereastraAdmin(){
        try{
            FXMLLoader admin = new FXMLLoader(HelloApplication.class.getResource("admin.fxml"));
            Scene scene = new Scene(admin.load(), 600, 400);
            Stage stageadmin=new Stage();

            stageadmin.setTitle("Admin");
            stageadmin.setScene(scene);
            stageadmin.show();

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
    public void fereastraSuperadmin(){
        try{
            FXMLLoader superadmin = new FXMLLoader(HelloApplication.class.getResource("superadmin.fxml"));
            Scene scene = new Scene(superadmin.load(), 600, 400);
            Stage stagesuperadmin=new Stage();

            stagesuperadmin.setTitle("SuperAdmin");
            stagesuperadmin.setScene(scene);
            stagesuperadmin.show();

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

}