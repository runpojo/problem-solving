import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        
        int gcdA = arrayA[0];
        int gcdB = arrayB[0];
        for (int i = 1; i < arrayA.length; i++) {
            gcdA = getGCD(gcdA, arrayA[i]);
            gcdB = getGCD(gcdB, arrayB[i]);
        }
        
        int answer = 0;
        
        if (check(arrayA, gcdB)) {
            answer = Math.max(answer, gcdB);
        }
        
        if (check(arrayB, gcdA)) {
            answer = Math.max(answer, gcdA);
        }
       
        return answer;
    }
    
    private boolean check(int[] array, int gcd) {
       	for (int i = 0; i < array.length; i++) {
            if (array[i] % gcd == 0) {
                return false;
            }
        }
        
        return true;
    }
    
    private int getGCD(int bigger, int smaller) {
        if (smaller == 0) {
            return bigger;
        }
        
        return getGCD(smaller, bigger % smaller);
    }
}