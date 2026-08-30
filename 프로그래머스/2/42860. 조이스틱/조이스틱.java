class Solution {
   
    public int solution(String name) {
        int length = name.length();
        char[] array = name.toCharArray();
        
        int upDownCount = 0;
        int leftRightCount = length - 1;
        for (int i = 0; i < length; i++) {
            upDownCount += Math.min(array[i] - 'A', 'Z' - array[i] + 1);
            
            int next = i + 1;
            while (next < length && array[next] == 'A') {
                next++;
            }
            
            leftRightCount = Math.min(leftRightCount, i * 2 + length - next);
            leftRightCount = Math.min(leftRightCount, (length - next) * 2 + i);
        }
        
        int answer = upDownCount + leftRightCount;
        return answer;
    }
}