import java.util.*;

class Solution {
    
    private static int depth;
    private static int width;
    private static int[][] dp;
    
    public int solution(int[][] triangle) {
        
        depth = triangle.length;
        width = triangle[depth - 1].length;
        
        dp = new int[depth][width];
        for (int i = 0; i < depth; i++) {
            for (int j = 0; j < width; j++) {
                dp[i][j] = -1;
            }
        }
        
        return dfs(triangle, 0, 0);
    }
    
    private int dfs(int[][] triangle, int currDepth, int idx) {
        if (currDepth == depth - 1) {
            return triangle[currDepth][idx];
        }
        if (dp[currDepth][idx] != -1) {
            return dp[currDepth][idx];
        }
        
        dp[currDepth][idx] = triangle[currDepth][idx] + Math.max(dfs(triangle, currDepth + 1, idx), dfs(triangle, currDepth + 1, idx + 1));
        
        return dp[currDepth][idx];
    }
}