import java.util.*;

class Solution {
    public int solution(int[] citations) {
        //배열 정렬, 기준 인덱스, 비교 인덱스 정의
        Arrays.sort(citations);
        int N = citations.length;
        int h;
        //최솟값이 논문 수보다 클 때
        if(citations[0] > N) {
            return N;
        }
        
        for(int i = 0; i < N; i++) {
            h = N - i;
            if(h <= citations[i]) {
                return h;
            }
        }
        return 0;
    }
}
