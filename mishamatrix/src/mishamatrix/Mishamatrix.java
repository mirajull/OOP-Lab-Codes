/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mishamatrix;
import java.util.Scanner;
 
/**
 *
 * @author USER-PC
 */
public class Mishamatrix {
 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int i,x,j;
        //int mat[][]=new int[][];
        Scanner scn=new Scanner(System.in);
        x=scn.nextInt();
        for(i=0;i<x;i++)
        {
            int n=scn.nextInt();
            int mat[][]=new int[n][n];
            for(j=0;j<n;j++)
            {
                for(int k=0;k<n;k++)
                {
                    mat[j][k]=scn.nextInt();
                }
            }
           for (i = 0; i < n / 2; i++) {
                for (j = i; j < n - 1 - i; j++) {
                    int tmp1, tmp2, tmp3, tmp4;
                    tmp1 = mat[i][j];    ///0 0
                    tmp2 = mat[j][n - 1 - i];   ///0 3
                    tmp3 = mat[n - 1 - i][n - 1 - j];  ///3 3
                    tmp4 = mat[n - 1 - j][i];  ///3 0
 
                    mat[i][j] = tmp4;
                    mat[j][n-i-1] = tmp1;
                    mat[n-i-1][n - j - 1] = tmp2;
                    mat[n-j-1][i] = tmp3;
 
                }
            }
            System.out.println();
            for(j=0;j<n;j++)
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
