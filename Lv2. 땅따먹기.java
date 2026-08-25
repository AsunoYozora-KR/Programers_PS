class Solution {
    int solution(int[][] land) {
        for(int row = land.length - 1; row >= 0; row--) {
            for(int col = 0; col < 4; col++) {
                findMax(land, row, col);
            }
        }
        
        int answer = 0;
        for(int i = 0; i < 4; i++) {
            answer = Math.max(answer, land[0][i]);
        }
        return answer;
    }
    
    private void findMax(int[][] land, int row, int col) {
        if(row + 1 >= land.length) {
             return;
        }
        
        int max = 0;
        for(int i = 0; i < 4; i++) {
            if(i == col) {
                continue;
            }
            max = Math.max(max, land[row][col] + land[row + 1][i]);
        }
        land[row][col] = max;
    }
}