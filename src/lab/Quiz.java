package lab;
import javafx.scene.layout.FlowPane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Quiz extends JFrame{

    JTextArea textArea;
    JTextField textField;
    JButton button;

    public Quiz(){
        JPanel panel=new JPanel(new FlowLayout());

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setSize(400,200);
        this.setLayout(new BorderLayout());

        textArea=new JTextArea("Here is the text area ...");
        textField=new JTextField("", 10);
        button=new JButton("Open File ");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ReadUsingFileInputStreamSccaner(textField.getText(),textArea);
            }
        });

        textArea.setSize(200,150);

        this.add(textArea,BorderLayout.CENTER);
        panel.add(textField);
        panel.add(button);
        this.add(panel,BorderLayout.SOUTH);
        this.setVisible(true);


    }

    public static void ReadUsingFileInputStreamSccaner(String fileName, JTextArea textArea){
        try {
            File file =  new File(fileName);
            FileInputStream reader = new FileInputStream(file);

            Scanner sc = new Scanner(reader);

            while (sc.hasNextLine())
                textArea.append(sc.nextLine());
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
    }

    public static void main(String[] args) {
        Quiz quiz=new Quiz();

    }
}
