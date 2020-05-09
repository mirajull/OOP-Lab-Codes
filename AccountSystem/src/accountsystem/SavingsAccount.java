package accountsystem;

public class SavingsAccount extends BankAccount{
    private double depositAmount;
    private double withdrawalAmount;
    private int passbookNo;
    public int rate;
    public int f;
    public int loweram;
    public SavingsAccount(int a,String e1,String e2,String e3,double b,double b1,double b2,int a1)
    {
        super(a,e1,e2,e3,b);
        depositAmount=b1;
        withdrawalAmount=b2;
        passbookNo=a1;
    }
    public double getDepamount()
    {
        return depositAmount;
    }
    public double getWith()
    {
        return withdrawalAmount;
    }
    public void setRate(int a)
    {
        rate=a;
    }
    public void setWith()
    {
        double withdrawalAmount=getWith()-(rate/100)*getWith();
    }
    public void setF(int a,int b)
    {
       f=a;
       loweram=b;
    }
}

