package com.example.sustain;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

public class HomeController {

    // Define the user interface
    @FXML
    private void accountButtonOnAction(ActionEvent event) {
        System.out.println("Your account details");
    }

    @FXML
    private void rewardButtonOnAction(ActionEvent event) {
        System.out.println("Rewards available");
    }

    @FXML
    private void binsButtonOnAction(ActionEvent event) {
        System.out.println("Bins available");
    }

    // Event handler method using FXML
    @FXML
    private void cancelButtonOnAction(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
