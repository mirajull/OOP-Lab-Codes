#include<iostream>

using namespace std;

class student{



    private:
        int age;
        int processAge(){
            return 50;
        }

    public:
        int id;
        double cgpa;

        student(int agevalue){

            age=agevalue;

            cout<<"constucting"<<endl;
        }

        void printAge(){
            //age=processAge();
            cout<<"Age : "<<age<<endl;

        }
};


void printStudent(student name){
    cout<<"Id : "<<name.id<<endl;
    cout<<"Cgpa : "<<name.cgpa<<endl;
    name.printAge();

}



int main(){

    student rahim(22);
    student karim(23);

    rahim.cgpa=3.5;
    rahim.id=121;

    karim.cgpa=3.6;
    karim.id=122;



    printStudent(rahim);
    printStudent(karim);



    return 0;
}
