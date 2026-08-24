import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Jungol_11053 {

  static StringBuilder sb = new StringBuilder();
  private static int n, m;
  private static int[][] a, b;
  private static int[] order;

  public static void main(String[] args) throws IOException {
    input();

    int[] diff = new int[n + 1];
    for (int col = 1; col < n + 1; col++) {
      int max = -1;
      for (int row = 1; row < n + 1; row++) {
        max = Math.max(max, Math.abs(a[row][col] - b[row][col]));
      }
      diff[col] = max;
    }

    int answer = 0;
    for (int i = 0; i < m; i++) {
      answer += diff[order[i]];
    }

    sb.append(answer);
    output();
  }

  private static void input() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    a = new int[n + 1][n + 1];
    b = new int[n + 1][n + 1];
    for (int i = 1; i < n + 1; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j < n + 1; j++) {
        a[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    for (int i = 1; i < n + 1; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j < n + 1; j++) {
        b[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    order = new int[m];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < m; i++) {
      order[i] = Integer.parseInt(st.nextToken());
    }
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}
