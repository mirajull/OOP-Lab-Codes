
package accountsystem;


public class BankAccount extends Account {
    private String bankName;
    private double balance;
    public BankAccount(int a,String e1,String e2,String e3,double b)
    {
        super(a,e1,e2);
        bankName=e3;
        balance=b;
    }
    public String getBank()
    {
        return bankName;
    }
    public double getBalance()
    {
        return balance;
    }    
}
