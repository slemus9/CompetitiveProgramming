#include<stdio.h>

long m = 10000007;

long pow(long a, long n){
    if(n == 0) return 1;
    long a1 = 1;
    while(n > 1){
        if(n % 2 == 0) n /= 2;
        else {
            a1 = (a % m * a1 % m) % m;
            n = (n - 1)/2;
        }
        a = (a % m * a % m ) % m;
    }
    return (a * a1) % m;
}


int main(void) {
    long n, k;
    scanf("%ld %ld", &n, &k);
    while(n != 0 || k != 0){
        printf("%ld\n", (2*(pow(n-1,k) + pow(n-1,n-1)) + pow(n,k) + pow(n,n)) % m);
        scanf("%ld %ld", &n, &k);
    }

    return 0;
}