package assignment.task1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;

/**
 * @author Marwa N. Jarada
 */

public class SaveFileSwing extends JFrame {
    FileWriter fileWriter;
    PrintWriter printWriter;
    JMenuBar mainMenu;
    JMenu fileMenu;
    JMenu editMenu;
    JMenuItem save;
    JMenuItem exit;
    JMenuItem open;
    JMenuItem close;
    JMenuItem font;
    JMenuItem color;
    JScrollPane scrollPan;
    JTextArea fileTxt;
    JFileChooser fileChooser;
    JFileChooser fileChooser2;
    Color colorChooser;
    File selectedFile;

    public SaveFileSwing() {

        setLocationRelativeTo(null);
        setSize(400, 250);
        setResizable(true);
        setTitle("File Processing");


        mainMenu = new JMenuBar();
        fileMenu = new JMenu("File");
        save = new JMenuItem("Save");
        save.addActionListener(actionListener);
        editMenu = new JMenu("Edit");
        exit = new JMenuItem("Exit");
        exit.addActionListener(actionListener);
        open = new JMenuItem("Open");
        open.addActionListener(actionListener);
        close = new JMenuItem("Close");
        close.addActionListener(actionListener);
        font = new JMenuItem("Font");
        font.addActionListener(actionListener);
        color = new JMenuItem("Color");
        color.addActionListener(actionListener);


        open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
        close.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_MASK));
        font.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.CTRL_MASK));
        save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));


        fileMenu.add(open);
        fileMenu.add(save);
        fileMenu.add(close);
        fileMenu.add(exit);

        editMenu.add(font);
        editMenu.add(color);
        mainMenu.add(fileMenu);
        mainMenu.add(editMenu);
        this.setJMenuBar(mainMenu);
        fileTxt = new JTextArea();
        scrollPan = new JScrollPane(fileTxt);
        scrollPan.setPreferredSize(new Dimension(400, 250));
        this.add(scrollPan);


        setVisible(true);

    }


    public static void main(String[] args) {
        SaveFileSwing saveFileSwing = new SaveFileSwing();

    }

    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {

            String action = actionEvent.getActionCommand().toLowerCase();
            switch (action) {
                case "open":
                    openFileChooser();
                    break;
                case "exit":
                    System.exit(0);
                    break;
                case "close":
                    fileTxt.setText(null);
                    fileTxt.setEditable(false);
                    break;
                case "font":
                    showFontDailog();
                    break;
                case "color":

                    colorChooser = JColorChooser.showDialog(SaveFileSwing.this,
                            "Choose Font color :",
                            Color.YELLOW);
                    fileTxt.setForeground(colorChooser);
                    break;
                case "save":
                    try {
                        writeContentinFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;


            }
        }
    };


    public void showFontDailog() {
        int fontSize = (int) JOptionPane.showInputDialog(null, "Select font size", "Fonr size", JOptionPane.OK_CANCEL_OPTION,
                null,
                new Integer[]{12, 14, 16, 18},
                15);
        fileTxt.setFont(new Font("Tahoma", 0, fontSize));

    }

    public void openFileChooser() {
        fileChooser = new JFileChooser();
        fileChooser.showDialog(SaveFileSwing.this, "Select");
        try {
            selectedFile = fileChooser.getSelectedFile();
            Scanner scanner = new Scanner(selectedFile);
            while (scanner.hasNext()) {
                fileTxt.append(scanner.nextLine());


            }
            fileTxt.setEditable(true);
        } catch (Exception e) {
            System.out.println("Empty File");
        }


    }

    public void writeContentinFile() throws IOException {
        try {
            fileChooser2 = new JFileChooser();
            fileChooser2.showSaveDialog(SaveFileSwing.this);
            File choosed = fileChooser.getSelectedFile();
            fileWriter = new FileWriter(choosed);
            printWriter = new PrintWriter(fileWriter);
            printWriter.println(fileTxt.getText());

        } catch (IOException e) {
            System.out.println("Error IOException");


        }finally {

            fileWriter.close();
            printWriter.close();
        }

    }
}