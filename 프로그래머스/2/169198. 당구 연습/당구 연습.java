class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int length = balls.length;
        int[] answer = new int[length];
        
        int currY = startY;
        int currX = startX;
        
        for (int i = 0; i < length; i++) {
            int destX = balls[i][0];
            int destY = balls[i][1];
            
            int dist = hitCorner(currY, currX, destY, destX, m, n);
            
            if (checkHitY(currY, destY)) {
                dist = Math.min(dist, hitY(currY, currX, destY, destX, m));
            } else if (startX < destX) {
                dist = Math.min(dist, pow(startX + destX));
            } else {
                dist = Math.min(dist, pow(m - startX + m - destX));
            }
            
            if (checkHitX(currX, destX)) {
                dist = Math.min(dist, hitX(currY, currX, destY, destX, n));
            } else if (startY < destY) {
                dist = Math.min(dist, pow(startY + destY));
            } else {
                dist = Math.min(dist, pow(n - startY + n - destY));
            }
            
            answer[i] = dist;
        }
        
        
        return answer;
    }
    
    private int hitCorner(int startY, int startX, int destY, int destX, int m, int n) {
        int dist = pow(n) + pow(m);
        
        if (gradient(startY, startX, 0, 0) == gradient(destY, destX, 0, 0) && startY < destY) {
            dist = Math.min(dist, pow(startY) + pow(startX) + pow(destY) + pow(destX));
        }
        
        if (gradient(startY, startX, 0, m) == gradient(destY, destX, 0, m) && startY < destY) {
            dist = Math.min(dist, pow(startY) + pow(m - startX) + pow(destY) + pow(m - destX));
        }
        
        if (gradient(startY, startX, n, 0) == gradient(destY, destX, n, 0) && startY > destY) {
            dist = Math.min(dist, pow(n - startY) + pow(startX) + pow(n - destY) + pow(destX));
        }
        
        if (gradient(startY, startX, n, m) == gradient(destY, destX, n, m) && startY > destY) {
           	dist = Math.min(dist, pow(n - startY) + pow(m - startX) + pow(n - destY) + pow(m - destX));
        }
        
       	return dist; 
    }
    
    private double gradient(int y1, int x1, int y2, int x2) {
        return (double) (y1 - y2) / (x1 - x2);
    }
    
    private boolean checkHitY(int startY, int destY) {
   		return startY != destY; 
    }
    
    private int hitY(int startY, int startX, int destY, int destX, int m) {
        int distY = Math.abs(startY - destY);
        int dist1 = pow(distY) + pow(startX + destX);
        int dist2 = pow(distY) + pow(m - startX + m - destX);
        return Math.min(dist1, dist2);
    }
    
    private boolean checkHitX(int startX, int destX) {
        return startX != destX;
    }
    
    private int hitX(int startY, int startX, int destY, int destX, int n) {
        int distX = Math.abs(startX - destX);
        int dist1 = pow(distX) + pow(startY + destY);
        int dist2 = pow(distX) + pow(n - startY + n - destY);
        return Math.min(dist1, dist2);
    }
    
    private int pow(int num) {
        return num * num;
    }
    
}