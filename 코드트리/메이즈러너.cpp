#include <iostream>
#include <algorithm>
using namespace std;


int moveCnt;
int N, M, K;
int maze[11][11];
void input()
{
  cin >> N >> M >> K ;
  for(int i=1;i<=N;i++)  {
    for(int j=1;j<=N;j++){
        int tmp;
        cin >> tmp;
        maze[i][j] = -tmp;
    }
  }
}

pair<int, int> findExit(){
  //특정격자에 -10이 적혀있다면, 출구를 의미한다
  for(int i=1;i<=N;i++){
    for(int j=1;j<=N;j++){
      if(maze[i][j]== -10)  return {i,j};
    }
  }
}


void subRotate(int x, int y, int d){
  int a[11][11] = {0,};
  int b[11][11] = {0,};
  // 미로의 좌표를 1,1으로 사상
  for(int i=x;i<=x+d;i++){
    for(int j=y;j<=y+d;j++){
      a[i-x+1][j-y+1] = maze[i][j];
    }
  }

  int n = d+1;
  for(int i=1;i<=n;i++){
    for(int j=1;j<=n;j++){
      if(-9 <= a[i][j] && a[i][j]<=-1)
        a[i][j]++;
      b[j][n+1-j] = a[i][j];
    }
  }
  //b의 좌표를 미로의 좌표로 사상
  for(int i=x;i<=x+d;i++){
    for(int j=y;j<=y+d;j++){
      maze[i][j] = b[i-x+1][j-y+1];
    }
  }

}

int dx[4] = {-1, 1, 0, 0}; int dy[4] = {0, 0, 1, -1};

void moveAll(){
  int newMaze[15][15] = {0,};  
  auto ex = findExit();
  for(int i=1;i<=N;i++){
    for(int j=1;j<=N;j++){
      if(maze[i][j] < 0){
        newMaze[i][j] = maze[i][j];
        continue;
      }
      if(maze[i][j] == 0){
        continue;
      }
      int min_dist=1000000; int min_i=0; int min_j=0;
      for(int k=0;k<4;k++){
      int ni= i + dx[k];
      int nj= j + dy[k];

      if( ni < 1 || nj < 1 || ni > N || nj > N) continue;
   
      int dist = abs(ni- ex.first) + abs(nj - ex.second);
      if(min_dist > dist){
        min_dist = dist;
        min_i = ni;
        min_j = nj;
      }

      if(min_dist == 1000000){
        newMaze[i][j] = maze[i][j];
        continue;
      }
      if(-9 <= maze[min_i][min_j] && maze[min_i][min_j] <= -1 ){ 
        newMaze[i][j] = maze[i][j];
        continue;
      }
      moveCnt += maze[i][j]; // "참가자들의 수"만큼 증가합니다!!!
        
        
      if(maze[min_i][min_j] == -10){
        continue;
      }

      

    }
  }
  for(int i=1;i<=N;i++){
    for(int j=1;j<=N;j++){
      maze[i][j] = newMaze[i][j];
    }
  }
}
bool isFinish(){
  for(int i=1;i<=N;i++){
    for(int j=1;j<=N;j++){
      if(maze[i][j] > 0)
        return false;
    }
  }
  return true;
}

void rotate()
{
  // 1. 정사각형의 크기를 먼저 결정하자.
  // 크기는 가장 작은 정사각형의 크기 출구 & (출구와 가장 가까운 참가자)
  int min_dist = 1000000;
  auto ex = findExit();
  for(int i=1;i<=N;i++){
    for(int j=1;j<=N;j++){
      if(maze[i][j]<0) continue;

      int dist = max(abs(i-ex.first),abs(j-ex.second)) + 1;
      min_dist = min(min_dist, dist);
    }
  }
  // 2. 정사각형의 위치를 그 다음으로 결정하자.
  int bestRow=0; int bestCol =0;
  for(int i=1;i<=N;i++){
    for(int j=1;j<=N;j++){
      // 이번에 결정한 정사각형의 좌상단 좌표
      bool flagExit = false; bool flagPerson = false;
      for(int r=i; r<=i+min_dist;r++){
        for(int c=j;c<=j+min_dist;c++){
          if(maze[r][c] == -10) flagExit=true;
          if(maze[r][c] > 0) flagPerson=true;
          if(flagExit && flagPerson){
            bestRow = i;
            bestCol = j;
            break;
      }
     }
    }

    // 3. 회전하기
    subRotate(bestRow,bestCol, min_dist);
    }
  }
}

void output()
{
  cout << moveCnt<<"\n";
  auto ex = findExit();
  cout << ex.first << " " << ex.second;
}
int main()
{
  input();
 

  for(int i=0;i<K;i++){
    moveAll();

    if(isFinish()){
      break;
    }

    rotate();
  }
  output();
  
  
  
}
