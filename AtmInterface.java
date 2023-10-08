import java.util.Scanner;
class BankAccount {
    private double balance;
    public BankAccount(double initialBalance)
    {
        balance = initialBalance;
    }
    public double getBalance()
    {
        return balance;
    }
    public void deposit(double amount)
    {
        balance += amount;
    }
    public void withdraw(double amount)
    {
        if (amount <= balance) {
            balance -= amount;
        }
        else
        {
            System.out.println("Insufficient balance !");
        }
    }
}

class ATM {
    private final BankAccount bankAccount;

    public ATM(BankAccount account)
    {
        bankAccount = account;
    }

    public void options()
    {
        System.out.println("Welcome to Bank Of India ATM ! Please select your desired option from below : ");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
        System.out.println();
    }

    public void action (int option)
    {
        switch (option)
        {
            case 1:
                withdraw();
                break;
            case 2:
                deposit();
                break;
            case 3:
                checkBalance();
                break;
            case 4:
                System.out.println("Thank you for using the ATM. Visit again !");
                System.out.println();
                System.exit(0);
                break;
            default:
                System.out.println("Please select a valid option !");
        }
    }

    public void withdraw()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the amount to withdraw : ");
        double amount = sc.nextDouble();
        if (amount > 0)
        {
            if (amount <= bankAccount.getBalance())
            {
                bankAccount.withdraw(amount);
                System.out.println(amount+" "+"Withdrawn successfully !");
                System.out.println();
            } else

            {
                System.out.println("Insufficient balance !");
                System.out.println();
            }
        }
    }

    public void deposit()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the amount to deposit : ");
        double amount = sc.nextDouble();
            bankAccount.deposit(amount);
            System.out.println(amount+" "+"Deposited successfully !");
            System.out.println();
    }

    public void checkBalance()
    {
        System.out.println("Available balance : " + bankAccount.getBalance());
        System.out.println();
    }
}

public class AtmInterface
{
    public static void main(String[] args)
    {
        BankAccount bankAccount = new BankAccount(10000.0);
        ATM atm = new ATM(bankAccount);
        Scanner sc = new Scanner(System.in);

        while (true)
        {
            atm.options();
            System.out.print("Enter your choice: ");
            int option = sc.nextInt();
            atm.action(option);
        }
    }
}