
package prince.of.persia;

import java.util.Scanner;

public class PrinceOfPersia {
    
    public static int ara[][]=new int[100][100];
    public static int vis[][]=new int[100][100];
    public static int fx[]={1,-1,0,0};
    public static int fy[]={0,0,1,-1};
    
    public static void search(int sx, int sy , int t, int m , int n)
    {
        for(int i = 0 ; i<4 ; i++)
        {
            int tx = sx+fx[i];
            int ty = sy+fy[i];
            
            if(0<=tx && tx <m && 0<=ty && ty < n && ( vis[tx][ty]==-1 || vis[tx][ty]>t+1 ) && ara[tx][ty]==0 )
            {
                vis[tx][ty]=t+1 ; 
                search(tx,ty,t+1,m,n);
            }
        }
    }
    
    public static void main(String[] args) {
        
        Scanner scn = new Scanner(System.in);
        int T ;
        T =scn.nextInt(); 
        for(int t =1 ; t <= T ; t ++)
        {
        int a,b;
        a=scn.nextInt();
        b=scn.nextInt();
        int i=0;
        while(i<a)
        {
            for(int j=0;j<b;j++)
            {
                ara[i][j]=scn.nextInt();
                vis[i][j]=-1;       
            }
            i++;
        }
        int sx =scn.nextInt();
        int sy=scn.nextInt();
        int dx=scn.nextInt();
        int dy=scn.nextInt();
        search(sx,sy,1,a,b);
        System.out.printf("case %d: %d\n",t,vis[dx][dy]);
        }
    }
    
}
