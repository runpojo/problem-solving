import java.util.*;

class Solution {
    public int[] solution(int m, int n, int h, int w, int[][] drops) {
        final int MAX_VALUE = drops.length + 2;
        int[][] board = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = MAX_VALUE;
            }
        }
        
        for (int i = 0; i < drops.length; i++) {
            int dropY = drops[i][0];
            int dropX = drops[i][1];
            board[dropY][dropX] = i + 1;
        }
        
        int r = m - h + 1;
        int c = n - w + 1;
        
        int[][] rowMin = new int[m][c];
        for (int i = 0; i < m; i++) {
            Deque<Integer> dq = new ArrayDeque<>();
            for (int end = 0; end < n; end++) {
                int start = end - w + 1;
                while (!dq.isEmpty() && dq.peekFirst() < start) {
                   	dq.pollFirst(); 
                }
                
                while (!dq.isEmpty() && board[i][dq.peekLast()] >= board[i][end]) {
                    dq.pollLast();
                }
                
                dq.add(end);
                
                if (0 <= start) {
                    rowMin[i][start] = board[i][dq.peekFirst()];
                }
            }
        }
        
        int[][] rectMin = new int[r][c];
        for (int j = 0; j < c; j++) {
            Deque<Integer> dq = new ArrayDeque<>();
            for (int end = 0; end < m; end++) {
                int start = end - h + 1;
                while (!dq.isEmpty() && dq.peekFirst() < start) {
                    dq.pollFirst();
                }
                
                while (!dq.isEmpty() && rowMin[dq.peekLast()][j] >= rowMin[end][j]) {
                    dq.pollLast();
                }
                
                dq.add(end);
                
                if (0 <= start) {
                    rectMin[start][j] = rowMin[dq.peekFirst()][j];
                }
            }
        }
        
        int max = -1;
        int ansY = -1;
        int ansX = -1;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (max < rectMin[i][j]) {
                    max = rectMin[i][j];
                    ansY = i;
                    ansX = j;
                }
            }
        }
        
        return new int[]{ansY, ansX};
    }
}