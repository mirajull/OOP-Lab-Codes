#include <iostream>
#include <stdio.h>
#include <cstring>

using namespace std;

class Bank
{
public:
    char* Bname;
    /*
    Implement necessary constructors and destructor
    */
    Bank(char*a)
    {
        Bname=new char[10];
        strcpy(Bname,a);
        //cout<<"constructing Employee of "<<Bname<<endl;
    }
    Bank(const Bank&a)
    {
        Bname=new char[10];
        strcpy(Bname,a.Bname);
        //cout<<"constructing Employee "<<emp_card<<" of bank "<<a.Bname<<endl;
    }
    ~Bank()
    {
        delete [] Bname;
        cout<<"destructing Bank"<<endl;
    }
};

class Person
{
    int age;
    char* Pname;
public:
    /*
    Implement necessary constructors and destructor
    */
    Person(char*a,int b)
    {
        Pname=new char[10];
        strcpy(Pname,a);
        age=b;
    }
    Person(const Person&a)
    {
        Pname=new char[10];
        strcpy(Pname,a.Pname);
        cout<<"In constructor for "<<Pname<<endl;
    }
    virtual void show()
    {
        cout<<"person name : "<<Pname<<endl;
        cout<<"age : "<<age<<endl;
    }
    char* getPname()
    {
        return Pname;
    }
    int getage()
    {
        return age;
    }
    ~Person()
    {
        delete [] Pname;
    }
};
class Customer;

class Employee:public Bank,public Person
{
    /*
    Employee is derived from both of Bank and Person
    */
protected:
    double salary;
    double incr;
public:
    int emp_card;
    /*
    Implement necessary constructors
    */

    Employee(char*a,char*b,int c,double d,double e,int f):Bank(a),Person(b,c)
    {
        salary=d;
        incr=e;
        emp_card=f;
        cout<<"constructing Employee "<<emp_card<<" of bank "<<Bname<<endl;
    }
    /*
    <bank>, <person>, <salary>, <increment>, <card_no> */
    Employee(Bank a,Person b,double c,double d,int e):Bank(a),Person(b)
    {
        salary=c;
        incr=d;
        emp_card=e;

    }
    void show()
    {
        //cout<<"Bank name : "<<Bname<<endl;
        //cout<<"Person name: "<<getPname()<<endl;
        //cout<<"age : "<<getage()<<endl;
        cout<<"employee card : "<<emp_card<<endl;
        cout<<"salary : "<<salary<<endl;
        cout<<"earned increment :"<<incr<<endl;

    }
    friend void operator+(Employee &a,Customer &b);
    ~Employee() {}
};

class Customer:public Bank,public Person
{
    /*
    Employee is derived from both of Bank and Person
    */
protected:
    int purchase;
    double discount;
public:
    int cust_card;
    /*
    Implement necessary constructors
    */
    /*double getdiscount()
    {
        return discount;
    }*/

    Customer(char*a,char*b,int c,int d,double e,int f):Bank(a),Person(b,c)
    {
        purchase=d;
        discount=e;
        cust_card=f;
        cout<<"constructing Employee "<<cust_card<<" of bank "<<Bname<<endl;
    }
    Customer(Bank a,Person b,int c,double d,int e):Bank(a),Person(b)
    {
        purchase=c;
        discount=d;
        cust_card=e;
    }
    void show()
    {
        //cout<<"bank name : "<<Bname<<endl;
        //cout<<"person name : "<<getPname()<<endl;
        //cout<<"age : "<<getage()<<endl;
        cout<<"customer card : "<<cust_card<<endl;
        cout<<"number of purchase : "<<purchase<<endl;
        cout<<"earned discount : "<<discount<<endl;

    }
    friend void operator+(Employee &a,Customer &b);
    ~Customer() { }
};

void operator+(Employee &a,Customer &b)
{
    b.discount = b.discount +  (a.incr) * (b.purchase);
    a.salary = a.salary - (b.purchase )* 100;
}

/*
*
Implement a friend + operator function
where,
discount = discount +  incr * purchase
and
salary = salary - purchase * 100
*
*/


void display(Employee &emp, Customer &cust)
{
    cout<< "--------------------------------------"<<endl;
    emp.show();
    cout<<endl;
    cust.show();
    cout<< "--------------------------------------\n"<<endl;
}

int main()
{
    Bank bank("World Bank");
    Person person("Mr. X", 35);

    /*
    <bank_name>, <person_name>, <person_age>, <salary>, <increment>, <card_no>
    */
    Employee emp1("Brac Bank", "Mr. Y", 30, 30000, 500.5, 1340);
    /*
    <bank_name>, <person_name>, <person_age>, <no_of_purchase>, <discount>, <card_no>
    */
    Customer cust1("Brac Bank", "Mr. Z", 31, 9, 850.5, 3015);
    cout<< "\nModifying emp1 and cust1:\n";
    display(emp1, cust1);
    emp1 + cust1;
    display(emp1, cust1);

    /*
    <bank>, <person>, <salary>, <increment>, <card_no>
    */
    Employee emp2(bank, person, 44000, 480, 2219);
    /*
    <bank>, <person>, <no_of_purchase>, <discount>, <card_no>
    */
    Customer cust2(bank, person, 12, 370, 2219);
    cout<< "\n\nModifying emp2 and cust2:\n";
    display(emp2, cust2);
    emp2 + cust2;
    display(emp2, cust2);

    Person *p;
    p = &person;
    cout<< "--------------------------------------"<<endl;
    /*
    Implement necessary show() functions
    */
    p->show();
    p = &cust1;
    cout<< "--------------------------------------"<<endl;
    p->show();
    cout<< "--------------------------------------"<<endl;

    return 0;
}
