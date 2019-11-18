public class Main {
	int[][] arr = {{1,2},{3,4}};
	public int[][] solution(int[][] map, int r) {
		int answer[][] = new int[map.length][map.length];
		int x[][] = map;
		for(int i = 0; i<r; i++) {
			answer = rotation(x);
			x = answer;
		}
		return answer;
	}
	
	public int[][] rotation(int[][] arr){
		int n = arr.length;
		int[][] temp = new int[n][n];
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				temp[i][j] = arr[n-1-j][i];
			}
		}
		return temp;
	}
	public static void main(String args[]) {
		Main main = new Main();
		main.go();
	}

	private void go() {
		int[][] temp = solution(arr,3);
		
		for(int i = 0; i<temp.length; i++) {
			for(int j = 0; j<temp.length; j++) {
				System.out.print(temp[i][j]);
			}
			System.out.println();
		}
	}
}
