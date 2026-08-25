import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Jungol_6235 {

  static StringBuilder sb = new StringBuilder();
  private static String[][] prediction;
  private static boolean[] isVisited;
  private static String[] selected;
  private static Map<String, Boolean> map;
  private static Set<String> candidates;
  private static final String ALPHA = "_ABCD";

  public static void main(String[] args) throws IOException {
    input();

    perm(0);

    if (candidates.size() != 1) {
      sb.append(5);
    } else {
      String secondRunner = candidates.stream().findFirst().get();
      sb.append(ALPHA.indexOf(secondRunner));
    }
    output();
  }

  private static void perm(int cur) {
    if (cur == 3) {
      candidates.add(selected[1]);
      return;
    }

    for (int i = 0; i < 3; i++) {
      if (isVisited[i]) {
        continue;
      }

      String curRunner = prediction[i][cur];
      if (map.get(curRunner)) {
        continue;
      }

      boolean isDup = false;
      for (int j = 0; j < 3; j++) {
        if (i == j) {
          continue;
        }

        if (prediction[j][cur].equals(curRunner)) {
          isDup = true;
          break;
        }
      }

      if (isDup) {
        continue;
      }

      isVisited[i] = true;
      map.put(curRunner, true);
      selected[cur] = curRunner;
      perm(cur + 1);
      map.put(curRunner, false);
      isVisited[i] = false;
    }
  }

  private static void input() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    prediction = new String[3][3];
    for (int i = 0; i < 3; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 3; j++) {
        prediction[i][j] = st.nextToken();
      }
    }
    isVisited = new boolean[3];
    selected = new String[3];
    map = new HashMap<>();
    map.put("A", false);
    map.put("B", false);
    map.put("C", false);
    map.put("D", false);
    candidates = new HashSet<>();
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}
