import java.util.ArrayList;

public class Bank {
    private String bankName;
    private ArrayList<Branches> bankBranches;

    public Bank(String bankName) {
        this.bankName = bankName;
        this.bankBranches = new ArrayList<Branches>();
    }

    public void printCustomers(String branchName) {
        if (findBranch(branchName) >= 0) {
            bankBranches.get(findBranch(branchName)).printCustomers();
        } else {
            System.out.println("Branch not found");
        }
    }

    public void addNewCustomerToBranch(String branchName, String customerName, double initialAmount) {
        if (findBranch(branchName) >= 0) {
            Customers customer = new Customers(customerName,initialAmount);
            this.bankBranches.get(findBranch(branchName)).addNewCustomer(customer);
        } else {
            System.out.println("Branch not found!");
        }
    }
    public void addNewBranch(String branchName) {
        Branches branches = new Branches(branchName);
        addNewBranch(branches);
    }

    private void addNewBranch(Branches branches) {
        if (findBranch(branches.getBranchName()) >= 0) {
            System.out.println("The branch name is already used. ");
        } else {
            this.bankBranches.add(branches);
        }
    }
    public void addTransactionForExistingCustomer(double amount, String branchName, String customerName) {
        if (findBranch(branchName) >= 0) {
            if (amount > 0) {
                this.bankBranches.get(findBranch(branchName)).deposit(amount, customerName);
            } else {
                amount = amount * (-1);
                this.bankBranches.get(findBranch(branchName)).withdrawal(amount, customerName);
            }
        }
    }
    private int findBranch(String branchName) {
        for (int i = 0; i < this.bankBranches.size(); i++) {
            Branches bankBranches = this.bankBranches.get(i);
            if (bankBranches.getBranchName().equals(branchName)) {
                return i;
            }
        }
        return -1;
    }

    public void showTransactions(String customerName,String branchName){
        if(findBranch(branchName)>=0){
            this.bankBranches.get(findBranch(branchName)).showTransactions(customerName);
        } else {
            System.out.println("Branch name not found! ");
        }
    }
}
