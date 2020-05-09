
#include <stdio.h>

template <typename T>
T Max (T a, T b)
{
    return a < b ? b:a;
}

int main ()
{

    printf("%d\n",Max(5,6));
    printf("%lf\n",Max(3.4,5.5));


   return 0;
}
