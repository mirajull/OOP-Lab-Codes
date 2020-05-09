
package shape;

public abstract class Sphere extends ThreeDShape{
    public Sphere(String a,int b, int c, int d)
    {
        super(a,b,c,d);
    }
    public void area()
    {
        System.out.println(4*3.14159*getHeight()*getHeight());
    }
    public void volume()
    {
        System.out.println((4/3)*3.14159*getHeight()*getHeight()*getHeight());
    }
}
