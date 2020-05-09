#include<iostream>

using namespace std;

int sum(int a){

    return a;
}

int sum(int a, int b){
    return a+b;
}

int main(){

    cout<<sum(4,5)<<endl;
    cout<<sum(4)<<endl;



    return 0;
}
