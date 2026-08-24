import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Jungol_8177 {

  static StringBuilder sb = new StringBuilder();
  private static int n, q;
  private static int[][] questions;
  private static int[][][] blocks;

  public static void main(String[] args) throws IOException {
    input();

    int totalCount = 0;
    for (int i = 0; i < q; i++) {
      int targetX = questions[i][0];
      int targetY = questions[i][1];
      int targetZ = questions[i][2];

      blocks[0][targetX][targetY]++;
      blocks[1][targetY][targetZ]++;
      blocks[2][targetZ][targetX]++;

      int c = 0;
      if (blocks[0][targetX][targetY] == n) {
        c++;
      }
      if (blocks[1][targetY][targetZ] == n) {
        c++;
      }
      if (blocks[2][targetZ][targetX] == n) {
        c++;
      }

      totalCount += c;
      sb.append(totalCount).append("\n");
    }

    output();
  }

  private static void input() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    q = Integer.parseInt(st.nextToken());

    blocks = new int[3][n][n];
    questions = new int[q][3];

    for (int i = 0; i < q; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 3; j++) {
        questions[i][j] = Integer.parseInt(st.nextToken());
      }
    }
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}
