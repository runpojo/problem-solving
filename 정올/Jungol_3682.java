import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Jungol_3682 {

  static StringBuilder sb = new StringBuilder();
  private static int n, m;
  private static String[] cloud;
  private static int[][] answer;

  public static void main(String[] args) throws IOException {
    input();

    answer = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        answer[i][j] = -1;
      }
    }

    for (int row = 0; row < n; row++) {
      boolean isMet = false;
      int dist = 0;
      for (int col = 0; col < m; col++) {
        if (cloud[row].charAt(col) == 'c') {
          isMet = true;
          dist = 0;
        } else {
          dist++;
        }

        if (isMet) {
          answer[row][col] = dist;
        }
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        sb.append(answer[i][j]).append(" ");
      }
      sb.append("\n");
    }

    output();
  }

  private static void input() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    cloud = new String[n];
    for (int i = 0; i < n; i++) {
      cloud[i] = br.readLine();
    }
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}
