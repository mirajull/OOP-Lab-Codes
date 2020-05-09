
package shape;

public abstract class ThreeDShape extends Sshape {
    private int height;
    private int width;
    private int length;
    ThreeDShape(String s,int a, int b, int c)
    {
        super(s);
        length=a; height=b; width=c;
    }
    int getLength()
    {
        return length;
    }
    int getHeight()
    {
        return height;
    }
    int getWidth()
    {
        return width;
    }
    public abstract void area();
    public abstract void volume();
    
}

