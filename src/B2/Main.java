package B2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ManagerAccount managerAccount = new ManagerAccount();
        int choice = -1;
        while (choice!=0) {
            System.out.println("Menu:\n1. Login\n2. Register\n3. Show");
            System.out.println("Nhập lựa chọn: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 -> {
                    System.out.println("Nhập username login: ");
                    String usernameLogin = scanner.nextLine();
                    System.out.println("Nhập password login: ");
                    String passwordLogin = scanner.nextLine();
                    managerAccount.login(usernameLogin, passwordLogin);
                }
                case 2 -> {
                    System.out.println("Nhập username đăng ký: ");
                    String usernameRegister = scanner.nextLine();
                    System.out.println("Nhập password đăng ký: ");
                    String passwordRegister = scanner.nextLine();
                    managerAccount.register(usernameRegister, passwordRegister);
                }
                case 3 -> managerAccount.show();
                default -> {
                }
            }
        }
    }
}
