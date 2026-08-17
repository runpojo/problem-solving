import java.util.*;

class Solution {
    
    private static final int FRIEND_COUNT = 8;
    private static final char[] FRIENDS = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    
    private static Map<Integer, List<Cond>> condMap = new HashMap<>();
    
    public int solution(int n, String[] data) {
        for (int i = 0; i < FRIEND_COUNT; i++) {
            condMap.put(i, new ArrayList<>());
        }
        
        for (String dat : data) {
            int from = convertFriendToNumber(dat.charAt(0));
            int to = convertFriendToNumber(dat.charAt(2));
            char type = dat.charAt(3);
            int dist = dat.charAt(4) - '0';
            condMap.get(from).add(new Cond(to, type, dist));
            condMap.get(to).add(new Cond(from, type, dist));
        }
        
        int[] position = new int[FRIEND_COUNT];
        Arrays.fill(position, -1);
        
        int answer = comb(0, position);
        return answer;
    }
    
    private int comb(int curr, int[] position) {
        if (curr == FRIEND_COUNT) {
            return 1;
        }
        
        int total = 0;
        for (int friend = 0; friend < FRIEND_COUNT; friend++) {
            // 이미 자리를 잡은 경우
            if (position[friend] != -1) {
                continue;
            }
            
            // 조건 확인하기
            if (!checkCond(curr, position, friend)) {
                continue;
            }
            
            position[friend] = curr;
            total += comb(curr + 1, position);
            position[friend] = -1;
        }
        
        return total;
    }
    
    // true: 조건을 만족한 경우 / false: 조건을 만족하지 못한 경우
    private boolean checkCond(int curr, int[] position, int currFriend) {
        for (Cond cond : condMap.get(currFriend)) {
            int targetPosition = position[cond.target];
            
            if (targetPosition == -1) {
                continue;
            }
            
            if ('=' == cond.type) {
                if (calcDist(curr, targetPosition) != cond.dist) {
                    return false;
                }
            } else if ('<' == cond.type) {
                if (calcDist(curr, targetPosition) >= cond.dist) {
                    return false;
                }
            } else if ('>' == cond.type) {
                if (calcDist(curr, targetPosition) <= cond.dist) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private int calcDist(int position1, int position2) {
        return Math.abs(position2 - position1) - 1;
    }
    
    private int convertFriendToNumber(char friendName) {
        for (int i = 0; i < FRIEND_COUNT; i++) {
            if (FRIENDS[i] == friendName) {
                return i;
            }
        }
        return -1;
    }
    
    private class Cond {
        int target;
        char type;
        int dist;
        
        public Cond(int target, char type, int dist) {
            this.target = target;
            this.type = type;
            this.dist = dist;
        }
    }
}