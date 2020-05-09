#include<iostream>

using namespace std;

template <typename T>
inline T const& Max (T const& a, T const& b)
{
    return a < b ? b:a;
}

int main(){

    cout<<Max(5,6);
    cout<<Max(5.5,6.6);

    return 0;
}
