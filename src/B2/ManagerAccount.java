package B2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ManagerAccount {
    List<Account> accounts = new ArrayList<>();
    List<Account> accountList = new ArrayList<>();

    public void show() {
        for (Account account : accounts) {
            System.out.println(account.toString());
        }
    }

    //    tạo hàm đăng ký:
    public void register(String username, String password) {
        accounts = readFile();
        if (checkUsername(username)) {
            System.out.println("Username đã tồn tại!");
        } else {
            accounts.add(new Account(username, password));
            System.out.println(accounts);
            writeFile();
            readFile();
            System.out.println("Đăng ký thành công!");
        }
    }

    //  viết vào file:
    public void writeFile() {
        try {
            FileOutputStream fos = new FileOutputStream("account.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(accounts);

            oos.close();
            fos.close();

        } catch (Exception e) {
            System.out.println("Loi roi lewlew");
        }
    }

    // tạo hàm đọc file:
    public List<Account> readFile() {
        try {
            FileInputStream fis = new FileInputStream("account.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            accountList = (List<Account>) ois.readObject();

        } catch (Exception e) {
            System.out.println("Loi roi lewlew");
        }
        return accountList;
    }

    // tạo hàm check username:
    public boolean checkUsername(String username) {
        for (Account account : accounts)
            if (account.getUsername().equals(username)) {
                return true;
            }
        return false;
    }

    //    tạo hàm check username & password:
    public boolean checkLogin(String username, String password) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getUsername().equals(username) && accounts.get(i).getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }


    //    tạo hàm đăng nhập:
    public void login(String username, String password) {
        accounts = readFile();
        if (checkLogin(username, password)) {
            System.out.println("Đăng nhập thành công!");
        } else System.out.println("Đăng nhập thất bại!");
    }

}
