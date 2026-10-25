import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        
        String[] arr = Arrays.stream(numbers)
            .mapToObj(num -> String.valueOf(num))
            .toArray(String[]::new);
        
        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));
        
        if ("0".equals(arr[0])) {
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        
        return sb.toString();
    }
}