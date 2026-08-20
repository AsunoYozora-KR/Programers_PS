1. 수학으로 해결

class Solution {
    public int solution(String word) {
        //문자열로 변환
        char[] splits = word.toCharArray();
        int[] weights = returnWeights(splits);
        int answer = 0;
        
        //각자리 문자 탐색 로직
        for(int i = 0; i < weights.length; i++) {
            answer++;
            //가중치 탐색
            for(int j = 1; j < weights[i]; j++) {
                //위치별 계산
                for(int k = 0; k < 5 - i; k++) {
                    answer += (int)Math.pow(5, k);
                }
            }
        }
        return answer;
    }
    
    private int[] returnWeights(char[] splits) {
        int[] weights = new int[splits.length];
        for(int i = 0; i < weights.length; i++) {
            if(splits[i] == 'A') {
                weights[i] = 1;
            }
            if(splits[i] == 'E') {
                weights[i] = 2;
            }
            if(splits[i] == 'I') {
                weights[i] = 3;
            }
            if(splits[i] == 'O') {
                weights[i] = 4;
            }
            if(splits[i] == 'U') {
                weights[i] = 5;
            }
        }
        return weights;
    }
}