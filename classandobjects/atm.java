package classandobjects;

public class atm {
    String AccountHolder;
    long AccountNumber;
    double Balance;
    public atm(String AccountHolder, long AccountNumber, double Balance) {
        this.AccountHolder = AccountHolder;
        this.AccountNumber = AccountNumber;
        this.Balance=Balance;
    }
    void deposite(double amount){
        if(amount>=0){
            Balance+=amount;
            System.out.println("Deposited Rs."+amount+" in your account and the current balance is Rs:"+Balance);
        }else{
            System.out.println("Invalid amount");
        }
    }
    void withdraw(double amount){
        if(amount>Balance){
            System.out.println("Insufficient balance");
        }else if(amount<=0){
            System.out.println("Invalid amount");
        }else{
            Balance-=amount;
            System.out.println("Withdrawn Rs."+amount+" from your account and the current balance is Rs:"+Balance);
        }
    }
    void display(){
        System.out.println("Account Holder: "+AccountHolder);
        System.out.println("Account Number: "+AccountNumber);
        System.out.println("current account balance : "+Balance);
    }
    public static void main(String[] args) {
        atm obj = new atm("Rahul", 123456789, 1000.);
        obj.display();
        obj.deposite(500);
        obj.withdraw(200);
    }
}
