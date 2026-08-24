import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Jungol_10450 {

  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int tcCounts = Integer.parseInt(br.readLine());
    for (int tc = 0; tc < tcCounts; tc++) {
      sb.append("Case #").append(tc + 1).append(": ");

      int n = Integer.parseInt(br.readLine());
      int[] colors = new int[n];
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < n; i++) {
        colors[i] = Integer.parseInt(st.nextToken());
      }

      Map<Integer, Integer> numberPerColor = new HashMap<>();
      Map<Integer, Integer> colorPerNumber = new HashMap<>();

      if (!solve(numberPerColor, colorPerNumber, n, colors)) {
        sb.append("IMPOSSIBLE").append("\n");
        continue;
      }

      for (int i = 1; i < colorPerNumber.size() + 1; i++) {
        sb.append(colorPerNumber.get(i)).append(" ");
      }

      sb.append("\n");
    }

    output();
  }

  private static boolean solve(Map<Integer, Integer> numberPerColor, Map<Integer, Integer> colorPerNumber, int n, int[] colors) {
    int number = 1;
    for (int i = 0; i < n; i++) {
      int curColor = colors[i];
      if (numberPerColor.containsKey(curColor)) {
        int prevColor = colors[i - 1];
        if (numberPerColor.get(prevColor) > numberPerColor.get(curColor)) {
          return false;
        }
        continue;
      }

      numberPerColor.put(curColor, number);
      colorPerNumber.put(number, curColor);
      number++;
    }

    return true;
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}
