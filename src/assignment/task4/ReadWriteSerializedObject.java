package assignment.task4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;


import static java.lang.Float.*;

/**
 * @author Marwa N. Jarada
 */

public class ReadWriteSerializedObject extends JFrame{
    JLabel accountNameLabel;
    JLabel accountNumLabel;
    JLabel accountBalanceLabel;

    JTextField nametxt;
    JTextField numtxt;
    JTextField balancrtxt;

    JButton writeBtn;
    JButton readlBtn;

    // Classes we will use to read/write our objects from/into file

    FileOutputStream fileOutputStream;
    ObjectOutputStream objectOutputStream;
    FileInputStream fileInputStream;
    ObjectInputStream objectInputStream;

    public static void main(String[] args) throws FileNotFoundException {
        ReadWriteSerializedObject readWriteSerializedObject=new ReadWriteSerializedObject();

    }


    public ReadWriteSerializedObject(){
        setLocationRelativeTo(null);
        setSize(300,150);
        setLayout(new GridLayout(4,2,6,0));
        accountNameLabel=new JLabel("Enter Account Name:");
        accountNumLabel=new JLabel("Enter Account Number :");
        accountBalanceLabel=new JLabel("Enter Balance Number :");
        nametxt=new JTextField();
        numtxt=new JTextField();
        balancrtxt=new JTextField();
        writeBtn=new JButton("Write");
        readlBtn=new JButton("Read");
        add(accountNameLabel);
        add(nametxt);
        add(accountNumLabel);
        add(numtxt);
        add(accountBalanceLabel);
        add(balancrtxt);
        add(writeBtn);
        add(readlBtn);
        ActionListener actionListener=new ActionListener();
        writeBtn.addActionListener(actionListener);
        readlBtn.addActionListener(actionListener);
        setVisible(true);

    }

    public class ActionListener implements java.awt.event.ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            String myAction = actionEvent.getActionCommand().toLowerCase();
            switch (myAction){
                case "write":
                    writeAccountObject();
                    break;
                case "read":
                    try {
                        readAccountObject();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }
    }

    public void writeAccountObject(){
        try {
            fileOutputStream=new FileOutputStream("D:\\4thSemester\\" +
                    "Programming3\\file\\Objects file" +
                    ".ser");
            objectOutputStream=new ObjectOutputStream(fileOutputStream);
            Account myAccount=new Account(nametxt.getText(),
                    Double.parseDouble(balancrtxt.getText()),
                    Integer.parseInt(numtxt.getText()));

            objectOutputStream.writeObject(myAccount);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                fileOutputStream.close();
                objectOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void readAccountObject() throws IOException {
        try {
            fileInputStream=new FileInputStream("D:\\4thSemester\\" +
                    "Programming3\\file\\Objects file" +
                    ".ser");
            objectInputStream = new ObjectInputStream(fileInputStream);
            System.out.println(objectInputStream.readObject());
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            fileInputStream.close();
            objectInputStream.close();
        }
    }
}
