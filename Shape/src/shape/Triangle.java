package shape;

public class Triangle extends TwoDShape{
    public Triangle(String a,int b, int c)
    {
        super(a,b,c);
    }
    public void area()
    {
        System.out.println(getHeight()*getWidth()*.5);
    }
    
}