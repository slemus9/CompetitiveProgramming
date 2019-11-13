//
// Created by sebastian on 12/11/19.
//
#include <iostream>
#include <vector>
#include <queue>

using namespace std;

struct point{
    int x, y;
};

int n, m, t;
const int MAX_SIZE = 110;
int G [MAX_SIZE][MAX_SIZE];
bool puddles [MAX_SIZE][MAX_SIZE];
queue<point> q;

bool isValid(int x, int y){
    return  x >= 0 && x < m && y >= 0 && y < n;
}

bool isEdge(int x, int y){
    return  x == m - 1 || y == n - 1;
}

void bfs(point s){

}

int main(){
    cin >> t;
    for (int i = 0; i < t; ++i) {
        cin >> n >> m;

        for (int j = 0; j < n; ++j) {
            for (int k = 0; k < m; ++k) {
                cin >> G[i][j];
            }
        }


    }

    return 0;
}
