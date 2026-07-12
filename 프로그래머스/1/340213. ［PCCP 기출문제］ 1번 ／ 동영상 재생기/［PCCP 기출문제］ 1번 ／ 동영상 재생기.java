class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int totalLength = parseTime(video_len);
        int startPosition = parseTime(pos);
        int opStart = parseTime(op_start);
        int opEnd = parseTime(op_end);
        
        int currTime = startPosition;
        if (opStart <= currTime && currTime <= opEnd) {
            currTime = opEnd;
        }
        for (String cmd : commands) {
            currTime = execute(cmd, currTime);
            currTime = Math.max(currTime, 0);
            currTime = Math.min(currTime, totalLength);
            if (opStart <= currTime && currTime <= opEnd) {
                currTime = opEnd;
            }
        }
        
        int m = currTime / 60;
        int s = currTime % 60;
        
        String answer = String.format("%02d", m) + ":" + String.format("%02d", s);
        return answer;
    }
    
    private int execute(String cmd, int currTime) {
        switch (cmd) {
            case "next":
                return currTime + 10;
            case "prev":
                return currTime - 10;
            default:
                return currTime;
        }
    }
    
    private int parseTime(String t) {
        String min = t.split(":")[0];
        String sec = t.split(":")[1];
        return 60 * Integer.parseInt(min) + Integer.parseInt(sec);
    }
    
}