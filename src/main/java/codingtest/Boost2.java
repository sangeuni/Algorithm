package codingtest;

public class Boost2 {
    private static int solution(int[] arr1, int[] arr2) {
        CompareStandard standard1 = new CompareStandard();
        CompareStandard standard2 = new CompareStandard();
        standard1 = standard1.findMaxStandard(arr1);
        standard2 = standard1.findMaxStandard(arr2);
        int answer = compareTwoStandard(standard1, standard2);
        return answer;
    }

    private static int compareTwoStandard(CompareStandard standard1, CompareStandard standard2) {
        int answer = 0;

        if (standard1.count == 1 && standard2.count == 1) {
            answer = 0;
        } else if (standard1.count > standard2.count) {
            answer = 1;
        } else if (standard1.count < standard2.count) {
            answer = 2;
        } else if (standard1.count == standard2.count) {
            if (standard1.number > standard2.number) {
                answer = 1;
            } else if (standard1.number < standard2.number) {
                answer = 2;
            } else if (standard1.number == standard2.number) {
                answer = 0;
            }
        }

        return answer;
    }

    public static class CompareStandard {
        private int count;
        private int number;

        public CompareStandard() {
            count = number = 0;
        }

        public CompareStandard(int count, int number) {
            this.count = count;
            this.number = number;
        }

        public CompareStandard findMaxStandard(int[] arr) {
            int[] count = new int[14];
            for (int i = 0; i < arr.length; i++) {
                count[arr[i]]++;
            }

            int maxCount = -1;
            int number = -1;
            for (int i = 0; i < count.length; i++) {
                if (count[i] > maxCount) {
                    maxCount = count[i];
                }
                if (maxCount == count[i]) {
                    if (number < i)
                        number = i;
                }
            }

            if (maxCount == 5)
                maxCount = 4;

            CompareStandard found = new CompareStandard(maxCount, number);
            return found;
        }

    }
}
