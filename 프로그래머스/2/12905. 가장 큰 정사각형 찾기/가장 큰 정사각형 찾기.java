class Solution {
    public int solution(int[][] board) {
        int n = board.length;
        int m = board[0].length;
        
        int[][] dp = new int[n + 1][m + 1];
        int answer = 0;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (board[i - 1][j - 1] == 0) {
                    continue;
                }
                
                dp[i][j] = n * m;
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
                dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + 1);
                answer = Math.max(answer, dp[i][j]);
            }
        }
        
        return answer * answer;
    }
}