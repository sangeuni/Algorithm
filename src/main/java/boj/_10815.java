package boj;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _10815 {

    private void go() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr1 = toArray(n, br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] arr2 = toArray(m, br.readLine());

        Arrays.sort(arr1);

        for(int i =0; i<arr2.length;i++){
            if(binarySearch(arr1,arr2[i],0,arr1.length-1) == -1) {
                bw.write(Integer.toString(0)+" ");
            }else bw.write(Integer.toString(1)+" ");
        }

        bw.flush();
        bw.close();
    }

    private int binarySearch(int[] arr, int val, int low, int high) {
        if(low>high) return -1;
        int mid = (low+high)/2;
        if(arr[mid] == val) return mid;
        if(arr[mid] > val) return binarySearch(arr, val, low, mid-1);
        else return binarySearch(arr, val, mid+1, high);
    }

    private int[] toArray(int len, String line) {
        int index = 0;
        int[] arr = new int[len];
        StringTokenizer stz = new StringTokenizer(line, " ");
        while (stz.hasMoreTokens()) {
            arr[index++] = Integer.parseInt(stz.nextToken());
        }
        return arr;
    }
}
