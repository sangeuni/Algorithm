package sort;

import java.io.*;

public class CountingSort {

    private void go() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n];
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        int[] accumulate = new int[findMax(numbers) + 1]; // 누적 배열 생성

        for(int i = 0; i<numbers.length;i++){
            accumulate[numbers[i]]++;
        }

        for(int i =1; i< accumulate.length;i++){
            accumulate[i] += accumulate[i-1];
        }

        for(int i = numbers.length-1; i>=0; i--){
            result[--accumulate[numbers[i]]] = numbers[i];
        }

        for (int i = 0; i < result.length; i++) {
            bw.write(Integer.toString(result[i]));
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }

    private int findMax(int[] numbers) {
        int max = -1;
        for (int i = 0; i < numbers.length; i++) {
            if (max < numbers[i]) max = numbers[i];
        }
        return max;
    }

}
