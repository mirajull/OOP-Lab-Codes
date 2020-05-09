
#include<stdio.h>

int sum(int a){

    return a;
}

int sum(int a, int b){
    return a+b;
}

int main(){

    printf("%d\n",sum(5));
    printf("%d\n",sum(5,6));

    return 0;
}
