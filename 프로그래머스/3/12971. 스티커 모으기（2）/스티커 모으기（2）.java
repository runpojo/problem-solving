import java.util.*;

class Solution {
    public int solution(int sticker[]) {
        int n = sticker.length;
        if (n <= 4) {
            return max(sticker);
        }
        
        int answer = -1;
        int[] dp = new int[n];
        dp[0] = sticker[0];
        dp[1] = sticker[0];
        for (int i = 2; i < n - 1; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + sticker[i]);
        }
        
        answer = Math.max(answer, dp[n - 2]);
        
        dp = new int[n];
        dp[1] = sticker[1];
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + sticker[i]);
        }
        
        answer = Math.max(answer, dp[n - 1]);

        return answer;
    }
    
    private int max(int[] array) {
        int max = Integer.MIN_VALUE;
        for (int number : array) {
            max = Math.max(max, number);
        }
        return max;
    }
}