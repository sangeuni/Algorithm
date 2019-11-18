public class Main {
	int exp(int x, int n)
	public String solution(int n, int m, int k) {
		String answer = "";
		long[] arr = new long[1000000001];
		for(int i = 0; i<n; i++) {
			arr[i] = 1;
		}
		for(int j = n; j<n+m; j++) {
			arr[j] = 2;
		}
		
		for(int i= 0; i<n+m; i++) {
			System.out.print(arr[i]);
		}
		return answer;
	}
	
	public static void main(String args[]) {
		Main main = new Main();
		main.go();
	}

	private void go() {
		solution(2,2,5);
	}
}
