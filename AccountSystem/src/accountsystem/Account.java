
 
package accountsystem;

public class Account {
    private int accountNumber;
    private String holderName;
    private String holderType;
    public Account()
    {
        accountNumber=0;
    }
    public Account(int a,String s,String s1)
    {
        accountNumber=a;
        holderName=s;
        holderType=s;
    }
    public int getAccount()
    {
        return accountNumber;
    }
    public String getHolderName()
    {
        return holderName;
    }
    public String getHolderType()
    {
        return holderType;
    }
}

