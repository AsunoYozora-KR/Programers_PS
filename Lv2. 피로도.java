class Solution {
    int max = 0;
    
    public int solution(int k, int[][] dungeons) {
        boolean[] isVisit = new boolean[dungeons.length];
        for(int i = 0; i < dungeons.length; i++) {
            isVisit[i] = false;
        }
        
        dungeonTravel(k, 0, dungeons, isVisit);
        return max;
    }
    
    private void dungeonTravel(int k, int count, int[][] dungeons, boolean[] isVisit) {
        //처음 들어가는 던전들 = 던전의 개수만큼
        for(int i = 0; i < dungeons.length; i++) {
            //안에서도 다시 몽땅 확인! 한 번 들어간 던전이면 true로 바뀌었을테니 자연스레 나머지만 남는다
            if(k - dungeons[i][0] >= 0 && !isVisit[i]) {
                isVisit[i] = true;
                count++;
                dungeonTravel(k - dungeons[i][1], count, dungeons, isVisit);
                //마지막 탐험이 끝나면 max값만 업데이트되고 탈출이 됨, 이때 다시 돌아오게 되는데
                //돌아오는 곳은 다른 던전으로 갈 수 있는 가능성이 남아 있는 경우임.
                isVisit[i] = false;
                count--;
            }
        }
        max = Math.max(max, count);
    }
}