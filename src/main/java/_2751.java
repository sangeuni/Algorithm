import java.io.*;
// Merge Sort
public class _2751 {
    static int[] tmp; // merge() 안에서 생성했을 때 시간초과 나벌임;;

    private void go() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];
        tmp = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        mergeSort(array, 0, array.length - 1);

        for (int i =0; i<n;i++){
            bw.write(array[i]+"\n");
        }
        bw.flush();
        bw.close();
    }

    private void mergeSort(int[] arr, int low, int high) {
        int mid;
        if (low < high) {
            mid = (low + high) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    private void merge(int[] arr, int low, int mid, int high) {

        int index = low, p1 = low, p2 = mid + 1;
        while (p1 <= mid && p2 <= high) {
            if (arr[p1] < arr[p2]) {
                tmp[index++] = arr[p1++];
            } else {
                tmp[index++] = arr[p2++];
            }
        }

        if (p1 > mid) {
            for (int i = p2; i <= high; i++)
                tmp[index++] = arr[i];
        } else {
            for (int i = p1; i <= mid; i++)
                tmp[index++] = arr[i];
        }

        for (int i = low; i <= high; i++) {
            arr[i] = tmp[i];
        }
    }
}