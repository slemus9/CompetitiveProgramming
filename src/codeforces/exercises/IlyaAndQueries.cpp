#include <bits/stdc++.h> 
#include <iostream>
using namespace std;

int main(){
    string s;
    int n;
    cin >> s;
    cin >> n;

    int sumArr [s.length()];
    memset(sumArr, 0, sizeof(sumArr));
    for (int j = 1; j < s.length(); ++j){
        sumArr[j] = sumArr[j - 1] + (s[j]== s[j - 1] ? 1 : 0);
    }

    for (int i = 0; i < n; ++i){
        int l, r;
        cin >> l >> r;
        cout << sumArr[r - 1] - sumArr[l - 1] << endl;

    } 

    return 0;
}
