import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Jungol_5226 {

  static StringBuilder sb = new StringBuilder();
  private static String s;

  public static void main(String[] args) throws IOException {
    input();

    int LCount = 0;
    int RCount = 0;
    int n = s.length();
    for (int i = 0; i < n; i++) {
      if (s.charAt(i) == 'L') {
        LCount++;
      } else {
        RCount++;
      }
    }

    int visitedLCount = 0;
    int answer = Math.max(LCount, RCount);
    for (int i = 0; i < n - 1; i++) {
      if (s.charAt(i) == 'L') {
        visitedLCount++;
      } else {
        RCount--;
      }

      answer = Math.max(answer, visitedLCount + RCount);
    }

    sb.append(answer);
    output();
  }

  private static void input() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    s = br.readLine();
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}
