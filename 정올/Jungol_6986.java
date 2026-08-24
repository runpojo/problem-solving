import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Jungol_6986 {

  static StringBuilder sb = new StringBuilder();
  private static int n;
  private static int[] numbers;

  public static void main(String[] args) throws IOException {
    input();

    long max = -1;
    long min = Long.MAX_VALUE;
    for (int i = 1; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        for (int k = j + 1; k < n; k++) {
          long total = solve(i, j, k);
          max = Math.max(max, total);
          min = Math.min(min, total);
        }
      }
    }

    sb.append(max).append("\n").append(min);
    output();
  }

  private static long solve(int n1, int n2, int n3) {
    long total = 0;

    long loc1 = 1;
    for (int i = 0; i < n1; i++) {
      loc1 *= numbers[i];
    }
    total += loc1;

    long loc2 = 1;
    for (int i = n1; i < n2; i++) {
      loc2 *= numbers[i];
    }
    total += loc2;

    long loc3 = 1;
    for (int i = n2; i < n3; i++) {
      loc3 *= numbers[i];
    }
    total += loc3;

    long loc4 = 1;
    for (int i = n3; i < n; i++) {
      loc4 *= numbers[i];
    }
    total += loc4;

    return total;
  }

  private static void input() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());
    numbers = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      numbers[i] = Integer.parseInt(st.nextToken());
    }
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}
