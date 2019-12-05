package programmers.level2;

public class _001 {
    /*
     * Level2 - 점프와 순간이동
     *
     * Description : K칸을 앞으로 점프하려면 건전지를 1회 사용,
     *               *2의 위치로 순간이동하면 건전지 사용량 줄지 않음.
     *               최소의 건전지 사용량으로 이동하는 방법
     * Input : 이동하려는 거리 n
     * Output : 건전지 사용량
     *
     * */

    public int solution(int n) {
        // 1칸 점프할 때 감소
        int sub = 1;
        // 건전지 사용량
        int ans = 0;
        while (n != 0) {
            // 이동거리가 홀수일 때 점프
            if (n % 2 == 1) {
                n -= sub;
                ans += 1;
            }
            // 순간이동
            n /= 2;
        }
        return ans;
    }
}

