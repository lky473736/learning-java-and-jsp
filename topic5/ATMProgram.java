/*
    학습공동체 2024-2 JAVA
    임규연 (lky473736)
    
    2주차 : ATM 시스템 만들기 (OOP)
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.text.DecimalFormat;

public class ATMProgram {
    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.start();
    }
}

class User {
    private String userID;
    private String pin;
    private double balance;

    public User(String userID, String pin, double balance) {
        this.userID = userID;
        this.pin = pin;
        this.balance = balance;
    }

    public String getUserID() {
        return userID;
    }

    public boolean validatePin(String inputPin) {
        return this.pin.equals(inputPin);
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
}

class ATM {
    private User currentUser;
    private List<User> users;
    private Scanner scanner;
    private DecimalFormat df;

    public ATM() {
        users = new ArrayList<>();
        
        users.add(new User("admin", "0000", 1000.0)); // 예시 사용자 1
        users.add(new User("daramji", "0000", 2000.0)); // 예시 사용자 2
        
        scanner = new Scanner(System.in);
        df = new DecimalFormat("0.00");
    }

    public void start() {
        while (true) {
            if (authenticateUser()) {
                showMenu();
            } 
            
            else {
                System.out.println("인증이 실패하였습니다");
            }
        }
    }

    private boolean authenticateUser() {
        System.out.print("사용자 ID : ");
        String userID = scanner.nextLine();
        
        System.out.print("PIN : ");
        String pin = scanner.nextLine();

        for (User user : users) {
            if (user.getUserID().equals(userID) && user.validatePin(pin)) { // id랑 pin이랑 맞으면?
                currentUser = user;
                return true;
            }
        }
        return false;
    }

    private void showMenu() {
        while (true) {
            System.out.println("\n1. 잔액 조회");
            System.out.println("2. 입금");
            System.out.println("3. 출금");
            System.out.println("4. 종료");
            System.out.print("메뉴를 선택하세요 : ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1 :
                        handleBalanceCheck();
                        break;
                        
                    case 2 :
                        handleDeposit();
                        break;
                        
                    case 3 :
                        handleWithdraw();
                        break;
                        
                    case 4 :
                        exit();
                        return;
                        
                    default :
                        System.out.println("1, 2, 3, 4 중에 선택하십시오.");
                }
            } 
            
            catch (NumberFormatException e) {  // 문자 입력하면
                System.out.println("숫자를 입력하세요.");
            }
        }
    }

    private void handleBalanceCheck() {
        System.out.println("현재 잔액: " + df.format(currentUser.getBalance()) + "원");
    }

    private void handleDeposit() {
        while (true) {
            System.out.print("입금할 금액을 입력하세요: ");
            
            try {
                double amount = Double.parseDouble(scanner.nextLine());
                
                if (amount <= 0) {
                    System.out.println("0보다 큰 금액을 입력해주세요.");
                    continue;
                }
                
                currentUser.deposit(amount);
                System.out.println("입금 완료 : " + df.format(amount) + "원");
                System.out.println("잔액 : " + df.format(currentUser.getBalance()) + "원");
                
                break;
            } 
            
            catch (NumberFormatException e) {
                System.out.println("숫자를 입력하세요.");
            }
        }
    }

    private void handleWithdraw() {
        while (true) {
            System.out.print("출금할 금액을 입력하세요: ");
            
            try {
                double amount = Double.parseDouble(scanner.nextLine());
                
                if (amount <= 0) { // 사용자가 0 혹은 음수 입력하면
                    System.out.println("0보다 큰 금액을 입력해주세요.");
                    continue;
                }
                
                if (currentUser.withdraw(amount)) { // 잘 입력했으면
                    System.out.println("출금 완료: " + df.format(amount) + "원");
                    System.out.println("남은 잔액: " + df.format(currentUser.getBalance()) + "원");
                    break;
                } 
                
                else {
                    System.out.println("잔액이 부족합니다. 잔액 이하의 값을 입력하세요.");
                }
            } 
            
            catch (NumberFormatException e) {
                System.out.println("숫자를 입력하세요.");
            }
        }
    }

    private void exit() {
        System.out.println("이용해 주셔서 감사합니다.");
        System.exit(0); // 시스템 종료
    }
}