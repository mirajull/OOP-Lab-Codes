package prince.of.persiaa;
import java.util.Scanner;

public class PrinceOfPersiaa {
    public static void main(String[] args){
        Scanner scn=new Scanner(System.in);
        int x=scn.nextInt();
        int mat[][]=new int[100][100];
        for(int i=0;i<x;i++)
        {
        int m=scn.nextInt();
        int n=scn.nextInt();
        for(int j=0;j<m;j++)
        {
            for(int k=0;k<n;k++)
            {
                mat[j][k]=scn.nextInt();
            }
        }
        int result,res1,res2;
        int a1=scn.nextInt();
        int b1=scn.nextInt();
        int a2=scn.nextInt();
        int b2=scn.nextInt();
        m=m-1;
        n=n-1;
        res1=(a2-a1);
        res2=(b2-b1);
         if(res1<0)
                {
                    res1=-res1;   
                }
            if(res2<0)
                {
                    res2=-res2;
                }
            result=res1+res2;
            System.out.println("case: "+ (i+1)+" = ");
            System.out.println(result);
        }
        System.out.println();
    }    
}
