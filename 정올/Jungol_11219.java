import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Jungol_11219 {

  static StringBuilder sb = new StringBuilder();
  private static int n;
  private static Map<Integer, Pair> map = new HashMap<>();
  private static int start;

  public static void main(String[] args) throws IOException {
    input();

    int curr = start;
    for (int i = 0; i < n; i++) {
      Pair pair = map.get(curr);
      if ("L".equals(pair.direction)) {
        curr -= pair.dist;
      } else {
        curr += pair.dist;
      }
    }

    sb.append(curr);
    output();
  }

  private static void input() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int from = Integer.parseInt(st.nextToken());
      String direction = st.nextToken();
      int dist = Integer.parseInt(st.nextToken());

      map.put(from, new Pair(direction, dist));
    }
    start = Integer.parseInt(br.readLine());
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

  private static class Pair {

    String direction;
    int dist;

    public Pair(String direction, int dist) {
      this.direction = direction;
      this.dist = dist;
    }
  }

}
