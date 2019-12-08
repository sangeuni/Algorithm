import java.util.Scanner;

public class Main {
	int[][] map;
	int[] dx = { 1, -1, 0, 0, -1, -1, 1, 1 };
	int[] dy = { 0, 0, 1, -1, -1, 1, -1, 1 };
	int n, mine;
	class Dot {
		private int x,y;
		public Dot(int x, int y) {
			this.x  = x;
			this.y = y;
		}
	}
	public void go() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		if(n<=2) {
			System.out.println(0);
			return;
		}
		
		map = new int[n][n];
		sc.nextLine();
		String str;
		for (int i = 0; i < n; i++) {
			str = sc.nextLine();
			for (int j = 0; j < n; j++) {
				try {
					map[i][j] = Character.getNumericValue(str.charAt(j));
				}catch(Exception e) {
					map[i][j] = -1;
				}
			}
		}
		
		mine = (n-2) * (n-2);
		print();
		for (int i = 1; i < n-1; i++) {
			for (int j = 1; j < n-1; j++) {
				search(new Dot(i,j));
			}
		}
		System.out.println(mine);
		print();
	}

	public void search(Dot dot) {
		if(checkZero(dot)) {
			mine--;
		}else {
			int nx,ny;
			for(int i = 0; i<8; i++) {
				nx = dot.x + dx[i];
				ny = dot.y + dy[i];
				
				if(nx <0 || ny <0 || nx>=n || ny >= n)
					continue;
				
				if(map[nx][ny] >= 0)
					map[nx][ny]--;
	 		}
		}

	}
	
	public boolean checkZero(Dot dot) {
		int nx,ny;
		for(int i = 0; i<8; i++) {
			nx = dot.x + dx[i];
			ny = dot.y + dy[i];
			
			if(nx <0 || ny <0 || nx>=n || ny >= n)
				continue;
		
			if(map[nx][ny] == 0) return true;
 		}
		return false;
	}
	
	public void print() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Main main = new Main();
		main.go();
	}
}