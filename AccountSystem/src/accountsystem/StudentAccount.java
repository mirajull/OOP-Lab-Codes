
package accountsystem;

public class StudentAccount extends Account{
    private String institute;
    private String status;
    public StudentAccount(int a,String e,String e1,String e3,String e4)
    {
        super(a,e,e1);
        institute=e3;
        status=e4;
    }
    public String getIns()
    {
        return institute;
    }
    public String getStatus()
    {
        return status;
    }
}

