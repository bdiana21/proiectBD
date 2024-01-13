package com.example.demo1;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatePersonale {
    @FXML
    private TableView tabel;

    @FXML
    private TableColumn tabelAdresa;

    @FXML
    private TableColumn tabelCNP;

    @FXML
    private TableColumn tabelData;

    @FXML
    private TableColumn tabelEmail;

    @FXML
    private TableColumn tabelIban;

    @FXML
    private TableColumn tabelNrContract;

    @FXML
    private TableColumn tabelNume;

    @FXML
    private TableColumn tabelPrenume;

    @FXML
    private TableColumn tabelRol;

    @FXML
    private TableColumn tabelTelefon;

    public void setUserData(ResultSet result) throws SQLException {
        int userID = result.getInt("ID_Utilizator");
        String getData = "select Nume from utilizatori where ID_Utilizator=result.getInt(\"ID_Utilizator\")";

        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        try {
            Statement statement = connectDB.createStatement();
            ResultSet result2 = statement.executeQuery(getData);

            while (result2.next()) {
                String userNume = result2.getString("Nume");
                tabelNume.setText(userNume);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
