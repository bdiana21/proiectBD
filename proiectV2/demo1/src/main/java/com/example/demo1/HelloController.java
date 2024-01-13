package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
            loginMessageLabel.setText("Completati username-ul si parola!");
        }
    }
    public void cancelButtonOnAction(ActionEvent e){
        Stage stage= (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void validateLogin() {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
        String verifyLogin = "select ID_Utilizator,Nume,Prenume,rol_user from utilizatori where CNP='"+cnpTextField.getText() + "' and parola='" + parolaPasswordField.getText()+ "'";
        try {
            Statement statement = connectDB.createStatement();
            ResultSet result = statement.executeQuery(verifyLogin);

            while (result.next()) {
                String userRol = result.getString("rol_user");
                if (userRol.equals("asistent")) {
                    fereastraAsistent(result);

                }
                else if (userRol.equals("medic")) {
                    fereastraMedic(result);
                }
                else if (userRol.equals("hr")) {
                    fereastraHr(result);
                }
                else if (userRol.equals("receptioner")) {
                    fereastraReceptioner(result);

                }
                else if (userRol.equals("admin")) {
                    fereastraAdmin(result);
                }
                else if (userRol.equals("superadmin")) {
                    fereastraSuperadmin(result);
                }
                else if (userRol.equals("economic")) {
                    fereastraEconomic(result);

                }
                else if (userRol.equals("pacient")) {
                    fereastraPacient(result);

                }
                else {
                    loginMessageLabel.setText("autentificare nereusita");

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void fereastraAsistent( ResultSet result){
        try{
            FXMLLoader asistent = new FXMLLoader(com.example.demo1.HelloApplication.class.getResource("asistent.fxml"));
            Scene scene = new Scene(asistent.load(), 600, 400);
            Stage stageAsistent= new Stage();
            stageAsistent.setTitle("Asistent");
            stageAsistent.setScene(scene);
            Asistent asis = asistent.getController();
            asis.setUserData(result);
            stageAsistent.show();

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
    public void fereastraMedic( ResultSet result){
        try{
            FXMLLoader medic = new FXMLLoader(com.example.demo1.HelloApplication.class.getResource("medic.fxml"));
            Scene scene = new Scene(medic.load(), 600, 400);
            Stage stageMedic=new Stage();
            stageMedic.setTitle("Medic");
            stageMedic.setScene(scene);
            Medic m = medic.getController();
            m.setUserData(result);
            stageMedic.show();

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
    public void fereastraPacient( ResultSet result){
        try{
            FXMLLoader pacient = new FXMLLoader(com.example.demo1.HelloApplication.class.getResource("pacient.fxml"));
            Scene scene = new Scene(pacient.load(), 600, 400);
            Stage stagePacient=new Stage();
            stagePacient.setTitle("Pacient");
            stagePacient.setScene(scene);
            Pacient p = pacient.getController();
            p.setUserData(result);
            stagePacient.show();

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
    public void fereastraHr( ResultSet result){
        try{
            FXMLLoader hr = new FXMLLoader(com.example.demo1.HelloApplication.class.getResource("hr.fxml"));
            Scene scene = new Scene(hr.load(), 600, 400);
            Stage stageHr=new Stage();
            stageHr.setTitle("HR");
            stageHr.setScene(scene);
            Hr h = hr.getController();
            h.setUserData(result);
            stageHr.show();

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
    public void fereastraReceptioner( ResultSet result){
        try{
            FXMLLoader receptioner = new FXMLLoader(com.example.demo1.HelloApplication.class.getResource("receptioner.fxml"));
            Scene scene = new Scene(receptioner.load(), 600, 400);
            Stage stagereceptioner=new Stage();
            stagereceptioner.setTitle("Receptioner");
            stagereceptioner.setScene(scene);
            Receptioner r = receptioner.getController();
            r.setUserData(result);
            stagereceptioner.show();

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
    public void fereastraEconomic( ResultSet result){
        try{
            FXMLLoader economic = new FXMLLoader(com.example.demo1.HelloApplication.class.getResource("economic.fxml"));
            Scene scene = new Scene(economic.load(), 600, 400);
            Stage stageeconomic=new Stage();
            stageeconomic.setTitle("Econimic");
            stageeconomic.setScene(scene);
            Economic e = economic.getController();
            e.setUserData(result);
            stageeconomic.show();

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
    public void fereastraAdmin( ResultSet result){
        try{
            FXMLLoader admin = new FXMLLoader(com.example.demo1.HelloApplication.class.getResource("admin.fxml"));
            Scene scene = new Scene(admin.load(), 600, 400);
            Stage stageadmin=new Stage();
            stageadmin.setTitle("Admin");
            stageadmin.setScene(scene);
            Admin a = admin.getController();
            a.setUserData(result);
            stageadmin.show();

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
    public void fereastraSuperadmin( ResultSet result){
        try{
            FXMLLoader superadmin = new FXMLLoader(com.example.demo1.HelloApplication.class.getResource("superadmin.fxml"));
            Scene scene = new Scene(superadmin.load(), 600, 400);
            Stage stagesuperadmin=new Stage();
            stagesuperadmin.setTitle("SuperAdmin");
            stagesuperadmin.setScene(scene);
            Superadmin s = superadmin.getController();
            s.setUserData(result);
            stagesuperadmin.show();

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

}