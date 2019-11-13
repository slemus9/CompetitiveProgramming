//
// Created by sebastian on 12/11/19.
//
#include <iostream>
#include <vector>
#include <queue>
#include <cstring>

using namespace std;

struct point{
    int x, y;
};

int n, m, t;
const int MAX_SIZE = 110;
vector<vector<int>> G;
vector<vector<bool>> puddles;
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
        G.resize(n);
        puddles.resize(n);

        for (int j = 0; j < n; ++j) {
            G.resize(m);
            puddles.resize(m);
            for (int k = 0; k < m; ++k) {
                cin >> G[i][j];
            }
        }


    }

    return 0;
}
