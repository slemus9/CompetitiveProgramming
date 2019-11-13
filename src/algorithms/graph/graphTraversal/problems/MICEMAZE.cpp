//
// Created by sebastian on 10/11/19.
//https://www.spoj.com/problems/MICEMAZE/
#include <iostream>
#include <vector>
#include <queue>
#include <set>

using namespace std;

struct edge {
    int to;
    int weight;
};

int n, e, t, m;
vector<vector<edge>> G;
queue<pair<int, int>> q;
set<int> mice;

void bfs(int s){
    mice.insert(s);
    q.push(make_pair(s, t));
    while (!q.empty()){
        pair<int, int> pair = q.front();
        q.pop();
        int v = pair.first;
        int remaining = pair.second;

        for (edge e: G[v]){
            int u = e.to;
            int timeToExit = remaining - e.weight;
            if (timeToExit >= 0){
                mice.insert(u);
                q.push(make_pair(u, timeToExit));
            }
        }
    }
}

int main(){
    cin >> n >> e >> t >> m;
    G.resize(n + 1);

    for (int i = 0; i < m; ++i) {
        int a, b, d;
        cin >> a >> b >> d;
        G[b].push_back((edge) {a, d});
    }

    bfs(e);
    cout << mice.size();

    return 0;
}
