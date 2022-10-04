import java.util.ArrayList;

public class Customers {
    private String customerName;
    private ArrayList<Double> transactions;

    public Customers(String customerName, double initialValue) {
        this.customerName = customerName;
        this.transactions = new ArrayList<Double>();
        this.transactions.add(initialValue);
    }

    public void deposit(double amount) {
        double sold = this.transactions.get(this.transactions.size() - 1) + amount;
        this.transactions.add(sold);
        System.out.println("You deposited " + amount + " Your total is:" +
                            this.transactions.get(this.transactions.size()-1));
    }

    public void withdrawal(double amount) {
        if (this.transactions.get(this.transactions.size() - 1) - amount >= 0) {
            double sold = this.transactions.get(this.transactions.size() - 1) - amount;
            this.transactions.add(sold);
            System.out.println("You withdraw " + amount + " Your total is:" +
                                this.transactions.get(this.transactions.size()-1));
        } else {
            System.out.println("Insuficient funds!");
        }

    }

    public void showTransactions(){
        System.out.println("Transactions: ");
        for(int i=0; i<this.transactions.size();i++){
            System.out.println(i + ". " + this.transactions.get(i));
        }
    }

    public static Customers createCustomer(String name,double initialValue){
        return new Customers(name,initialValue);
    }
    public String getName() {
        return customerName;
    }

}
