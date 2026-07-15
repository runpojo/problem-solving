import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int curr = 1;
        int answer = 0;
        
        for (int station : stations) {
            if (curr < station - w) {
                int dist = station - w - curr;
                answer += (int) Math.ceil((double) dist / (2 * w + 1));
            }
            curr = station + w + 1;
        }
        
        if (0 < n - curr + 1) {
            int dist = n - curr + 1;
            answer += (int) Math.ceil((double) dist / (2 * w + 1));
        }

        return answer;
    }
}