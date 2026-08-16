//1. 재귀 함수 사용 (시간 초과 발생)

class Solution {
    int min = 10000;
    int i = 0;
    int j = 0;
    
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        
        findPath(maps, 1, n, m);
        if(min == 10000) {
            min = -1;
        }
        return min;
    }
    
    private void findPath(int[][] maps, int count, int n, int m) {
        while(true) {
            //동쪽으로 이동
            if(j + 1 < m && maps[i][j + 1] == 1) {
                count++;
                j++;
                maps[i][j] = 0;
                findPath(maps, count, n, m);
                maps[i][j] = 1;
                j--;
                count--;
            }
            //남쪽으로 이동
            if(i + 1 < n && maps[i + 1][j] == 1) {
                count++;
                i++;
                maps[i][j] = 0;
                findPath(maps, count, n ,m);
                maps[i][j] = 1;
                i--;
                count--;
            }
            //서쪽으로 이동
            if(j - 1 >= 0 && maps[i][j - 1] == 1) {
                count++;
                j--;
                maps[i][j] = 0;
                findPath(maps, count, n, m);
                maps[i][j] = 1;
                j++;
                count--;
            }
            //북쪽으로 이동
            if(i - 1 >= 0 && maps[i - 1][j] == 1) {
                count++;
                i--;
                maps[i][j] = 0;
                findPath(maps, count, n , m);
                maps[i][j] = 1;
                i++;
                count--;
            }
            //갈 수 있는 곳이 없을 때 분류
            //1. 목적지 일 때
            if(i == n - 1 && j == m - 1) {
                min = Math.min(min, count);
                return;
            }
            //목적지가 아닐 때
            return;
        }
    }
}

//2. BFS 사용 

import java.util.*;

class Solution {
    
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0,0,1});
        
        int[] dx = {0,1,0,-1}; //남동북서, x변화
        int[] dy = {1,0,-1,0}; //남동북서, y변화
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curY = cur[0];
            int curX = cur[1];
            int curPath = cur[2];
            
            if(curY == n - 1 && curX == m - 1) {
                return curPath;
            }
            
            for(int dir = 0; dir < 4; dir++) {
                int nextY = curY + dy[dir];
                int nextX = curX + dx[dir];
                
                if(nextX >= 0 && nextX < m && nextY < n && nextY >= 0 && maps[nextY][nextX] == 1) {
                    queue.offer(new int[]{nextY, nextX, curPath + 1});
                    maps[nextY][nextX] = 0;  
                }
            }
        }
        return -1;
    }
}

//여기서 중요한 부분은 maps[nextY][nextX] = 0; 를 마킹하는 부분의 위치인데, 만약 마킹을
// if문 안이 아니라 if문이 끝난 후 반복문 초입에서 해버린다면 시간복잡도가 기하급수적으로 증가함
//왜냐하면 예를 들어, 3x3 맵에서 마지막 (2,1) (1,2) 위치에 있을 때를 생각해 보자
//첫 번째 2,1은 목적지에 방문한적이 없으니 목적지를 큐에 담을 것이고 이때 마킹을 하지 않는다
//따라서 두 번째 1,2도 목적지를 큐에 담게 되고, 쓸데없는 계산 2번을 실행하게 된다.
//만약 맵이 더 커지게 된다면 계산의 양은 어마어마하게 커지고 시간초과가 발생하게 된다. 