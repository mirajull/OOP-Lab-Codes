/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foreachtest;

/**
 *
 * @author USER-PC
 */
public class ForEachTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int numbers[]={1,2,3,4,5};
        for(int x : numbers)
        {
            System.out.println(x+" ");
            x=x*10;
        }
        System.out.println();
        int numbers2[][]={{1,2,3},{4,5,6},{7,8,9}};
        for(int [] x : numbers2)
        {
            for(int y : x)
            {
                System.out.println(y+" ");
            }
            System.out.println();
        }
    }
}
