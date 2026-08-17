import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        Queue<Integer> queue = new ArrayDeque<>();
        int[] isVisit = new int[n];
        int idx = 0;
        queue.offer(idx);
        isVisit[idx] = 1;
        int network = 1;
        
        while(true) {
            //큐가 비어있지 않다면
            while(!queue.isEmpty()) {
                idx = queue.poll();
                for(int i = 0; i < n; i++) {
                    //방문한적 없고 연결되어 있을 때
                    if(isVisit[i] == 0 && computers[idx][i] == 1) {
                        queue.offer(i);
                        isVisit[i] = 1;
                    }
                }
            }
            //큐가 비어있다면
            int flag = 0;
            for(int i = 0; i < n; i++) {
                //case1). 방문할 수 있는 노드가 남았을 때
                if(isVisit[i] == 0) {
                    idx = i;
                    queue.offer(idx);
                    isVisit[idx] = 1;
                    flag = 1;
                    network++;
                    break;
                }
            }
            
            if(flag == 1) {
                continue;
            }
            
            //case2). 방문할 수 있는 노드가 없을 때
            return network;
        }
    }
}