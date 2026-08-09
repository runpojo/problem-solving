class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int start = parseToSec(h1, m1, s1);
        int end = parseToSec(h2, m2, s2);
        
        int answer = count(end) - count(start);
        answer += alarmNow(start) ? 1 : 0;
        
        return answer;
    }
    
    private int count(int seconds) {
        int minuteCount = seconds * 59 / 3600;
        int hourCount = seconds * 719 / 43200;
        
        int dupCount = 43200 <= seconds ? 2 : 1;
        
        return minuteCount + hourCount - dupCount;
    }
    
    private int parseToSec(int hour, int minute, int second) {
        return hour * 3600 + minute * 60 + second;
    }
    
    private boolean alarmNow(int seconds) {
        return seconds * 59 / 3600 == 0 || seconds * 719 % 43200 == 0;
    }
}