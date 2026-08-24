import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Jungol_6982 {

  static StringBuilder sb = new StringBuilder();
  private static int n;
  private static int[] numbers;
  private static int[] prefixMax;

  public static void main(String[] args) throws IOException {
    input();

    int answer = 0;
    for (int i = 0; i < n; i++) {
      answer = Math.max(answer, prefixMax[i] - numbers[i]);
    }

    sb.append(answer);
    output();
  }

  private static void input() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());
    numbers = new int[n];
    prefixMax = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      numbers[i] = Integer.parseInt(st.nextToken());
    }

    prefixMax[n - 1] = numbers[n - 1];
    for (int i = n - 2; i > -1; i--) {
      prefixMax[i] = Math.max(prefixMax[i + 1], numbers[i]);
    }
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}
