/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.JOptionPane;

package joptionpanetest;

/**
 *
 * @author USER-PC
 */
public class JOptionPaneTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String s1=JOptionPane.showInputDialog(null, "Enter 1st number: ");
        String s2=JOptionPane.showInputDialog(null, "Enter 2nd number: ");
        int num1=Integer.parseInt(s1);
        int num2=Integer.parseInt(s2);
        JOptionPane.showMessageDialog(null, "sum is: " +(num1+num2));
        // TODO code application logic here
    }
    
}
