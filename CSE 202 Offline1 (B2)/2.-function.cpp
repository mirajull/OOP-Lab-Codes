#include <iostream>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define pi 3.1416
using namespace std;

class Shape{
    int x, y, z;
    char *type;
public:
    /*
    Implement a default constructor and required parameterized constructors
    */
    Shape()
    {
        type=new char();
        type=NULL;
        
    }
    Shape(int a,char *p)
    {
     	type=new char();
        strcpy(type,p);
        x=a;
    }
    Shape(int a,int b,char *p)
    {
        y=b;
    	type=new char();
        strcpy(type,p);
        x=a;
    }
    Shape(int a,int b,int c,char *p)
    {
    
        type=new char();
        strcpy(type,p);
        x=a;
        y=b;
        z=c;
    }
    int getx ()
    {
        return x;
    }
    int gety ()
    {
        return y;
    }
    int getz ()
    {
        return z;
    }
    char * getchar()
    {
        return type;
    }
};


/*
    Implement three overloaded fuctions to calculate area
    Each function should return the calculated area
*/
double area(int x)
{
    return pi*x*x;
}
double area(int x,int y)
{
    return x*y;
}
double area(int x,int y,int z)
{
    return x*y*z;
}


int main(){
    Shape circle(5, "circle");      //radius = 5
    Shape rectangle(4,9, "rectangle"); //dim1 = 4, dim2 = 5
    Shape cube(3,2,7, "cube");    //dim1 = 3, dim2 = 2, dim3 = 7

    /*
    Calculate area for all shapes and print the values of area
    Decide which function is called based on the "type" of the object
    */
    double p,q,r;
    p=area(circle.getx());
    q=area(rectangle.getx(),rectangle.gety());
    r=area(cube.getx(),cube.gety(),cube.getz());
    cout<<"area of"<<circle.getchar()<<"is ::"<<p<<endl;
    cout<<"area of"<<rectangle.getchar()<<"is ::"<<q<<endl;
    cout<<"volume of"<<cube.getchar()<<"is ::"<<r<<endl;
}
