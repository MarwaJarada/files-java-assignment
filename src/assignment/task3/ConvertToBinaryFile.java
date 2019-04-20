package assignment.task3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.io.*;

public class ConvertToBinaryFile extends JFrame {
    JTextArea textArea;
    JButton openFileBtn;
    JButton convertBtn;
    JFileChooser fileChooser;
    File selectedFile;
    FileOutputStream fileOutputStream;
    DataOutputStream dataOutputStream;

    public ConvertToBinaryFile()  {
        setTitle("Convert File into binary");
        setLayout(new FlowLayout());
        setLocationRelativeTo(null);
        setSize(400, 240);
        setResizable(true);
        textArea=new JTextArea();
        textArea.setPreferredSize(new Dimension(300,150));
        convertBtn=new JButton("Convert File");
        convertBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    fileOutputStream=new FileOutputStream(selectedFile,true);
                    dataOutputStream=new DataOutputStream(fileOutputStream);
                    dataOutputStream.writeChars(textArea.getText());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
        convertBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        openFileBtn=new JButton("Open File");
        openFileBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                openFileChooser();
            }
        });
        add(textArea);
        add(openFileBtn);
        add(convertBtn);
        setVisible(true);


    }

    public void openFileChooser() {
        fileChooser = new JFileChooser();
        fileChooser.showDialog(this, "Select");
        try {
            selectedFile = fileChooser.getSelectedFile();
            Scanner scanner = new Scanner(selectedFile);
            while (scanner.hasNext()) {
                textArea.append(scanner.nextLine());


            }
            textArea.setEditable(true);
        } catch (Exception e) {
            System.out.println("Empty File");
        }


    }

    public static void main(String[] args) {
        ConvertToBinaryFile convertToBinaryFile=new ConvertToBinaryFile();
    }
}
