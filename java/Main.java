import java.util.Scanner;

public class Main {
	public void go() {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int count = 0;

		for (int i = 0; i < size; i++) {
			int n = sc.nextInt();
			if (isPrime(n))
				count++;
		}
		System.out.println(count);
	}

	public boolean isPrime(int n) {
		if (n < 2)
			return false;
		for (int j = 2; j <= n - 1; j++) {
			if (n % j == 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Main main = new Main();
		main.go();
	}
}