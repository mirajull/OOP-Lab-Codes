#include<iostream>

using namespace std;

namespace first{

    void print(){
        cout<<"Print from first namespace";
    }
}

namespace second{

    void print(){
        cout<<"Print from second namespace";
    }
}

int main(){

    cerr<<"what's wrong"<<endl;
    clog<<"nothing to show"<<endl;
    cout<<"anyways"<<endl;

    return 0;
}
