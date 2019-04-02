import java.io.*;
import java.util.Arrays;

public class _2750 {
    // 수 정렬하기

    private void go() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int index = 0;
        for (int i = 0; i < n; i++) {
            arr[index++] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            bw.write(Integer.toString(arr[i]) + "\n");

        }
        bw.flush();
        bw.close();
    }
}
