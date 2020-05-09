#include<iostream>

using namespace std;

struct student{
    int id;
    double cgpa;
};


void printStudent(student name){
    cout<<"Id : "<<name.id<<endl;
    cout<<"Cgpa : "<<name.cgpa<<endl;

}



int main(){

    student rahim;
    student karim;

    rahim.cgpa=3.5;
    rahim.id=121;

    karim.cgpa=3.6;
    karim.id=122;

    printStudent(rahim);
    printStudent(karim);

    return 0;
}
