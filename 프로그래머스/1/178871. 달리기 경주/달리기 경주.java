import java.util.*;

class Solution {
    
    private Map<String, Integer> playersMap;
    private Map<Integer, String> grades;
    
    public String[] solution(String[] players, String[] callings) {
        
        int n = players.length;
        playersMap = new HashMap<>();
        grades = new HashMap<>();
        
        for (int i = 1; i < n + 1; i++) {
            String player = players[i - 1];
            playersMap.put(player, i);
            grades.put(i, player);
        }
        
        for (String calling : callings) {
            String player = calling;
            int grade = playersMap.get(player);
            String prevPlayer = grades.get(grade - 1);
            
            playersMap.put(player, grade - 1);
            playersMap.put(prevPlayer, grade);
            grades.put(grade - 1, player);
            grades.put(grade, prevPlayer);
        }
        
        String[] answer = new String[n];
        for (int i = 1; i < n + 1; i++) {
            answer[i - 1] = grades.get(i);
        }
        
        return answer;
    }
}