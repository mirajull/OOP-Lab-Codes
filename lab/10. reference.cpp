
#include <stdio.h>

int main ()
{
   // declare simple variables
   int    i;

   // declare reference variables
   int&    r = i;

   i = 5;

    printf("%d\n",i);
    printf("%d\n",r);


   return 0;
}
