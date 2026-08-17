class Solution {
    int answer = 0;
    public int solution(int[] numbers, int target) {
        findAnswer(0, target, 0, numbers.length, numbers);
        return answer;
    }
    
    private void findAnswer(int num, int target, int idx, int totalNum, int[] numbers) {
        //탈출 조건
        if(idx >= totalNum) {
            if(num == target) {
                answer++;
            }
            return;
        }
        //더했을 때
        findAnswer(num + numbers[idx], target, idx + 1, totalNum, numbers);
        //뺐을 때
        findAnswer(num - numbers[idx], target, idx + 1, totalNum, numbers);
    }
}