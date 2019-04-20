package task5;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class LoginController {
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

                //todo login done successfully
                return;
            }else {
                readLine = bufferedReader.readLine();
            }

        }



    }

}
