package com.example.sustain;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {

    // Define the user interface
    @FXML
    private ImageView shieldImageView;
    @FXML
    private Button closeButton;
    @FXML
    private Label registrationMessageLabel;
    @FXML
    private PasswordField setPasswordField;
    @FXML
    private PasswordField confirmPasswordField;
    @FXML
    private Label confirmPasswordLabel;
    @FXML
    private TextField firstnameTextField;
    @FXML
    private TextField lastnameTextField;
    @FXML
    private TextField usernameTextField;
    @FXML
    private Button loginBackButton;

    // Images
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        File shieldFile = new File("@../../../../../../../../../Images/Shield.png");
        Image shieldImage = new Image(shieldFile.toURI().toString());
        shieldImageView.setImage(shieldImage);
    }

    // Transitions the user back to the login screen
    public void registerButtonOnAction(ActionEvent event){
        if (setPasswordField.getText().equals(confirmPasswordField.getText())) {
            String username = usernameTextField.getText();
            String password = setPasswordField.getText();
            String firstname = firstnameTextField.getText();
            String lastname = lastnameTextField.getText();

            if (!UserDatabase.userExists(username)) {
                User user = new User(firstname, lastname, password);
                UserDatabase.registerUser(username, user);
                registrationMessageLabel.setText("User registered!");
                confirmPasswordLabel.setText("");
            } else {
                registrationMessageLabel.setText("Username already exists!");
            }
        } else {
            confirmPasswordLabel.setText("Password does not match");
        }
    }

    // Cancel the application
    public void closeButtonOnAction(ActionEvent event){
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
        Platform.exit();
    }

    // Method to go back to login.fxml
    public void loginBackButtonOnAction(ActionEvent event){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("login.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            Stage stage = (Stage) loginBackButton.getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Login");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
