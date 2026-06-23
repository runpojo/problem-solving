class Solution {
    public int solution(int[][] signals) {
        int answer = 0;
        int n = signals.length;
        int maxTime = 1;
        for (int i = 0; i < n; i++) {
            int g = signals[i][0];
            int y = signals[i][1];
            int r = signals[i][2];
            
            maxTime = lcm(maxTime, g + y + r);
        }
        
        for(int t = 1; t <= maxTime; t++){
            boolean isAllYellow = true;
            for(int i = 0; i < n; i++){
                int g = signals[i][0];
                int y = signals[i][1];
                int r = signals[i][2];
                int C = g + y + r;
                
                int remain = (t-1) % C;
                
                if(!(g <= remain && remain < g + y)) {
                    isAllYellow = false;
                    break;
                }
            }
            
            if (isAllYellow) {
                return t;
            }
        }
        
        return -1;
    }
    
    private int gcd(int a, int b) {
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }
    
    private int lcm(int a, int b) {
        if (a == 0 || b == 0) {
            return 0;
        }
        return (a * b) / gcd(a, b);
    }
}