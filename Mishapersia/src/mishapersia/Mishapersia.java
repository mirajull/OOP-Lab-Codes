package mishgggggggggggggggapersia;
import java.util.*;

class node
{
    public int x ;
    public int y ;
    node ( int xx , int yy )
    {
        x=xx ;
        y=yy ;
    }
}
public class Mishapersia {
    public static void bfs( int [][]a , int [][]ck , int xx, int yy )
    {
        Queue<node> q = new LinkedList<node>();
        node u , v ;
        u = new node( xx, yy ) ;
        ck[u.x][u.y] = 0 ;
        q.add(u);
        while(!(q.size()==0))
        {
            u = q.poll();
            int x = u.x ;
            int y = u.y ;
            if( x > 0 && a[x-1][y] == 0 && ck[x-1][y] == -1 )
            {
                v = new node( x-1, y ) ;
                ck[x-1][y] = ck[x][y] + 1 ;
                q.add(v);
            }
            if( x < a.length-1 && a[x+1][y] == 0 && ck[x+1][y] == -1 )
            {
                v = new node( x+1, y ) ;
                ck[x+1][y] = ck[x][y] + 1 ;
                q.add(v);
            }
            if( y > 0 && a[x][y-1] == 0 && ck[x][y-1] == -1 )
            {
                v = new node( x, y-1 ) ;
                ck[x][y-1] = ck[x][y] + 1 ;
                q.add(v);
            }
            if( y < a[x].length-1 && a[x][y+1] == 0 && ck[x][y+1] == -1 )
            {
                v = new node( x, y+1 ) ;
                ck[x][y+1] = ck[x][y] + 1 ;
                q.add(v);
            }
        }
    }
    public static void main(String[] args)
    {
        Scanner in = new Scanner( System.in) ;
        int n , m ;
        n = in.nextInt();
        m = in.nextInt() ;
        int [][] ck = new int[n][m] ;
        int [][] a = new int[n][m] ;
        for( int i = 0 ; i < n ; i++ )
        {
            for( int j = 0 ; j < m ; j++ )
            {
                a[i][j] = in.nextInt();
            }
        }
        for( int i = 0 ; i < n ; i++ )
        {
            for( int j = 0 ; j < m ; j++ )
            {
                ck[i][j] = -1 ;
            }
        }
        int x , y , cx, cy ;
        x = in.nextInt();
        y = in.nextInt();
        cx =in.nextInt();
        cy =in.nextInt();
        bfs( a,ck,x,y) ;
        System.out.println(ck[cx][cy] );
    }
}
