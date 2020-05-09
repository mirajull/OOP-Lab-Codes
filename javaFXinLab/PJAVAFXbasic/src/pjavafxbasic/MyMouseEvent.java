/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pjavafxbasic;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author Aspire
 */
public class MyMouseEvent implements EventHandler<MouseEvent>{

    @Override
    public void handle(MouseEvent event) {
           System.out.println(event.getX()+" "+event.getY());
    }

   
    
}
