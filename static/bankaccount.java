
class bankaccount{
    static String bankName = "State Bank";
    static int totalAccounts = 0;
    final int accountNumber;
    String accountHolderName;

    bankaccount(String accountHolderName, int accountNumber) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        totalAccounts++;
    }

    static void getTotalAccounts() {
        System.out.println("Total Accounts: " + totalAccounts);
    }

    void displayDetails() {
        if (this instanceof bankaccount) {
            System.out.println("Bank: " + bankName + ", Name: " + accountHolderName + ", Acc#: " + accountNumber);
        }
    }
    public static void main(String[] args) {
        bankaccount a=new bankaccount("king",220393039);
        a.getTotalAccounts();
        a.displayDetails();

    }
}