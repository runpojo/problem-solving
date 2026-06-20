class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        int n = schedules.length;
        
        for (int employee = 0; employee < n; employee++) {
            if (check(calcDeadline(schedules[employee]), timelogs[employee], startday)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    private boolean check(int deadline, int[] timelog, int startday) {
        int day = startday;
   		for (int i = 0; i < 7; i++) {
            if (day == 6 || day == 7) {
                day = (day % 7) + 1;
                continue;
            }
            
            if (timelog[i] <= deadline) {
                day = (day % 7) + 1;
                continue;
            }
           
            return false;
        }
        
        return true;
    }
    
    private int calcDeadline(int time) {
        int hour = time / 100;
        int minute = time % 100;
        
        int deadMinute = minute + 10;
        if (deadMinute >= 60) {
            hour++;
            deadMinute -= 60;
        }
        
        return hour * 100 + deadMinute;
    }
}