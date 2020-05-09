package shape;

public class Circle extends TwoDShape{
   Circle(String s,int a, int b)
   {
       super(s,a,b);
   }
   public void area()
   {
       System.out.println(3.14159*getHeight()*getWidth());
   }
}