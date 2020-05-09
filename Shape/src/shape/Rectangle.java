
package shape;


public class Rectangle extends TwoDShape{
    public Rectangle(String s,int a, int b)
    {
        super(s,a,b);
    }
    public void area()
    {
        System.out.println(getHeight()*getWidth());
    }
    
}

