import java.util.*;

class Solution {
    
    private Map<String, Integer> friendIdMap = new HashMap<>();
    private int[][] count;
    private int[] a; // 준 선물 수
    private int[] b; // 받은 선물 수
    
    public int solution(String[] friends, String[] gifts) {
        int n = friends.length;
        for (int i = 0; i < n; i++) {
            friendIdMap.put(friends[i], i);
        }
        count = new int[n][n];
        a = new int[n];
        b = new int[n];
        
        for (String gift : gifts) {
            String[] splited = gift.split(" ");
           	String from = splited[0];
           	String to = splited[1];
            int fromId = friendIdMap.get(from);
            int toId = friendIdMap.get(to);
            count[fromId][toId]++;
            a[fromId]++;
           	b[toId]++; 
        }
        
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isMet(i, j)) {
                    if (count[i][j] > count[j][i]) {
                        result[i]++;
                    } else if (count[i][j] == count[j][i]) {
                        if ((a[j] - b[j]) < (a[i] - b[i])) {
                            result[i]++;
                        }
                    }
                } else if (!isMet(i, j)) {
                    if ((a[j] - b[j]) < (a[i] - b[i])) {
                        result[i]++;
                    }
                }
            }
        }
        
        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, result[i]);
        }
        return answer;
    }
    
    private boolean isMet(int a, int b) {
        return count[a][b] != 0 || count[b][a] != 0;
    }
}