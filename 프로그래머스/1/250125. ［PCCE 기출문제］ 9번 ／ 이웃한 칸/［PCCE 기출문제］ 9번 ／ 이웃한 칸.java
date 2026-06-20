class Solution {
    
   	private static int[] dx = {1, 0, -1, 0};
   	private static int[] dy = {0, 1, 0, -1};
    
    public int solution(String[][] board, int h, int w) {
        int size = board.length;
        
        String color = board[h][w];
        int answer = 0;
        
        for (int i = 0; i < 4; i++) {
            int nx = w + dx[i];
            int ny = h + dy[i];
            if (!checkRange(ny, nx, size, size)) {
               	continue; 
            }
            
            if (color.equals(board[ny][nx])) {
                answer++;
            }
        }
        
        return answer;
    }
    
    private boolean checkRange(int y, int x, int rowSize, int colSize) {
        return 0 <= y && y < rowSize && 0 <= x && x < colSize;
    }
    
    
}