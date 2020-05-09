#include<iostream>

using namespace std;

class Vector{

    private:
        int i;
        int j;
        int k;

    public:

        Vector(){
            cout<<i<<j<<k<<endl;//print constructing with default values

        }

        Vector(int a,int b,int c){
            cout<<a<<b<<c<<endl;//print constructing with a, b, c values
        }

        int getI(){
            return i;
        }

        int getJ(){
            return j;

        }

        int getK(){
            return k;

        }

        void setI(int a){
            i=a;
        }

        void setJ(int b){
            j=b;
        }
        void setK(int c){
            k=c;
        }

        double getMagnitude(){

        }

        Vector getDirectionVector(){


        }

        ///return a new vector after adding current vector + vect.
        ///no change to this vector object

        Vector addVector(Vector &vect){

        }


        Vector getNormalVector(){

        }

        ///return cross product of this vector and the passed vector
        ///no change to this vector

        Vector crossProduct(Vector &vect){

        }

        ///return dot product of this vector and passed vector as a new vector

        Vector dotProduct(Vector &vect){

        }

        ///multiply is vector component by this value

        Vector scaling(int multValue){

        }

        ///print component

        void printVector(){

        }



        ~Vector(){
            cout<<"Destructing ("<<i<<","<<j<<","<<k<<")"<<endl;
        }

};


int main(){

    ///you must be able to explain construct and destructing output sequence


    return 0;
}
