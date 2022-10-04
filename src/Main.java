// Your job is to create a simple banking application.
// There should be a Bank class
// It should have an arraylist of Branches
// Each Branch should have an arraylist of Customers
// The Customer class should have an arraylist of Doubles (transactions)
// Customer:
// Name, and the ArrayList of doubles.
// Branch:
// Need to be able to add a new customer and initial transaction amount.
// Also needs to add additional transactions for that customer/branch
// Bank:
// Add a new branch
// Add a customer to that branch with initial transaction
// Add a transaction for an existing customer for that branch
// Show a list of customers for a particular branch and optionally a list
// of their transactions
// Demonstration autoboxing and unboxing in your code

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static Bank bank = new Bank("Transilvania");

    public static void main(String[] args) {

        boolean quit = false;
        startProgram();
        printActions();
        while (!quit) {
            System.out.println("\nEnter action:");
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("\nShutting down...");
                    quit = true;
                    break;

                case 1:
                    addNewBranch();
                    break;

                case 2:
                    addNewCustomer();
                    break;

                case 3:
                    printCustomers();
                    break;

                case 4:
                    addTransactionToExistingCustomer();
                    break;

                case 5:
                    showCustomerTransactions();

                case 6:
                    printActions();
                    break;
                default:
                    quit = true;
                    break;
            }

        }

    }


    private static void printActions() {
        System.out.println("\nAvailable actions:\npress");
        System.out.println("0  - to shutdown\n" +
                "1  - to add a new branch\n" +
                "2  - to add a new customer\n" +
                "3  - to print customers\n" +
                "4  - to add a transaction to an existing customer\n" +
                "5  - to print a list of transactions\n" +
                "6  - to print a list of available actions.");
    }

    private static void startProgram(){
        System.out.println("The program is starting...");
    }

    private static void  printCustomers(){
        System.out.println("Choose a branch");
        String branchName = scanner.nextLine();
        bank.printCustomers(branchName);
    }

    private static void addNewCustomer(){
        System.out.println("Enter the branch");
        String branchName = scanner.nextLine();
        System.out.println("Enter new customer name: ");
        String customerName = scanner.nextLine();
        System.out.println("Enter initial value: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        bank.addNewCustomerToBranch(branchName,customerName,amount);
    }

    private static void addNewBranch(){
        System.out.println("Enter branch name: ");
        String branchName = scanner.nextLine();
        bank.addNewBranch(branchName);

    }

    private static void showCustomerTransactions(){
        System.out.println("Enter branch name: ");
        String branchName = scanner.nextLine();
        System.out.println("Enter Customer name: ");
        String customerName = scanner.nextLine();
        bank.showTransactions(customerName,branchName);
    }
    private static void  addTransactionToExistingCustomer(){
        System.out.println("Enter branch name: ");
        String branchName = scanner.nextLine();
        System.out.println("Enter customer name: ");
        String customerName = scanner.nextLine();
        System.out.println("Enter amount: (if positive deposit, if negative withdrowal)");
        double amount = scanner.nextDouble();
        bank.addTransactionForExistingCustomer(amount,branchName,customerName);
    }

}
