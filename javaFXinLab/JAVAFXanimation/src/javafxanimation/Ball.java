/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxanimation;

import java.util.Random;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 *
 * @author Aspire
 */
class Ball extends Circle{
    double vx;
    double vy;
    
    Ball(double x,double y,Group root, double radius,double vvx,double vvy,Color color){
        //super(x,y,radius,Color.RED);
        super(x,y,radius,color);

        
        
        root.getChildren().add(this);
        vx=vvx;
        vy=vvy;
    }
    
    public void updateCenter(double time){
        setCenterX(getCenterX()+vx*time);
        setCenterY(getCenterY()+vy*time);
    }
    
    public void collision(){
        Scene scene=getScene();
        double x=scene.getWidth();
        double y=scene.getHeight();
        
        if(getCenterX()+getRadius()>=x || getCenterX()-getRadius()<=0)vx=-vx;
        if(getCenterY()+getRadius()>=y || getCenterY()-getRadius()<=0)vy=-vy;
        
        //System.out.println(x+" "+y+" "+getCenterX()+" "+getCenterY() );
    }
}
