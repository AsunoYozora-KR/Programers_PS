import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < works.length; i++) {
            pq.add(works[i]);
        }
        
        for(int i = 0; i < n; i++) {
            if(pq.peek() == 0) {
                break;
            }
            
            int value = pq.poll();
            pq.add(value - 1);
        }
        
        long answer = 0;
        for(int i = 0; i < works.length; i++) {
            int value = pq.poll();
            answer += (long)value * value;
        }
        return answer;
    }
}
