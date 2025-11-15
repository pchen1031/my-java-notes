/**
 * ClassName: TestATM
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/3/14 21:24
 * @Version 1.0
 */
import java.util.ArrayList;
import java.util.Scanner;

class Account{
    private String accountNumber;
    private String accountName;
    private double balance;
    private String password;

    public Account(String accountNumber, String accountName, double balance, String password) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.balance = balance;
        this.password = password;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public double getBalance() {
        return balance;
    }

    public boolean Password(String inputPassword) {
        return this.password.equals(inputPassword);
    }

    public void deposit(double amount) {
        if(amount > 0){
            balance += amount;
            System.out.println("存款成功！当前余额为：" + balance+"\n");
        }
        else {
            System.out.println("存款失败！\n");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("取款成功！当前余额为：" + balance+"\n");
        }
        else {
            System.out.println("取款失败！\n");
        }
    }
}

class ATM{
    private ArrayList<Account> accounts;

    public ATM() {
        accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public Account login(String accountNumber, String password) {
        for(Account account : accounts) {
            if(account.getAccountNumber().equals(accountNumber)) {
                if(account.Password(password)) {
                    System.out.println("登陆成功！欢迎用户"+account.getAccountNumber()+"!\n");
                    return account;
                }
                else {
                    System.out.println("密码错误！\n");
                    return null;
                }
            }
        }
        System.out.println("账号不存在！\n");
        return null;
    }

    public void deposit(Account account, double amount) {
        if(account!=null){
            account.deposit(amount);
        }
        else {
            System.out.println("请先登录！\n");
        }
    }

    public void withdraw(Account account, double amount) {
        if(account!=null){
            account.withdraw(amount);
        }
        else {
            System.out.println("请先登录！\n");
        }
    }

}

public class TestATM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ATM atm = new ATM();

        Account account1 = new Account("An1234","安苑",2000.0,"AY123456");
        Account account2 = new Account("Ln5678","雷茗",9999999.9,"LY123456");
        atm.addAccount(account1);
        atm.addAccount(account2);
        System.out.print("请输入账号：");
        String accountNumber = sc.nextLine();
        System.out.print("请输入密码：");
        String password = sc.nextLine();
        System.out.print("\n");

        Account currentAccount = atm.login(accountNumber, password);

        if(currentAccount!=null){
            System.out.print("请输入存款金额：");
            double depositAmount = sc.nextDouble();
            atm.deposit(currentAccount, depositAmount);

            System.out.print("请输入存款金额：");
            double withdrawAmount = sc.nextDouble();
            atm.withdraw(currentAccount, withdrawAmount);
        }
        sc.close();
    }
}