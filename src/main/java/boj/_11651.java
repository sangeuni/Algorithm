package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _11651 {
    private void go() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Coordinate> list = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            String pair = br.readLine();
            StringTokenizer st = new StringTokenizer(pair, " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new Coordinate(x, y));
        }
        br.close();

        Collections.sort(list, new Comparator<Coordinate>() {
            @Override
            public int compare(Coordinate o1, Coordinate o2) {
                return o1.y > o2.y ? 1 : o1.y == o2.y ? o1.compareTo(o2) : -1;
            }
        });

        for (Coordinate c : list) {
            System.out.println(c);
        }
    }

    public class Coordinate {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int compareTo(Coordinate o) {
            return this.x > o.x ? 1 : this.x == o.x ? 0 : -1;
        }

        @Override
        public String toString() {
            return this.x + " " + this.y;
        }
    }
}
