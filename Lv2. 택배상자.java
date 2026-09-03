import java.util.*;

class Solution {
    public int solution(int[] order) {
        Stack<Integer> subBelt = new Stack<>();
        int answer = 0;
        int find = 0;
        int now = 1;
        
        while(true) {
            //메인 벨트에서 오는 상자
            if(find < order.length && order[find] == now) {
                find++;
                now++;
                answer++;
            }
            //서브 벨트의 상자
            else if(!subBelt.isEmpty() && find < order.length && subBelt.peek() == order[find]) {
                subBelt.pop();
                find++;
                answer++;
            }
            else if(now < order.length){
                subBelt.push(now);
                now++;
            }
            
            else {
                break;
            }
            
        }
        return answer;
     }
}