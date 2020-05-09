
package termfinal2.pkg1;

public class TermFinal21 {
   
    static void vaTest(int ... v)
    {
        for(int x: v)
        {
            System.out.println(x+"");
        }
        System.out.println();
    }
    
    
    public static void main(String[] args) {
    
        vaTest(1,2,3,4,5,6,7,8,9,10);
    }
    
}
