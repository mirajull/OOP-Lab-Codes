#include <iostream>
#include <stdio.h>
#include <stdlib.h>

using namespace std;

class Student{
    double *GPA;
    double *credit;
public:
    int ID;
    int total_count;
    /*
    Implement a parameterized constructor
    */
    Student (int i,int c)
    {
    	ID=i;
    	total_count=c;

	}
	void set_value(double *a,double *b)
	{
		int i=0;
		GPA=new double[total_count+1];
		credit=new double[1+total_count];
		while(i<total_count)
		{
			*(GPA+i)=*(a+i);
			*(credit+i)=*(b+i);
			i++;
		}

	}

    void show()
    {
        cout<< "GPA and credit of Student "<<ID<<endl;
        cout<<"------------------------------------"<<endl;
        /*
        Write code for printing GPAs and credits
        */
        int i=0;
        while(i<total_count)
        {
        	cout<<"GPA :: "<<*(GPA+i)<<"  Credit :: "<<*(credit+i)<<endl;
        	i++;
		}
        cout<<endl;
    }

    //Implement "+" operator which returns the total credit
	double operator +(const Student &a)
	{
		double ans=0;
		int i=0;
		while(i<a.total_count)
		{

			ans+=*(a.credit+i);
			i++;
		}
		i=0;
		while(i<total_count)
		{

			ans+=*(credit+i);
			i++;
		}

		return ans;
	}
    //Implement "/" operator which returns the sum of all (GPA*credit)
	double operator /(const Student &a)
	{
		double ans=0;
		int i=0;
		while(i<a.total_count)
		{

			ans+=((*(a.credit+i))*(*(a.GPA+i)));
			i++;
		}
		i=0;
		while(i<total_count)
		{

			ans+=((*(credit+i))*(*(GPA+i)));
			i++;
		}

		return ans;
	}
    /*Implement "<" operator which returns
      true if average GPA is less than that of the object in parameter
      and
      false if otherwise
    */
    bool operator <(const Student &a)
    {
    	double ans=0;
    	double ans2=0;
		int i=0;
		while(i<a.total_count)
		{

			ans+=((*(a.credit+i))*(*(a.GPA+i)));
			ans2+=*(a.credit+i);
			i++;
		}
		double a1=ans/ans2;
		i=0;
		ans=0;
		ans2=0;
		while(i<total_count)
		{

			ans+=((*(credit+i))*(*(GPA+i)));
			ans2+=*(credit+i);
			i++;
		}
		if((ans/ans2)<a1) return true;
		return false;
	}
};

int main(){
    Student s1(1,5);
    Student s2(2,5);
    Student s3(3,6);

    /*
    a, b both are double-type array
    initial values are as output file
    */
    double a[5]={2.00,3.00,2.75,3.25,3.00};
    double b[5]={3.75,3.5,4.0,4,2.0};
    s1.set_value(a,b);
    s1.show();

    /*
    c, d both are double-type array
    initial values are similar as output file
*/
	double c[6]={2.00,3.00,2.75,3.25,3.00,4.00};
	double d[6]={2.00,3.00,2.75,3.25,3.00,3.25};
    s2.set_value(c,d);
    s2.show();

    /*
    e, f both are double-type array
    initial values are similar as output file
*/
    s3.set_value(a,d);
    s3.show();

    cout<< "CGPA of "<< s1.ID << " and "<< s2.ID <<": "<<(s1/s2)/(s1+s2)<<endl;
    cout<< "CGPA of "<< s2.ID << " and "<< s3.ID <<": "<<(s2/s3)/(s2+s3)<<endl;

    if(s1<s2)
        cout<<s1.ID<<" has less average GPA than "<<s2.ID <<endl;
    if(s2<s3)
        cout<<s2.ID<<" has less average GPA than "<<s3.ID <<endl;

}
