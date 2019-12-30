package codingtest;

import java.util.LinkedList;
import java.util.Queue;


public class MineSweeper {
	String[] input;
	char[][] map;
	int[][] visited;
	int[] dx = {1,-1,0,0,-1,-1,1,1};
	int[] dy = {0,0,1,-1,-1,1,-1,1};
	
	class Dot{
		int x,y;
		public Dot(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public void go() {
		input = new String[]{"EEEEE", "EEMEE", "EEEEE", "EEEEE"};
		int n = input.length;
		int m = input[0].length();
		int x = 0; int y = 2;
		map = new char[n][m];
		visited = new int[n][m];
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				map[i][j] = input[i].charAt(j);
			}
		}
		
		BFS(y,x,n,m);
		print();
		
	}

	public void BFS(int x, int y, int n, int m) {
		Queue<Dot> q = new LinkedList<>();
		q.offer(new Dot(x,y));
		visited[x][y] = 1;
		
		while(!q.isEmpty()) {
			Dot cur = q.poll();
			int nx, ny;
			for(int i = 0; i<8; i++) {
				nx = cur.x + dx[i];
				ny = cur.y + dy[i];
				
				if(nx < 0 || ny <0 || nx >= n || ny >= m)
					continue;
				
				if(visited[nx][ny] == 1 ) continue;
				
				if(map[nx][ny] == 'M') {
					map[cur.x][cur.y]++;
					continue;
				}
				
				q.offer(new Dot(nx,ny));
				visited[nx][ny] = 1;
			}
		}
		
	}
	public void print() {
		for(int i = 0; i<map.length; i++) {
			for(int j = 0; j<map[i].length; j++)
				System.out.print(map[i][j]+" ");
			System.out.println();
		}
	}
}
