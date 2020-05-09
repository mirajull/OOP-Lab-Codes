#include <iostream>

using namespace std;

int main ()
{
   // declare simple variables
   int    i;

   // declare reference variables
   int&r = i;

   i = 5;
   cout << "Value of i : " << i << endl;
   cout << "Value of i reference : " << r  << endl;


   return 0;
}
