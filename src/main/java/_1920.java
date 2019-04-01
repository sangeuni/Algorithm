import java.io.*;
import java.util.*;

public class _1920 {

    public static void main(String[] args) throws IOException {
        _1920 main = new _1920();
        main.go();

    }

    private void go() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String line = br.readLine();
        int[] arr1 = inputNum(n, line);

        int m = Integer.parseInt(br.readLine());
        String line2 = br.readLine();
        int[] arr2 = inputNum(m, line2);

        br.close();

        // 오름차순 정렬
        Arrays.sort(arr1);

        // 이진 탐색
        for (int i = 0; i < m; ++i) {
            if (-1 == binarySearch(arr1, arr2[i], 0, n - 1))
                bw.write(0+"\n");
            else
                bw.write(1+"\n");

        }
        bw.flush();
        bw.close();

    }

    private int binarySearch(int[] arr, int val, int lo, int high) {
        if (lo > high) return -1;

        int mid = (lo + high) / 2;
        if (arr[mid] == val) return mid;
        if (arr[mid] < val) return binarySearch(arr, val, mid + 1, high);
        else return binarySearch(arr, val, lo, mid-1);

    }

    private int[] inputNum(int n, String line) {
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(line, " ");

        int index = 0;
        while(st.hasMoreTokens()){
            arr[index++] = Integer.parseInt(st.nextToken());
        }
        return arr;
    }
}