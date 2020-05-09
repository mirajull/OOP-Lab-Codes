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

    first::print();
    second::print();

    using namespace first;
    print();

    return 0;
}
