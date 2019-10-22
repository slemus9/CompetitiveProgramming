#include<stdio.h>

long mod(long x, long m){
    return (x % m + m) % m;
}

long pow(long a, long n, long m){
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

long gcd(long a, long b){
    if (b == 0 || a == b) return a;
    while (b != 0){
        long temp = b;
        b = a % b;
        a = temp;
    }
    return a;
}

long inv(long a, long m){
    if (gcd(a, m) != 1) return -1;
    else return pow(a, m - 2, m);
}

long calculateCoins(long x, long a, long n, long c){
    long xn = ((x - 1) % c * pow(a, n, c)) % c;

    long N = (pow(a, n, c) - a % c) % c;
    long invD = inv(a - 1, c);

    long powerSum = (N * invD) % c;

    return mod(xn - powerSum, c);
}

int main(void) {
    long x, a, n, c;
    scanf("%ld %ld %ld %ld", &x, &a, &n, &c);
    while(x != 0 || a != 0 || n != 0 || c != 0){
        printf("%ld\n", calculateCoins(x, a, n, c));
        scanf("%ld %ld %ld %ld", &x, &a, &n, &c);
    }

    return 0;
}