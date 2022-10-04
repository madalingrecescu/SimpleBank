import java.util.ArrayList;

public class Branches {
    private String branchName;
    private ArrayList<Customers> customers;

    public Branches(String branchName) {
        this.customers = new ArrayList<Customers>();;
        this.branchName = branchName;
    }

    public String getBranchName() {
        return branchName;
    }

    public void printCustomers(){
        System.out.println("Customers list: ");
        for (int i=0; i<this.customers.size();i++){
            System.out.println((i+1) + ". " + this.customers.get(i).getName());
        }
    }

    public void addNewCustomer(Customers customers) {
        if (findCustomer(customers.getName()) >= 0) {
            System.out.println("The customer name is already used. ");
        } else {
            this.customers.add(customers);
        }
    }

    private int findCustomer(String customerName) {
        for (int i = 0; i < this.customers.size(); i++) {
            Customers customer = this.customers.get(i);
            if (customer.getName().equals(customerName)) {
                return i;
            }
        }
        return -1;
    }

    public void showTransactions(String customerName){
        if(findCustomer(customerName)>=0){
            this.customers.get(findCustomer(customerName)).showTransactions();
        } else {
            System.out.println("Customer name not found! ");
        }
    }

    public void deposit(double amount,String customerName) {
        if (findCustomer(customerName) >= 0) {
            this.customers.get(findCustomer(customerName)).deposit(amount);
        } else {
            System.out.println("The customer does not exist in this branch!");
        }
    }
    public void withdrawal(double amount,String customerName){
            if(findCustomer(customerName) >= 0){
                this.customers.get(findCustomer(customerName)).withdrawal(amount);
            } else{
                System.out.println("The customer does not exist in this branch!");
            }
    }
}
