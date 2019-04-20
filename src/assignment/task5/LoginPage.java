package assignment.task5;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

/**
 * @author Marwa N. Jarada
 */

public class LoginPage extends Application{


    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("view/page_login.fxml"));
        FXMLLoader loader2=new FXMLLoader(getClass().getResource("view/page_option.fxml"));
        Parent parent=loader.load();
        Scene scene=new Scene(parent);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Options Page");
        primaryStage.show();


    }

    public static void main(String[] args) throws IOException {
        accountsFile();
        launch(args);
    }
    public static void accountsFile() throws IOException {
        File file =new File ("accounts File.txt");
        ArrayList<Account> accounts = new ArrayList<>();
        accounts.add(new Account("admin","admin"));
        accounts.add(new Account("marwa","123456"));
        FileWriter fileWriter=new FileWriter(file,true);
        PrintWriter printWriter =new PrintWriter(fileWriter);
        for (int x=0 ; x<accounts.size();x++) {
            printWriter.println(accounts.get(x).getName() +" "+ accounts.get(x).getPassword().hashCode());
        }
        fileWriter.close();
        printWriter.close();



    }

}

