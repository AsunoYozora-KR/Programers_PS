//1. DFS 풀이법 (시간 초과)

class Solution {
    int maxValue = 0;
    
    public int solution(int[][] triangle) {
        int answer = 0;
        for(int i = 0; i < triangle.length; i++) {
            findMax(triangle, answer, triangle.length - 1, i);
        }
        answer = maxValue;
        return answer;
    }
    
    private void findMax(int[][] triangle, int answer, int row, int column) {
        answer += triangle[row][column];
        //탈출 조건
        if(row <= 0) {
            maxValue = Math.max(answer, maxValue);
            return;
        }
        
        //좌상단
        if(column > 0) {
            findMax(triangle, answer, row - 1, column - 1);
        }
        //우상단
        if(column < triangle[row].length - 1) {
            findMax(triangle, answer, row - 1, column);
        }
    }
}

//2. 동적 계획법

class Solution {
    public int solution(int[][] triangle) {
        for(int row = triangle.length - 1; row >= 0; row--) {
            for(int column = 0; column < triangle[row].length; column++) {
                changeMax(triangle, row, column);
            }
        }
        int answer = triangle[0][0];
        return answer;
    }
    
    private void changeMax(int[][] triangle, int row, int column) {
        if(row + 1 >= triangle.length) {
            return;
        }
        
        int leftSide = triangle[row][column] + triangle[row + 1][column];
        int rightSide = triangle[row][column] + triangle[row + 1][column + 1];
            
        triangle[row][column] = Math.max(leftSide, rightSide);
        return;
    }
}