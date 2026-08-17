import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Jungol_19943 {

  static StringBuilder sb = new StringBuilder();
  private static int n;
  private static int[] heights;
  private static int[] frontCounts;

  public static void main(String[] args) throws IOException {
    input();

    int[] answer = new int[n];
    boolean[] isUsed = new boolean[n];

    for (int i = n - 1; i > -1; i--) {
      answer[i] = findHeight(frontCounts[i], isUsed);
    }

    for (int i = 0; i < n; i++) {
      sb.append(answer[i]).append(" ");
    }
    output();
  }

  private static int findHeight(int count, boolean[] isUsed) {
    int c = 0;
    for (int i = n - 1; i > -1; i--) {
      if (isUsed[i]) {
        continue;
      }
      if (c != count) {
        c++;
        continue;
      }
      isUsed[i] = true;
      return heights[i];
    }

    return -1;
  }

  private static void input() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());
    heights = new int[n];
    frontCounts = new int[n];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      heights[i] = Integer.parseInt(st.nextToken());
    }
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      frontCounts[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(heights);
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}
