
package accountsystem;

public class BasicAccount extends BankAccount{
    private double checkAmount;
    private  int countChecks;
    private int checkbookNo;
    public BasicAccount(int a,String e1,String e2,String e3,double b,double b1,int a1,int a2)
    {
         super(a,e1,e2,e3,b);
         checkAmount=b1;
         countChecks=a1;
         checkbookNo=a2;
    }

    
}
