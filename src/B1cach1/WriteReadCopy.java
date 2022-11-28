package B1cach1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//cach 1: dung file Reader
public class WriteReadCopy {
    static  Scanner scanner = new Scanner(System.in);
    private String txt;

    public void writeFile() {
        try {
            FileWriter fileWriter = new FileWriter("hello",true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(txt);
            bufferedWriter.close();
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    List<String> strings = new ArrayList<>();
    public String readFile() {
        try {
            FileReader fileReader = new FileReader("hello");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line ="";
            while(true) {
                line = bufferedReader.readLine();
                if(line == null) {
                    break;
                }
                strings.add(line);
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<String> copyFile() {

        try {
            FileWriter fileWriter = new FileWriter("copy",true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(strings.get(0));
            bufferedWriter.close();
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strings;
    }

//    private static void copyFileJava(File source, File dest) throws IOException {
//        Files.copy(source.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
//    }

    public static void main(String[] args) {
        System.out.println("Nhap chuoi");
        WriteReadCopy write = new WriteReadCopy();
        write.txt = scanner.nextLine();
        System.out.println("Nhap lua chon");
        int choice;
        while(true) {
            System.out.println("Menu\n" +
                    "1. Write\n" +
                    "2. Read\n" +
                    "3. Copy");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    write.writeFile();
                    break;
                case 2:
                    write.readFile();
                    break;
                case 3:
                    write.copyFile();
                    break;
            }
        }



//        File filecopy = new File("hello");
//        File filepage = new File("copy");
//
//        try {
//            copyFileJava(filecopy, filepage);
//            System.out.println("copy thanh cong");
//        } catch (IOException e) {
//        }
    }

}
