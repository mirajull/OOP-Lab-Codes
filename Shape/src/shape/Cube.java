package shape;


public abstract class Cube extends ThreeDShape{
    public Cube(String s,int a, int b, int c)
    {
        super(s,a,b,c);
    }
    public void area()
    {
        System.out.println(2*(getHeight()*getLength()+getHeight()*getWidth()+getWidth()*getLength()));
    }
    public void volume()
    {
        System.out.println(getHeight()*getLength()*getWidth());
    }
    
}
