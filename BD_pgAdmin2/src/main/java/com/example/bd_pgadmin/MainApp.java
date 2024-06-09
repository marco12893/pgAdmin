package com.example.bd_pgadmin;

import com.example.bd_pgadmin.database.DatabaseConnection;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        Label label = new Label("Data from Database:");
        Button button = new Button("Load Data");
        VBox vbox = new VBox(label, button);

        button.setOnAction(e -> {
            try (Connection connection = DatabaseConnection.getConnection()) {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM data_jemaat");

                StringBuilder data = new StringBuilder();
                while (resultSet.next()) {
                    data.append(resultSet.getString("nij")).append("\n");
                    data.append(resultSet.getString("nama")).append("\n");
                    data.append(resultSet.getString("Tempat/Tanggal_lahir")).append("\n");
                    data.append(resultSet.getString("alamat")).append("\n");
                    data.append(resultSet.getString("no_tlp")).append("\n");
                    data.append(resultSet.getString("konta_ortu")).append("\n");
                    data.append(resultSet.getString("Member_Perpustakaan:_Y/N")).append("\n");
                }
                label.setText(data.toString());
            } catch (SQLException ex) {
                ex.printStackTrace();
                label.setText("Failed to load data");
            }
        });

        Scene scene = new Scene(vbox, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFX and PostgreSQL");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}