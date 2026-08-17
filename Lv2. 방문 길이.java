class Solution {
    int count = 0;
    public int solution(String dirs) {
        Field[][] map = new Field[11][11];
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                map[i][j] = new Field();
            }
        }
        char[] where = dirs.toCharArray();
        //y좌표 = 0, x좌표 = 1
        int[] yx = new int[]{5,5};
        
        for(int i = 0; i < where.length; i++) {
            yx = countLength(map, where[i], yx);
        }
        return count;
    }
    
    private int[] countLength(Field[][] map, char where, int[] yx) {
        //북쪽 다리 세우기
        if(where == 'U' && yx[0] - 1 >= 0) {
            //다리가 없을 때만
            if(map[yx[0]][yx[1]].direction[0] == false) {
                count++;
            }
            map[yx[0]][yx[1]].direction[0] = true;
            map[--yx[0]][yx[1]].direction[2] = true;
            return yx;
        }
        
        //동쪽 다리 세우기
        if(where == 'R' && yx[1] + 1 < 11) {
            //다리가 없을 때만
            if(map[yx[0]][yx[1]].direction[1] == false) {
                count++;
            }
            map[yx[0]][yx[1]].direction[1] = true;
            map[yx[0]][++yx[1]].direction[3] = true;
            return yx;
        }
        
        //남쪽 다리 세우기
        if(where == 'D' && yx[0] + 1 < 11) {
            //다리가 없을 때만
            if(map[yx[0]][yx[1]].direction[2] == false) {
                count++;
            }
            map[yx[0]][yx[1]].direction[2] = true;
            map[++yx[0]][yx[1]].direction[0] = true;
            return yx;
        }
        
        //서쪽 다리 세우기
        if(where == 'L' && yx[1] - 1 >= 0) {
            //다리가 없을 때만
            if(map[yx[0]][yx[1]].direction[3] == false) {
                count++;
            }
            map[yx[0]][yx[1]].direction[3] = true;
            map[yx[0]][--yx[1]].direction[1] = true;
            return yx;
        }
        return yx;
    }
}