import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (o1, o2) -> Integer.compare(o1[1], o2[1]));
        
        int answer = 0;
        int camera = -30_001;
        
        for (int[] route : routes) {
            int start = route[0];
            int end = route[1];
            
            if (camera < start) {
                answer ++;
                camera = end;
            }
        }
        
        return answer;
    }
}