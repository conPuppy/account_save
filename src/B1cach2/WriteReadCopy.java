package B1cach2;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WriteReadCopy {


    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        Student student1 = new Student("Linh",19,"nam");
        Student student2 = new Student("Nam",20,"nam");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("text.bin",true);
            AppendableObjectOutputStream objectOutputStream = new AppendableObjectOutputStream(fileOutputStream, true);
            students.add(student1);
            students.add(student2);

            objectOutputStream.writeObject(students);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileInputStream fileInputStream = new FileInputStream("text.bin");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            while (true) {
                ArrayList<Student> ketqua = (ArrayList<Student>) objectInputStream.readObject();
                System.out.println(ketqua);
            }

        } catch (Exception e) {
            System.out.println("Loi roi");
        }

    }

}
