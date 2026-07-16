class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int currHp = health;
        int currTime = 1;
        
        for (int[] attack : attacks) {
            int t = attack[0];
            int damage = attack[1];
            
            int timeGap = t - currTime;
            currHp = Math.min(health, currHp + timeGap * bandage[1]);
            if (bandage[0] <= timeGap) {
                currHp = Math.min(health, currHp + timeGap / bandage[0] * bandage[2]);
            }
            
            currHp -= damage;
            
            if (currHp <= 0) {
                return -1;
            }
            
            currTime = t + 1;
        }
        
        return currHp;
    }
}