class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            answer[i] = solve(numbers[i]);
        }
        return answer;
    }
    
    private long solve(long number) {
        long num = number;
        int count = 0;
        
        while (num % 2 == 1) {
            count ++;
            num /= 2;
        }
        
        if (count == 0) {
            return number + 1;
        }
        
        return number + (long) Math.pow(2, count - 1);
    }
}