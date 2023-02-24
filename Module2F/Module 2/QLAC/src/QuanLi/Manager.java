package QuanLi;

import KhoiTaoDoiTuong.Account;

import java.util.Scanner;

public class Manager {
    Account[] accounts = new Account[0];
    Scanner scanner = new Scanner(System.in);

    public void show(){
        for (int i = 0; i < accounts.length; i++) {
            System.out.println(accounts[i].toString());

        }
    }

    public void add(Account account){
        Account[] newArr = new  Account[accounts.length+1];
        for (int i = 0; i < accounts.length; i++) {
            newArr[i] = accounts[i];
        }
        newArr[accounts.length-1] = account;
        accounts = newArr;
    }

    public void createAccount(){
        System.out.println("Enter id");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter username");
        String username = scanner.nextLine();
        System.out.println("Enter password");
        String password = scanner.nextLine();
        System.out.println("Enter phone");
        String phone = scanner.nextLine();
        System.out.println("Enter DateBirthDay");
        String birthDay = scanner.nextLine();
    }
    public int findIndexByName(String username){
        for (int i = 0; i < accounts.length; i++) {
            if (username.equals(accounts[i].getUsername())){
                return i;
            }
        }
        return -1;
    }
    public void edit(String username) {
        int index = findIndexByName(username);
        switch (index) {
            case 1:
                System.out.println("1.Change id");
            case 2:
                System.out.println("2.Change username");
            case 3:
                System.out.println("3.Change password");
            case 4:
                System.out.println("4.Change phone");
            case 5:
                System.out.println("5.Change dateBirthday");
        }

    }
}
