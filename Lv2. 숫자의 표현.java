class Solution {
    public int solution(int n) {
        int count = 0;
        int a = 1;
        
        while(true) {
            for(int k = 1; n >= k*(2*a + k - 1) / 2; k++) {
                if(k*(2*a + k - 1) / 2 == n) {
                    count++;
                }
            }
            
            if(a > n) {
                break;
            }
            
            a++;
        }
        return count;
    }
}