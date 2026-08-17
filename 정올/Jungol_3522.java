import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Jungol_3522 {

  static StringBuilder sb = new StringBuilder();

  private static final int MOD = 1_000_000_007;
  private static int n;

  public static void main(String[] args) throws IOException {
    input();

    int[] dp = new int[n + 1];
    dp[1] = 1;
    dp[2] = 1;

    for (int i = 3; i < n + 1; i++) {
      dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
    }

    sb.append(dp[n]);
    output();
  }

  private static void input() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}
