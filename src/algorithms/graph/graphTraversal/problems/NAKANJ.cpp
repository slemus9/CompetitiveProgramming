#include <stdio.h>
#include <iostream>
#include <string.h>
using namespace std;

struct point{
  int x, y, distance;
};

int board[8][8];
point q[64];

int deltaX[8] = {-1, 1, 2, 2, 1, -1, -2, -2};
int deltaY[8] = {2, 2, 1, -1, -2, -2, -1, 1};

bool pointIsValid(int x, int y){
        return x >= 0 && x < 8 && y >= 0 && y < 8;
}

int bfs(int inix, int iniy, int endx, int endy){
    int start = 0, end = 0;
    board[inix][iniy] = true;
    point startPoint;
    startPoint.x = inix;
    startPoint.y = iniy;
    startPoint.distance = 0;
    q[end++] = startPoint;

    point endPoint ;
    endPoint.x = endx;
    endPoint.y = endy;
    endPoint.distance = 0;


    bool found = false;

    while (start < end && !found){
        point v = q[start++];

        if (v.x == endx && v.y == endy){
            endPoint = v;
            found = true;
        }else {

            for (int i = 0; i < 8; i++) {
                int ux = v.x + deltaX[i];
                int uy = v.y + deltaY[i];

                if (pointIsValid(ux, uy) && !board[ux][uy]){
                    board[ux][uy] = true;
                    point u;
                    u.x = ux;
                    u.y = uy;
                    u.distance = v.distance + 1;

                    q[end++] = u;
                    if (ux == endx && uy == endy){
                        found = true;
                        endPoint = u;
                        break;
                    }
                }
            }
        }
    }
    return endPoint.distance;
}

int main(){

  int t;
  scanf("%d", &t);
  char ini[4], end[4];

  for (int i = 0; i < t; i++){
    memset(board, 0, sizeof(board));
    memset(q, 0, sizeof(q));
    scanf("%s%s", ini, end);

    int inix = ini[0] - 'a';
    int iniy = 8 - (ini[1] - '0');
    int endx = end[0] - 'a';
    int endy = 8 - (end[1] - '0');

    printf("%d\n", bfs(inix, iniy, endx, endy));
  }


  return 0;
}