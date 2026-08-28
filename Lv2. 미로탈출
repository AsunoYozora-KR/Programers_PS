import java.util.*;

class Solution {
    public int solution(String[] maps) {
        //순서 저장용 큐
        Queue<int[]> queue = new ArrayDeque<>();
        //맵 만들기
        char[][] map = new char[maps.length][maps[0].length()];
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[0].length; j++) {
                map[i][j] = maps[i].charAt(j);
                if(map[i][j] == 'S') {
                    queue.offer(new int[]{i,j,0});
                }
            }
        }
        //방문 기록
        boolean[][] isVisited = new boolean[map.length][map[0].length];
        //동남서북
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        
        //레버 찾기
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int curY = cur[0];
            int curX = cur[1];
            int curPath = cur[2];
            
            //레버를 찾았을 때
            if(map[curY][curX] == 'L') {
                queue.clear();
                queue.offer(new int[]{curY, curX, curPath});
                break;
            }
            
            for(int dir = 0; dir < 4; dir++) {
                int nextY = curY + dy[dir];
                int nextX = curX + dx[dir];
                //범위 확인 + 벽 확인 + 그냥 이동
                if(nextY >= 0 && nextY < map.length && nextX >= 0 && nextX < map[0].length && map[nextY][nextX] != 'X' && isVisited[nextY][nextX] == false) {
                    isVisited[nextY][nextX] = true;
                    queue.offer(new int[]{nextY, nextX, curPath + 1});
                }
            }
        }
        
        //초기화
        isVisited = new boolean[map.length][map[0].length];
        //출구 찾으러 가기
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curY = cur[0];
            int curX = cur[1];
            int curPath = cur[2];
                
            //출구를 찾았다면
            if(map[curY][curX] == 'E') {
                return curPath;
            }
                
            for(int dir = 0; dir < 4; dir++) {
                int nextY = curY + dy[dir];
                int nextX = curX + dx[dir];
                    
                //범위 확인 + 벽 확인
                if(nextY >= 0 && nextY < map.length && nextX >= 0 && nextX < map[0].length && map[nextY][nextX] != 'X' && isVisited[nextY][nextX] == false) {
                    isVisited[nextY][nextX] = true;
                    queue.offer(new int[]{nextY, nextX, curPath + 1});
                }
            }
        }
        return -1;
    }
}