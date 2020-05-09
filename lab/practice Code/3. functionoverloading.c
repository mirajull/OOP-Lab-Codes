#include<stdio.h>

int sum(int a, int b){

    return a+b;
}

int sum(int a, int b, int c){

    return a+b+c;
}

int main(){

    printf("%d\n",sum(3,4));
    printf("%d\n",sum(3,4,5));


    return 0;
}
