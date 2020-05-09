
package accountsystem;


public class DepositAccount extends BankAccount {
    private double depositAmount;
    private int countChecks;
    
    public int f;
    public DepositAccount(int a,String s1,String s2,String s3,double b,double b1,int a1)
    {
         super(a,s1,s2,s3,b);
         depositAmount=b1;
         countChecks=a1;
    }
    public double get_depam()
    {
        return depositAmount;
    }
    public int get_countche()
    {
        return countChecks;
    }
    public void set_depam()
    {
        if(get_countche()>3) depositAmount=depositAmount-f;
    }    
}
