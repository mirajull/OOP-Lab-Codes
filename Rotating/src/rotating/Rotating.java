/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rotating;
import java.util.Scanner;

/**
 *
 * @author USER-PC
 */
public class Rotating {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int i,x;
        //int mat[][]=new int[][];
        Scanner scn=new Scanner(System.in);
        x=scn.nextInt();
        for(i=0;i<x;i++)
        {
            int n=scn.nextInt();
            int mat[][]=new int[n][n];
            for(int j=0;j<n;j++)
            {
                for(int k=0;k<n;k++)
                {
                    mat[j][k]=scn.nextInt();
                }
            }
            for(int j=0;j<n;j++)
            {
                for(int k=0;k<n;k++)
                {
                    int temp=mat[j][k];
                    mat[j][k]=mat[k][n-j-1];
                    mat[k][n-j-1]=temp;
                }
            }
            System.out.println('\n');
            for(int j=0;j<n;j++)
            {
                for(int k=0;k<n;k++)
                {
                    System.out.print(mat[j][k]+" ");
                }
                System.out.println();
            }
        }
    }
}
