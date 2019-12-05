package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _11650 {
    private void go() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Coordinate> list = new LinkedList<>();

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            list.add(new Coordinate(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(list, new Comparator<Coordinate>() {
            @Override
            public int compare(Coordinate o1, Coordinate o2) {
                return o1.x > o2.x ? 1 : o1.x == o2.x ? (o1).compareTo(o2) : -1;
            }
        });
        br.close();
        for (Coordinate c : list) {
            System.out.println(c);
        }
    }

    public class Coordinate implements Comparable<Coordinate> {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Coordinate o) {
            return this.y > o.y ? 1 : this.y == o.y ? 0 : -1;
        }

        @Override
        public String toString() {
            return this.x + " " + this.y;
        }
    }
}
