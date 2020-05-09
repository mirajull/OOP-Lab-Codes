#include <iostream>
#include <stdio.h>
#include <string.h>

using namespace std;

class Employee
{
        char* name;
        int age;
    public:
        int id;
        int salary;
        char*getname()
        {
            return name;
        }

        /*
        Implement two constructors
        1) take id and salary
        2) take all parameters
        */
        Employee(int a,int b)
        {
            salary=b;
            id=a;
        }
        Employee(char*a,int b,int c,int d)
        {
            name=new char[strlen(a)];
            strcpy(name,a);
            age=b;
            id=c;
            salary=d;
        }

        // Implement a copy constructor
        Employee(const Employee &a)
        {
            name=new char[strlen(a.name)];
            strcpy(name,a.name);
            age=a.age;
            id=a.id;
            salary=a.salary;

        }
        /*
        Implement + and = operator
        */

        Employee operator+(Employee a);

        Employee operator=(Employee a);

        void setInfo(char*a,int b)
        {
            name=a;
            age=b;
        }
        void print()
        {
            cout<<"\n----------------------------------------\n";
            cout << "Employee ID: " << id<<endl;
            cout << "Employee Name: " << name<<endl;
            cout << "Employee age: " << age<<endl;
            cout << "Employee salary: " << salary<<endl;
            cout<<"----------------------------------------\n\n";
        }

};

Employee Employee::operator + (Employee a)
{
    name=strcat(name,a.name);
    age=age+a.age;
    id=id+a.id;
    salary=salary+a.salary;
    return*this;
}

Employee Employee::operator=(Employee a)
{
    //Employee temp;
    name=a.name;
    age=a.age;
    id=a.id;
    salary=a.salary;
    return*this;
}

char* getName(Employee b)
{
    char*a;
    a=b.getname();
    return a;
}

void scale(Employee a)
{
    cout<<"what is scale?"<<endl;

}
int main()
{
    Employee emp1(1,50000);
    Employee emp2("Cris",30,2,20000);
    emp1.setInfo("Robert", 50);

    emp1.print();
    emp1 = emp1 + emp2;
    emp1.print();
    emp2.print();

    Employee emp3 = emp1;
    emp3.print();

    string name = getName(emp2);
    cout<< "Employee name of "<<emp2.id<< " is: "<< name<< endl;

    name = emp2.getname();
    cout<< "Employee name of "<<emp2.id<< " is: "<< name<< endl;

    scale(emp2);
    emp2.print();

    return 0;
}
