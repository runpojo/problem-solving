import java.util.*;

class Solution {
    
    Map<String, List<Integer>> scoresByConditions;
    
    public int[] solution(String[] info, String[] query) {
        scoresByConditions = new HashMap<>();
        for (String singleInfo : info) {
            String[] splited = singleInfo.split(" ");
            String[] cond = Arrays.copyOfRange(splited, 0, splited.length - 1);
            int score = Integer.parseInt(splited[splited.length - 1]);
            insertInfo(cond, score, 0, "");
        }
        
        for (String key : scoresByConditions.keySet()) {
            List<Integer> scores = scoresByConditions.get(key);
            scores.sort((o1, o2) -> o1 - o2);
        }
        
        int[] answer = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            String q = query[i];
            String[] splited = q.split(" ");
            String cond = makeCondKey(Arrays.copyOfRange(splited, 0, splited.length - 1));
            int score = Integer.parseInt(splited[splited.length - 1]);
            answer[i] = find(cond, score);
        }
        
        return answer;
    }
    
    private int find(String cond, int score) {
        if (!scoresByConditions.containsKey(cond)) {
           	return 0; 
        }
        
        List<Integer> scores = scoresByConditions.get(cond);
        int left = 0;
        int right = scores.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int midScore = scores.get(mid);
            if (midScore < score) {
               	left = mid + 1; 
            } else {
                right = mid - 1;
            }
        }
       
        return scores.size() - left;
    }
    
    private String makeCondKey(String[] query) {
        StringBuilder sb = new StringBuilder();
        for (String q : query) {
            if (q.equals("and")) {
                continue;
            }
            if (q.equals("-")) {
                continue;
            }
            sb.append(q);
        }
        return sb.toString();
    }
    
    private void insertInfo(String[] info, int score, int curr, String prev) {
        if (curr == info.length) {
            String cond = prev;
            scoresByConditions.putIfAbsent(cond, new ArrayList<>());
            scoresByConditions.get(cond).add(score);
            return;
        }
        
        insertInfo(info, score, curr + 1, prev);
        insertInfo(info, score, curr + 1, prev + info[curr]);
    }
}