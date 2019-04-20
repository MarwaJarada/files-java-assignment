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

    JButton saveBtn;
    JButton cancelBtn;

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
        saveBtn=new JButton("Save To my File");
        cancelBtn=new JButton("Cancel");
        add(accountNameLabel);
        add(nametxt);
        add(accountNumLabel);
        add(numtxt);
        add(accountBalanceLabel);
        add(balancrtxt);
        add(saveBtn);
        add(cancelBtn);
        ActionListener actionListener=new ActionListener();
        saveBtn.addActionListener(actionListener);
        cancelBtn.addActionListener(actionListener);
        setVisible(true);

    }

    public class ActionListener implements java.awt.event.ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            String myAction = actionEvent.getActionCommand().toLowerCase();
            switch (myAction){
                case "save to my file":
                    try {
                        fileOutputStream=new FileOutputStream("D:\\4thSemester\\" +
                                "Programming3\\file\\Objects file" +
                                ".txt",true);
                        objectOutputStream=new ObjectOutputStream(fileOutputStream);
                        Account myAccount=new Account(nametxt.getText(),
                                 Float.parseFloat(balancrtxt.getText()),
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
                    break;
                case "cancel":

                    break;


            }
        }
    }
}
