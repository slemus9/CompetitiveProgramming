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
int INF = 100010;
const int MAX_SIZE = 110;
vector<vector<int>> G;
queue<point> q;
bool visited [MAX_SIZE][MAX_SIZE];
int deltaX [4] = {0, 0, -1, 1};
int deltaY [4] = {1, -1, 0, 0};

bool isValid(int x, int y){
    return  x >= 0 && x < m && y >= 0 && y < n;
}

bool isEdge(int x, int y){
    return  x == m - 1 || y == n - 1;
}


int bfs(point s){
    visited[s.y][s.x] = true;
    q.push(s);
    bool leaked = false;
    int vol = 0;

    while (!q.empty() && !leaked){
        point v = q.front();
        q.pop();

        int minHeight = INF;
        for (int i = 0; i < 4; ++i) {
            int ux = v.x + deltaX[i];
            int uy = v.y + deltaY[i];

            if (isValid(ux, uy) && !visited[uy][ux]){
                int adjHeight = G[uy][ux];

                if (G[v.y][v.x] >= adjHeight){
                    visited[uy][ux] = true;

                    if (isEdge(ux, uy)){
                        leaked = true;
                        break;
                    } else{
                        q.push((point) {ux, uy});
                    }
                } else{

                    if (adjHeight < minHeight){
                        minHeight = adjHeight;
                    }
                }
            }
        }
        cout << minHeight << "-" << G[s.y][s.x] << endl;
        vol = minHeight == INF ? 0 : minHeight - G[s.y][s.x];
    }
    return leaked ? 0 : vol;
}

void reloadVisited(){
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < m; ++j) {
            visited[i][j] = false;
        }
    }
}

int main(){
    cin >> t;
    for (int i = 0; i < t; ++i) {
        cin >> n >> m;
        G.resize(n);

        for (int j = 0; j < n; ++j) {
            for (int k = 0; k < m; ++k) {
                int h;
                cin >> h;
                G[j].push_back(h);
            }
        }

        int accVol = 0;
        for (int j = 1; j < n - 1; ++j) {
            for (int k = 1; k < m - 1; ++k) {
                reloadVisited();
                accVol += bfs((point) {k, j});
            }
        }
        cout << accVol << endl;
    }

    return 0;
}
