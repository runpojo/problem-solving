import java.util.*;

class Solution {
    
   	private int answer = 0;
    private Map<Integer, Map<Integer, List<Integer>>> graph;
    
    public int solution(int n, int infection, int[][] edges, int k) {
        graph = new HashMap<>();
        for (int i = 1; i < n + 1; i++) {
            graph.put(i, new HashMap<>());
            for (int type = 1; type < 4; type++) {
                graph.get(i).put(type, new ArrayList<>());
            }
        }
        
        for (int[] edge : edges) {
            int s = edge[0];
            int e = edge[1];
            int type = edge[2];
            graph.get(s).get(type).add(e);
            graph.get(e).get(type).add(s);
        }
        
        int[] order = new int[k];
        Arrays.fill(order, -1);
        
        dfs(0, k, infection, order);
        
        return answer;
    }
    
    private void dfs(int curr, int limit, int start, int[] order) {
        if (curr == limit) {
            answer = Math.max(answer, solve(start, order));
            return;
        }
        
        for (int type = 1; type < 4; type++) {
            order[curr] = type;
            dfs(curr + 1, limit, start, order);
            order[curr] = -1;
        }
        
    }
    
    private int solve(int start, int[] order) {
        List<Integer> infection = new ArrayList<>();
        infection.add(start);
        int count = 1;
        
        Set<Integer> visited = new HashSet<>();
        visited.add(start);
        
        System.out.println("=====================================");
        System.out.println(Arrays.toString(order));
        
        for (int type : order) {
            Deque<Integer> que = new ArrayDeque<>();
            for (int infect : infection) {
                que.add(infect);
            }
            
            while (!que.isEmpty()) {
                int curr = que.pollFirst();
                for (int nxt : graph.get(curr).get(type)) {
                    if (visited.contains(nxt)) {
                        continue;
                    }
                   
                    infection.add(nxt);
                    que.addLast(nxt);
                    count++;
                    visited.add(nxt);
                }
            }
        }
        
        return count;
    }
}