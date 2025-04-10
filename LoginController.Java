package com.example.sustain;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    // Define user interface
    @FXML
    private Button cancelButton;
    @FXML
    private Button registerButton;
    @FXML
    private Label loginMessageLabel;
    @FXML
    private ImageView brandingImageView;
    @FXML
    private ImageView lockImageView;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField enterPasswordField;

    // Initialize the images to be shown
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        File brandingFile = new File("@../../../../../../../../../Images/FrontCover.png");
        Image brandingImage = new Image(brandingFile.toURI().toString());
        brandingImageView.setImage(brandingImage);

        File lockFile = new File("@../../../../../../../../../Images/Padlock.png");
        Image lockImage = new Image(lockFile.toURI().toString());
        lockImageView.setImage(lockImage);
    }

    // Create login button
    public void loginButtonOnAction(ActionEvent event){
        if (!usernameTextField.getText().isBlank() && !enterPasswordField.getText().isBlank()){
            validateLogin();
        } else {
            loginMessageLabel.setText("Please enter username and password");
        }
    }

    // Create cancel button
    public void cancelButtonOnAction(ActionEvent event){
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    // Create register button to change between the scenes
    public void registerButtonOnAction(ActionEvent event){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("register.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            Stage stage = (Stage) registerButton.getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Register");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    // Validate login for user
    public void validateLogin(){
        String username = usernameTextField.getText();
        String password = enterPasswordField.getText();

        if (UserDatabase.validateLogin(username, password)) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("home.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 600, 400);
                Stage stage = (Stage) loginMessageLabel.getScene().getWindow();
                stage.setScene(scene);
                stage.setTitle("Home");
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
                loginMessageLabel.setText("Failed to load Home page.");
            }
        } else {
            loginMessageLabel.setText("Invalid login. Please try again");
        }
    }

}
