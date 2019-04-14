package lab;


import java.io.*;
import java.util.Scanner;

public class test {

    public static void main(String[] args) throws IOException {
        String myContent="";
        File file=null;
        FileInputStream reader=null;
        Scanner sc = null;
        File newFile=null;
        FileWriter fileWriter=null;
        PrintWriter printWriter=null;


        try {
            file =  new File("D:\\4thSemester\\Programming3\\file\\src\\lab\\test.txt");
            reader = new FileInputStream(file);
            sc = new Scanner(reader);
            while (sc.hasNextLine())
                myContent += sc.nextLine();




            System.out.println(myContent);
             newFile=new File("D:\\4thSemester\\Programming3\\file\\src\\lab\\myNewFile.txt");
            fileWriter=new FileWriter(newFile,true);
            printWriter=new PrintWriter(fileWriter);

            printWriter.println(myContent);



        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);

        }finally {
            sc.close();
            reader.close();
            fileWriter.close();

        }






    }
}
