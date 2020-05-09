
package mishaprductcode;
import java.util.Scanner;

public class MishaprductCode {
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        int T = scn.nextInt();
        String r=scn.nextLine();
        int u;
        for(u=0;u<T;u++) {
            String s=scn.nextLine();
            char ara[]=s.toCharArray();
            int i,m=0,diff=0,j,k,x=0,ans=1,ans1=0;
            int num[]=new int[s.length()];
            int str[]=new int[s.length()];
            for (i=0;i<s.length();i++) {
                if(ara[i]==' ') {
                    m=i+1;
                    diff = s.length() - m;
                    for (j = i + 1, k = 0; j < s.length(); j++, k++) {
                        num[k] = ara[j];
                    }
                }
            }
            for(i=0,k=0;i<m-1;i++, k++) {
                if(ara[i] >='0'&&ara[i]<='9') {
                    x++;
                    str[x-1]=ara[i]-'0';
                }
            }
            for (i =0;i<x;i=i+2) {
                ans=ans*(str[i]*10+str[i+1]);
            }
            for (i = 0;i<diff;i++) {
                ans1=ans1+(num[i]-'0')*(int)Math.pow(10,5-i);
            }
            if(ans==ans1&&lower(ara,m)!=0)
            {
                System.out.println("Valid");
            }
            else 
            {
                System.out.println("Invalid");
            }

        }
    }
    public static int lower(char[]a,int m) {
        int i;
        for(i=0;i<m;i++)
        {
            if(a[i]>=97&&a[i]<=122) 
            {  
                return 0;
            }
        }
        return 1;
    }
}
