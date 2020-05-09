#include <iostream>

using namespace std;

/*
Implement necessary functions with constructors and desctructor
*/

/*
Indicate by printing when constructors and destructor are called
*/

class Object
{
    char* type;   ///type can be the inheriting class_name
	public:
    	int objectID;  ///set id through a function

    	Object(char* name)
    	{
    		cout<<"Constructing object"<<endl ;
    		type = name ;
		}

		char* getName()
		{
			return type ;
		}

		void setID(int n)
		{
			objectID = n ;
		}

		int getID()
		{
			return objectID ;
		}

		~Object()
    	{
    		cout<<"Destructing object"<<endl ;
		}
};


class Shape : public Object
{
	protected:
	    int height;
	    int width;
	public:
		Shape():Object("Cube")
    	{
    		cout<<"Constructing Shape"<<endl ;
		}
		~Shape()
    	{
    		cout<<"Destructing Shape"<<endl ;
		}

};


class Cube : public Shape
{
	int thickness;
	public:
		Cube(int a,int b,int c)
    	{
    		cout<<"Constructing Cube"<<endl ;
    		height = a ;
    		width = b ;
    		thickness = c ;
		}

		int getVolume()
		{
			return height*width*thickness ;
		}

		~Cube()
    	{
    		cout<<"Destructing Cube"<<endl ;
		}

};

int main()
{
    Cube c1(5,2,3);
    Cube *obj;

    obj = &c1;

    cout<<c1.getName()<<"\t"<<c1.getVolume()<<endl;
    cout<<obj->getName()<<"\t"<<obj->getVolume()<<endl;

    obj->setID(5);
 //	cout<<obj->getID()<<endl ;
    cout<<c1.getName()<<"\t"<<c1.getVolume()<<endl;
    cout<<obj->getName()<<"\t"<<obj->getVolume()<<endl;

    return 0;
}
