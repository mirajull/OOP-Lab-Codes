package shape;

public abstract class TwoDShape extends Sshape {
    private int height;
    private int width;
    public TwoDShape(String s,int a, int b)
    {
        super(s);
        height=a; width=b;
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
    
}