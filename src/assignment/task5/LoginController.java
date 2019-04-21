package assignment.task5;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class LoginController {
    @FXML
    AnchorPane loginPage;
    @FXML
    AnchorPane optionPage;
    @FXML
    Button okBtn;
    @FXML
    Button cancelBtn;
    @FXML
    Label nameLabel;
    @FXML
    Label passwordLabel;
    @FXML
    TextField nameTxtField;
    @FXML
    PasswordField passwordTxtField;

    public void exitAction() {
        System.exit(0);
    }
    public void okAction() throws IOException {
        FileReader fileReader=new FileReader("accounts File.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String readLine=bufferedReader.readLine();
        while (readLine!=null){
            String[] split=readLine.split(" ");


            System.out.println(split[0]);
            System.out.println(split[1]);
            if ((split[0].equals(nameTxtField.getText()))&&
                    (Integer.parseInt(split[1])==passwordTxtField.getText().hashCode())){
                System.out.println("done");
                loadScene("view/page_option.fxml");
                return;
            }else {
                readLine = bufferedReader.readLine();
            }

        }



    }

    public void loadScene(String fxmlPath) throws IOException {
        Stage window=(Stage)loginPage.getScene().getWindow();
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource(fxmlPath));
        Parent parent=fxmlLoader.load();
        Scene scene=new Scene(parent);
        window.setScene(scene);

    }

}
